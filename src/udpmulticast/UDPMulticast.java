package udpmulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import static udpmulticast.Panel_JoinGroup.clientList;

public class UDPMulticast {

    static JSONObject jObj = new JSONObject();
    static MulticastSocket x;
    static InetSocketAddress sockAddr;
    
    static public NetworkInterface netInterface() {
        NetworkInterface netIF = null;
        Enumeration<NetworkInterface> enumNetIF = null;
        try {
            enumNetIF = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex) {
            Logger.getLogger(UDPMulticast.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (enumNetIF.hasMoreElements()) {
            netIF = enumNetIF.nextElement();
            try {
                if (netIF.isLoopback()) {
                    break;
                }
            } catch (SocketException ex) {
                Logger.getLogger(UDPMulticast.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return netIF;
    }

    public static void main(String[] args) throws InterruptedException {
        Window window = new Window();
        window.setVisible(true);
        window.setLocationRelativeTo(null);

        try {
            InetAddress multicastAddr = InetAddress.getByName("224.0.0.2");
            sockAddr = new InetSocketAddress(multicastAddr, 50000);
            x = new MulticastSocket(50000);
            x.joinGroup(sockAddr, netInterface());

            //Panel_Chat receive = new Panel_Chat(multicastSock);
            Panel_Chat receive = new Panel_Chat(x);
            try {
                receive.t1.start();
            } catch (IllegalThreadStateException ex) {
                Logger.getLogger(UDPMulticast.class.getName()).log(Level.SEVERE, null, ex);
            }
            //buffer de comunicação
            byte[] txData = new byte[65507];

            while (true) {
                // thread para aparecer as mensagens no terminal (verificação do terminal)
                // na interface gráfica também não aparece a msg caso não tenha essa thread
                Thread.sleep(500);

                // adicionar/remover elementos no objeto json
                // msg deve ser o primeiro elemento a ser adicionado
                // enquanto os outros elementos devem estar null, isso que o if verifica
                boolean valida = true;
                try {
                    clientList.get(0);
                    if (jObj.isEmpty()) {
                        throw new EmptyException();
                    }
                } catch (EmptyException | IndexOutOfBoundsException e) {
                    valida = false;
                }
                if (valida == true && jObj.get("message_value") != null) {
                    if (Panel_Chat.lst_users.isSelectionEmpty()) {
                        // se nenhum user foi selecionado, não é possível determinar quem está mandando mensagem
                        JOptionPane.showMessageDialog(null, "Select a user", "Error", JOptionPane.ERROR_MESSAGE);
                        jObj.clear();
                        // limpa o objeto json, já que o usuário não foi selecionado
                        // a mensagem é descartada
                        Thread.sleep(1000);
                        // thread para repetição da mensagem (senão fica aparecendo o tempo todo)

                    } else {
                        {
                            jObj.put("date_value", LocalDate.now());
                            jObj.put("time_value", LocalTime.now());
                            jObj.put("username_value", Panel_Chat.lst_users.getSelectedValue());
                        }
                        txData = jObj.toString().getBytes(StandardCharsets.UTF_8);
                        DatagramPacket txPkt = new DatagramPacket(txData, jObj.get("message_value").toString().length(), multicastAddr, 50000);
                        x.send(txPkt);
                    }
                }
                if (jObj.size() == 4) {
                    Thread.sleep(500);
                    jObj.clear();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(UDPMulticast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

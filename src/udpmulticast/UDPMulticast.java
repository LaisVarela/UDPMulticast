package udpmulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import static udpmulticast.Panel_JoinGroup.clientList;

public class UDPMulticast {

    static JSONObject jObj = new JSONObject();

    static public NetworkInterface netInterface() {
        NetworkInterface netIF = null;
        Enumeration<NetworkInterface> enumNetIF = null;
        try {
            enumNetIF = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex) {
            System.out.println("Problema em pegar a interface");
        }
        while (enumNetIF.hasMoreElements()) {
            netIF = enumNetIF.nextElement();
            try {
                if (netIF.isLoopback()) {
                    break;
                }
            } catch (SocketException ex) {
                System.out.println("");
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
            InetSocketAddress sockAddr = new InetSocketAddress(multicastAddr, 50000);
            MulticastSocket multicastSock = new MulticastSocket(50000);
            multicastSock.joinGroup(sockAddr, netInterface());
            Panel_Chat receive = new Panel_Chat();
            receive.t1.start();

            //buffer de comunicação
            byte[] txData = new byte[65507];

            while (true) {
                // thread para aparecer as mensagens no terminal (verificação do terminal)
                // na interface gráfica também não aparece a msg caso não tenha essa thread
                Thread.sleep(500);

                // adicionar/remover elementos no objeto json
                // msg deve ser o primeiro elemento a ser adicionado
                // enquanto os outros elementos devem estar null, isso que o if verifica
                if (!clientList.isEmpty() && jObj.get("date_value") == null
                        && jObj.get("time_value") == null && jObj.get("name") == null
                        && jObj.get("msg") != null) {

                    if (Panel_Chat.lst_users.isSelectionEmpty()) {
                        // se nenhum user foi selecionado, não é possível determinar quem está mandando mensagem
                        JOptionPane.showMessageDialog(null, "Select a user", "Error", JOptionPane.ERROR_MESSAGE);
                        jObj.clear();
                        // limpa o objeto json, já que o usuário não foi selecionado
                        // a mensagem é descartada
                        Thread.sleep(1000);
                        // thread para repetição da mensagem (senão fica aparecendo o tempo todo)
                        // pode ser tratado em um while (vou fazer o teste depois)
                    } else {
                        {
                            jObj.put("date_value", LocalDate.now());
                            jObj.put("time_value", LocalTime.now());
                            jObj.put("name", Panel_Chat.lst_users.getSelectedValue());
                        }
                        if (jObj.get("msg") != null || !jObj.get("msg").equals("")) {
                            // uma segunda verificação se a mensagem é diferente de nula, para só então mandar o pacote
                            txData = jObj.toString().getBytes(StandardCharsets.UTF_8);
                            DatagramPacket txPkt = new DatagramPacket(txData, jObj.get("msg").toString().length(), multicastAddr, 50000);
                            multicastSock.send(txPkt);
                        }
                    }
                } else {
                    // a segunda verificação de mensagem nula não entrou, ou seja, a msg é nula ou empty
                    // porém os elementos de data_value, time_value e name estão preenchidos
                    // se não há mensagem, não há o que enviar, por isso o obj json precisa ser limpo
                    jObj.clear();
                }
            }
        } catch (IOException ex) {
            System.out.println("falha ao entrar no grupo");
        }
    }

    public UDPMulticast() throws UnknownHostException {

    }

}

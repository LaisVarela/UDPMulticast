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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public final class UDPMulticast extends Thread {

    final InetAddress multicastAddr = InetAddress.getByName("224.0.0.2");
    final InetSocketAddress sockAddr = new InetSocketAddress(multicastAddr, 50000);
    final MulticastSocket multicastSock = new MulticastSocket(50000);

    public UDPMulticast() throws UnknownHostException, IOException, InterruptedException, JSONException {
        multicastSock.joinGroup(sockAddr, netInterface());
        this.start();
    }

    public NetworkInterface netInterface() {
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

    @Override
    public void run() {
        JSONObject jObj;
        try {
            Panel_Chat chat = new Panel_Chat(multicastSock, sockAddr, netInterface());
            //buffer de comunicação
            byte[] txData = new byte[65507];
            byte[] rxData = new byte[65507];
            while (true) {
                DatagramPacket rxPkt = new DatagramPacket(rxData, rxData.length);
                multicastSock.receive(rxPkt);
                String msg = new String(rxPkt.getData(), 0, rxPkt.getLength());
                System.out.println("SERVIDOR\n\t" + msg);
                jObj = new JSONObject(msg);
                jObj.put("date_value", LocalDate.now());
                jObj.put("time_value", LocalTime.now());
                txData = jObj.toString().getBytes(StandardCharsets.UTF_8);
                System.out.println("Servidor\n\t" + jObj.toString());
                DatagramPacket txPkt = new DatagramPacket(txData, jObj.toString().length(), multicastAddr, 50000);
                multicastSock.send(txPkt);
                chat.run();
            }
        } catch (IOException | JSONException | InterruptedException ex) {
            Logger.getLogger(UDPMulticast.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

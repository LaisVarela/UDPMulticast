package udpmulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Panel_Chat extends javax.swing.JPanel {

    DefaultListModel lstUsers = new DefaultListModel();
    MulticastSocket clientSock;
    // aula de 27/04 - vector (list para threads)
    LinkedList<Client> list = new LinkedList<>();
    Client client = new Client();

    // dois construtores são necessários devido a sobrecarga necessária
    public Panel_Chat() throws IOException {
        this.clientSock = new MulticastSocket();
        initComponents();
        // passando o nome dos users para JList
        for (Object item : Panel_JoinGroup.clientList) {
            lstUsers.addElement(item);
        }
        lst_users.setModel(lstUsers);

        InetAddress multicastAddr = InetAddress.getByName("224.0.0.2");
        InetSocketAddress sockAddr = new InetSocketAddress(multicastAddr, 50000);
        try {
            clientSock.joinGroup(sockAddr, UDPMulticast.netInterface());
        } catch (IOException e) {
            System.out.println("joinGroup do clientSock");
            Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public Panel_Chat(MulticastSocket clientS) throws IOException {
        this.clientSock = new MulticastSocket();
        initComponents();
        // passando o nome dos users para JList
        for (Object item : Panel_JoinGroup.clientList) {
            lstUsers.addElement(item);
        }
        lst_users.setModel(lstUsers);
        clientSock = clientS;
        /*InetAddress multicastAddr = InetAddress.getByName("224.0.0.2");
        InetSocketAddress sockAddr = new InetSocketAddress(multicastAddr, 50000);
        try {
            clientSock.joinGroup(sockAddr, UDPMulticast.netInterface());
        } catch (IOException e) {
            System.out.println("joinGroup do clientSock");
            Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, e);
        }*/

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp_users = new javax.swing.JScrollPane();
        lst_users = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txA_type = new javax.swing.JTextArea();
        bt_send = new javax.swing.JButton();
        bt_leave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_messeges = new javax.swing.JTextArea();
        bt_back = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 0));

        lst_users.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, new java.awt.Color(191, 232, 111), java.awt.Color.lightGray));
        sp_users.setViewportView(lst_users);

        txA_type.setColumns(20);
        txA_type.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txA_type.setRows(5);
        txA_type.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, new java.awt.Color(191, 232, 111), java.awt.Color.lightGray));
        jScrollPane3.setViewportView(txA_type);

        bt_send.setBackground(new java.awt.Color(255, 255, 255));
        bt_send.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        bt_send.setText("Send");
        bt_send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_sendMouseClicked(evt);
            }
        });

        bt_leave.setBackground(new java.awt.Color(255, 255, 255));
        bt_leave.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        bt_leave.setText("Leave Group");
        bt_leave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_leaveMouseClicked(evt);
            }
        });

        txtA_messeges.setEnabled(false);
        txtA_messeges.setColumns(20);
        txtA_messeges.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        txtA_messeges.setRows(5);
        txtA_messeges.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, new java.awt.Color(191, 232, 111), java.awt.Color.lightGray));
        jScrollPane1.setViewportView(txtA_messeges);

        bt_back.setBackground(new java.awt.Color(255, 255, 255));
        bt_back.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        bt_back.setText("Add +");
        bt_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sp_users, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(bt_back)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_leave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_send))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sp_users, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_send)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_leave)
                        .addComponent(bt_back)))
                .addGap(0, 17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_sendMouseClicked
        UDPMulticast.jObj.put("msg", txA_type.getText());
        if (UDPMulticast.jObj.get("msg") != null) {
            // limpa o campo de digitação 
            txA_type.setText(null);
        }
    }//GEN-LAST:event_bt_sendMouseClicked

    private void bt_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_backMouseClicked
        Window.join = new Panel_JoinGroup();
        JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
        window.remove(Window.chat);
        window.add(Window.join);
        window.pack();
    }//GEN-LAST:event_bt_backMouseClicked

    private void bt_leaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_leaveMouseClicked
        //remove from Jlist
        int index = lst_users.getSelectedIndex();
        lstUsers.remove(index);
        Panel_JoinGroup.clientList.remove(index);

        try {
            System.out.println(clientSock.getNetworkInterface());
            InetAddress multicastAddr = InetAddress.getByName("224.0.0.2");;
            InetSocketAddress sockAddr = new InetSocketAddress(multicastAddr, 50000);
            clientSock.leaveGroup(sockAddr, UDPMulticast.netInterface());
            clientSock.close();
        } catch (IOException ex) {
            System.out.println("Problema em sair do grupo");
            Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_bt_leaveMouseClicked

    // mostra os dados recebidos na interface gráfica
    public Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            byte[] rxData = new byte[65507];
            try {
                while (true) {
                    DatagramPacket rxPkt = new DatagramPacket(rxData, rxData.length);
                    clientSock.receive(rxPkt);

                    // criei variáveis pra ficar mais simples de adicionar no objeto client
                    LocalDate date = (LocalDate) UDPMulticast.jObj.get("date_value");
                    LocalTime time = (LocalTime) UDPMulticast.jObj.get("time_value");
                    String name = (String) UDPMulticast.jObj.get("name");
                    String msg = (String) UDPMulticast.jObj.get("msg");

                    // comunicar a thread de eventos Swing
                    // havia tentado fazer com static list, porém tinha um certo atraso
                    // encontrei de operação em elementos de threads distintas 
                    // com Vector implementado pode ter a possibilidade de não ser mais preciso
                    new SwingWorker<LinkedList<Client>, Void>() {
                        @Override
                        protected LinkedList<Client> doInBackground() throws Exception {
                            client = new Client(date, time, name, msg);
                            list.add(client);
                            return list;
                        }

                        @Override
                        public void done() {
                            LinkedList<Client> list;
                            try {
                                list = get();
                                txtA_messeges.setText(list.toString().replace(",", "").replace("[", "").replace("]", ""));
                            } catch (InterruptedException | ExecutionException ex) {
                                Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }.execute();
                }
            } catch (IOException e) {
                System.err.println("\n\tMessege error: " + e.getMessage());
                System.exit(1);
            }
        }
    });

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_back;
    private javax.swing.JButton bt_leave;
    private javax.swing.JButton bt_send;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    protected static javax.swing.JList<String> lst_users;
    private javax.swing.JScrollPane sp_users;
    private javax.swing.JTextArea txA_type;
    private static javax.swing.JTextArea txtA_messeges;
    // End of variables declaration//GEN-END:variables
}

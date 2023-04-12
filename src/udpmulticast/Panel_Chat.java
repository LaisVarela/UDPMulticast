package udpmulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Panel_Chat extends javax.swing.JPanel {

    DefaultListModel lstUsers = new DefaultListModel();
    MulticastSocket clientSock;
    Vector<Client> list = new Vector<>();
    Client client = new Client();

    public Panel_Chat(MulticastSocket clientS) throws IOException { 
        initComponents();
        this.clientSock = new MulticastSocket();
        // passando o nome dos users para JList
        for (Object item : Panel_JoinGroup.clientList) {
            lstUsers.addElement(item);
        }
        lst_users.setModel(lstUsers);
        clientSock = clientS;
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
        bt_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_messeges = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(0, 51, 0));

        lst_users.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, new java.awt.Color(255, 255, 255), java.awt.Color.lightGray));
        sp_users.setViewportView(lst_users);

        txA_type.setBackground(new java.awt.Color(255, 255, 255));
        txA_type.setColumns(20);
        txA_type.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        txA_type.setRows(5);
        txA_type.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, new java.awt.Color(255, 255, 255), java.awt.Color.lightGray));
        jScrollPane3.setViewportView(txA_type);

        bt_send.setBackground(new java.awt.Color(255, 255, 255));
        bt_send.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        bt_send.setText("Send");
        bt_send.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_sendMouseClicked(evt);
            }
        });

        bt_leave.setBackground(new java.awt.Color(255, 255, 255));
        bt_leave.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        bt_leave.setText("Leave Group");
        bt_leave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_leaveMouseClicked(evt);
            }
        });

        bt_back.setBackground(new java.awt.Color(255, 255, 255));
        bt_back.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        bt_back.setText("Add +");
        bt_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_backMouseClicked(evt);
            }
        });

        txtA_messeges.setBackground(new java.awt.Color(255, 255, 255));
        txtA_messeges.setColumns(20);
        txtA_messeges.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        txtA_messeges.setRows(5);
        txtA_messeges.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));
        txtA_messeges.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtA_messeges.setEnabled(false);
        jScrollPane1.setViewportView(txtA_messeges);

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.black, java.awt.Color.black, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sp_users, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_back))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt_leave)
                                .addGap(123, 123, 123)
                                .addComponent(bt_send))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sp_users, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_send)
                    .addComponent(bt_leave)
                    .addComponent(bt_back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        InetAddress multicastAddr;
        InetSocketAddress sockAddr = null;
        try {
            multicastAddr = InetAddress.getByName("224.0.0.2");
            sockAddr = new InetSocketAddress(multicastAddr, 50000);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean validates = true;
        try {
            boolean selection = lst_users.isSelectionEmpty();
            if (selection == true) {
                throw new EmptyException();
            }
        } catch (EmptyException e) {
            validates = false;
            JOptionPane.showMessageDialog(null, "Select a user.", "Messege", JOptionPane.WARNING_MESSAGE);
        }
        if (validates == true) {
            if (Panel_JoinGroup.clientList.size() == 1) {
                Object[] options = {"Leave", "Cancel"};
                int option = JOptionPane.showOptionDialog(null, "Are you sure? The application will be closed.", "Attention", JOptionPane.YES_NO_OPTION, options.length, null, options, JOptionPane.QUESTION_MESSAGE);
                switch (option) {
                    case 0 -> {
                        try {
                            clientSock.leaveGroup(sockAddr, UDPMulticast.netInterface());
                            clientSock.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else {
                int index = lst_users.getSelectedIndex();
                lstUsers.remove(index);
                Panel_JoinGroup.clientList.remove(index);
            }
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

                    client = new Client(date, time, name, msg);
                    list.add(client);
                    txtA_messeges.setText(list.toString().replace(",", "").replace("[", "").replace("]", ""));

                }
            } catch (IOException e) {
                System.exit(0);
            }
        }
    });

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_back;
    private javax.swing.JButton bt_leave;
    private javax.swing.JButton bt_send;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    protected static javax.swing.JList<String> lst_users;
    private javax.swing.JScrollPane sp_users;
    private static javax.swing.JTextArea txA_type;
    private static javax.swing.JTextArea txtA_messeges;
    // End of variables declaration//GEN-END:variables
}

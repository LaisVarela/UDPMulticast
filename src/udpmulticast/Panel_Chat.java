package udpmulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

public class Panel_Chat extends javax.swing.JFrame implements Runnable {

    InetSocketAddress sockAddr;
    MulticastSocket clientSock;
    NetworkInterface netIF;
    JSONObject jObj = new JSONObject();
    String user;

    public Panel_Chat(MulticastSocket clientS, InetSocketAddress sockAddr, NetworkInterface ni) throws IOException, InterruptedException, JSONException {
        initComponents();
        this.pack();
        this.clientSock = clientS;
        this.sockAddr = sockAddr;
        this.netIF = ni;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        pn_chat.setVisible(false);
        pn_join.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) throws IOException, InterruptedException, UnknownHostException, JSONException {
        UDPMulticast multicast = new UDPMulticast();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_join = new javax.swing.JPanel();
        lb_user = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        bt_joinGroup = new javax.swing.JButton();
        bt_cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        pn_chat = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_messages = new javax.swing.JTextArea();
        bt_leave = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txA_type = new javax.swing.JTextArea();
        bt_send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pn_join.setBackground(new java.awt.Color(255, 255, 255));

        lb_user.setBackground(new java.awt.Color(255, 153, 102));
        lb_user.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lb_user.setForeground(new java.awt.Color(51, 51, 51));
        lb_user.setText("Username:");

        txt_username.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txt_username.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));

        bt_joinGroup.setBackground(new java.awt.Color(255, 255, 255));
        bt_joinGroup.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        bt_joinGroup.setText("Join Group");
        bt_joinGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_joinGroupMouseClicked(evt);
            }
        });

        bt_cancel.setBackground(new java.awt.Color(255, 255, 255));
        bt_cancel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        bt_cancel.setText("Cancel");
        bt_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_cancelMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/udpmulticast/user.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(57, 57));
        jLabel1.setPreferredSize(new java.awt.Dimension(57, 57));

        jSeparator3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.white, java.awt.Color.white));

        jSeparator4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.white, java.awt.Color.white));

        javax.swing.GroupLayout pn_joinLayout = new javax.swing.GroupLayout(pn_join);
        pn_join.setLayout(pn_joinLayout);
        pn_joinLayout.setHorizontalGroup(
            pn_joinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_joinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_joinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator3)
                    .addGroup(pn_joinLayout.createSequentialGroup()
                        .addGroup(pn_joinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_joinLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pn_joinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_user)
                                    .addGroup(pn_joinLayout.createSequentialGroup()
                                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bt_joinGroup))))
                            .addComponent(bt_cancel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pn_joinLayout.setVerticalGroup(
            pn_joinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_joinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(pn_joinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_joinLayout.createSequentialGroup()
                        .addComponent(lb_user)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_joinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_joinGroup)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_cancel)
                .addContainerGap())
        );

        pn_chat.setBackground(new java.awt.Color(153, 153, 153));

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.black, java.awt.Color.black, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));

        txtA_messages.setBackground(new java.awt.Color(255, 255, 255));
        txtA_messages.setColumns(20);
        txtA_messages.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        txtA_messages.setRows(5);
        txtA_messages.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray));
        txtA_messages.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtA_messages.setEnabled(false);
        jScrollPane1.setViewportView(txtA_messages);

        bt_leave.setBackground(new java.awt.Color(255, 255, 255));
        bt_leave.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        bt_leave.setText("Leave Group");
        bt_leave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_leaveMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout pn_chatLayout = new javax.swing.GroupLayout(pn_chat);
        pn_chat.setLayout(pn_chatLayout);
        pn_chatLayout.setHorizontalGroup(
            pn_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_chatLayout.createSequentialGroup()
                .addGroup(pn_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_chatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pn_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)))
                    .addGroup(pn_chatLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(pn_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_chatLayout.createSequentialGroup()
                                .addComponent(bt_leave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_send)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pn_chatLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pn_chatLayout.setVerticalGroup(
            pn_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_chatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_chatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_leave)
                    .addComponent(bt_send))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(pn_join, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pn_chat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_join, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_chat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_joinGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_joinGroupMouseClicked
        if (!txt_username.getText().isBlank()) {
            pn_chat.setVisible(true);
            pn_join.setVisible(false);
            this.pack();
            user = txt_username.getText();
            txt_username.setText(null);
            try {
                clientSock.joinGroup(sockAddr, netIF);
            } catch (IOException ex) {
                Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Username cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bt_joinGroupMouseClicked

    private void bt_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cancelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_bt_cancelMouseClicked

    private void bt_leaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_leaveMouseClicked
        Object[] options = {"Leave", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, "Are you sure? You will be removed from the group.", "Attention", JOptionPane.YES_NO_OPTION, options.length, null, options, JOptionPane.QUESTION_MESSAGE);
        switch (option) {
            case 0 -> {
                try {
                    txtA_messages.setText(null);
                    clientSock.leaveGroup(sockAddr, netIF);
                    pn_chat.setVisible(false);
                    pn_join.setVisible(true);
                    this.pack();
                } catch (IOException ex) {
                    Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_bt_leaveMouseClicked

    private void bt_sendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_sendMouseClicked
        byte[] txData = new byte[65507];
        try {
            if (!txA_type.getText().isBlank()) {
                jObj.put("username_value", user);
                jObj.put("message_value", txA_type.getText());
                if (jObj.get("message_value") != null) {
                    // limpa o campo de digitação
                    txA_type.setText(null);
                    txData = jObj.toString().getBytes(StandardCharsets.UTF_8);
                    DatagramPacket txPkt = new DatagramPacket(txData, jObj.toString().length(), sockAddr.getAddress(), sockAddr.getPort());
                    try {
                        clientSock.send(txPkt);
                    } catch (IOException ex) {
                        Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_sendMouseClicked

    @Override
    public void run() {
        byte[] rxData = new byte[65507];
        String aux = "";
        try {
            while (true) {
                DatagramPacket rxPkt = new DatagramPacket(rxData, rxData.length);
                clientSock.receive(rxPkt);
                String msgRx = new String(rxPkt.getData(), 0, rxPkt.getLength());
                jObj = new JSONObject(msgRx);
                if (!jObj.toString().equals(aux)) {
                    aux = jObj.toString();
                    System.out.println("\nCliente\n\t" + jObj.toString());
                    txtA_messages.setText(txtA_messages.getText() + "\n" + jObj.get("username_value") + " [" + jObj.get("date_value") + " "
                            + jObj.get("time_value") + "]\n> " + jObj.get("message_value"));
                }
            }
        } catch (IOException e) {
            System.out.println("data");
        } catch (JSONException ex) {
            Logger.getLogger(Panel_Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_joinGroup;
    private javax.swing.JButton bt_leave;
    private javax.swing.JButton bt_send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lb_user;
    private javax.swing.JPanel pn_chat;
    private javax.swing.JPanel pn_join;
    private static javax.swing.JTextArea txA_type;
    private javax.swing.JTextArea txtA_messages;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

}

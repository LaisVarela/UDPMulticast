package udpmulticast;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Panel_JoinGroup extends javax.swing.JPanel {

    static protected LinkedList<String> clientList = new LinkedList();

    public Panel_JoinGroup() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_user = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        bt_joinGroup = new javax.swing.JButton();
        bt_cancel = new javax.swing.JButton();

        lb_user.setText("Username:");

        bt_joinGroup.setText("Join Group");
        bt_joinGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_joinGroupMouseClicked(evt);
            }
        });

        bt_cancel.setText("Cancel");
        bt_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_cancelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_cancel)
                    .addComponent(lb_user)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_joinGroup)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lb_user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_joinGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txt_username))
                .addGap(21, 21, 21)
                .addComponent(bt_cancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_joinGroupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_joinGroupMouseClicked
        if (!txt_username.getText().equals("")) {
            clientList.add(txt_username.getText());
            try {
                Window.chat = new Panel_Chat();
            } catch (IOException ex) {
                Logger.getLogger(Panel_JoinGroup.class.getName()).log(Level.SEVERE, null, ex);
            }
            JFrame window = (JFrame) SwingUtilities.getWindowAncestor(this);
            window.remove(Window.join);
            window.add(Window.chat, BorderLayout.CENTER);
            window.pack();
        } else {
            JOptionPane.showMessageDialog(null, "Username cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bt_joinGroupMouseClicked

    private void bt_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cancelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_bt_cancelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_joinGroup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_user;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}

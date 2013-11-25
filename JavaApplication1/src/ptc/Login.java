/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc;

import ptc.db_conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import java.sql.*;
import ptc.choose_module;
import sun.security.provider.MD5;

/**
 *
 * @author Rahil
 */
public class Login extends javax.swing.JFrame {
    
    
    
    public Login() throws ClassNotFoundException, SQLException {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        label_password = new javax.swing.JLabel();
        jlabel_username = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        header_image = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ptc-login");
        setAlwaysOnTop(true);
        setBackground(java.awt.Color.blue);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("login"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        label_password.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        label_password.setText("password:");
        getContentPane().add(label_password);
        label_password.setBounds(180, 330, 200, 50);

        jlabel_username.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jlabel_username.setText("username:");
        jlabel_username.setName("labe_username"); // NOI18N
        jlabel_username.setPreferredSize(new java.awt.Dimension(100, 100));
        getContentPane().add(jlabel_username);
        jlabel_username.setBounds(180, 260, 200, 50);
        jlabel_username.getAccessibleContext().setAccessibleName("label_username");

        submit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(310, 480, 140, 50);

        cancel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cancel.setText("cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel);
        cancel.setBounds(500, 480, 150, 50);

        password.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(password);
        password.setBounds(390, 330, 250, 50);
        password.getAccessibleContext().setAccessibleName("password");

        username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username);
        username.setBounds(390, 260, 250, 50);
        username.getAccessibleContext().setAccessibleName("username");

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(329, 78, 0, 0);

        header_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ptc/ptc logo.png"))); // NOI18N
        header_image.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(header_image);
        header_image.setBounds(-130, -90, 730, 350);
        header_image.getAccessibleContext().setAccessibleName("background");

        error.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        error.setForeground(new java.awt.Color(181, 18, 18));
        error.setName("error_label"); // NOI18N
        getContentPane().add(error);
        error.setBounds(380, 400, 340, 40);
        error.getAccessibleContext().setAccessibleName("error_txt");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
       
        String usr;
        String pass;
        boolean status=false;;
        usr=username.getText();
        pass= password.getText();
        //MD5(password.getText());
        if(usr.trim().length()==0 || pass.trim().length()==0)
        {
            error.setText("*please enter username and password!!");
            
        }
        db_conn db = null;
        try {        
            db = new db_conn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            status=db.login_checker(usr,pass);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(status);
        if(!status)
        { 
            error.setText("*username or password is not matching!!");
            password.setText("");
        }
        else
        {
           //getContentPane().add(new choose_module());
            dispose();
            new choose_module().setVisible(true);
   
        }   
    }//GEN-LAST:event_submitActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
      //  jFrame1.;
        System.exit(0);
    }//GEN-LAST:event_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel error;
    private javax.swing.JLabel header_image;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel jlabel_username;
    private javax.swing.JLabel label_password;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton submit;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}

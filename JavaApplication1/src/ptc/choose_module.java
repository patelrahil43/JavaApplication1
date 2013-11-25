/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rahil
 */
public class choose_module extends javax.swing.JFrame {

    /**
     * Creates new form choose_module
     */
    public choose_module() {
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

        workshop = new javax.swing.JButton();
        office = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("choose your mode");
        setBackground(new java.awt.Color(0, 51, 255));
        setName("choose_module"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        workshop.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        workshop.setText("workshop");
        workshop.setToolTipText("workshop module");
        workshop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workshopActionPerformed(evt);
            }
        });

        office.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        office.setText("office");
        office.setToolTipText("office module");
        office.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                officeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(workshop, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(office, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(office, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workshop, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("choose_module");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void workshopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workshopActionPerformed
        // TODO add your handling code here:
        dispose();
        try {
            new workshop().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(choose_module.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(choose_module.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_workshopActionPerformed

    private void officeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_officeActionPerformed
    
        // TODO add your handling code here:
        dispose();
        new office().setVisible(true);
    }//GEN-LAST:event_officeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(choose_module.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(choose_module.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(choose_module.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(choose_module.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new choose_module().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton office;
    private javax.swing.JButton workshop;
    // End of variables declaration//GEN-END:variables
}
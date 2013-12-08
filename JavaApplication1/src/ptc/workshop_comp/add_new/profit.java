/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc.workshop_comp.add_new;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ptc.workshop_comp.db_op;

/**
 *
 * @author Rahil
 */
public class profit extends javax.swing.JDialog{

    /**
     * Creates new form expense
     */
    String name,type,from_dat,desc;
    int amount;
    db_op op;
    boolean sucess,insertvalid=true;
    private int cosnt;
    public profit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        add_new_exp_dailog_panel = new javax.swing.JPanel();
        decription_label = new javax.swing.JLabel();
        exp_name = new javax.swing.JTextField();
        exp_amount = new javax.swing.JSpinner();
        exp_date = new org.jdesktop.swingx.JXDatePicker();
        exp_type = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        exp_description = new javax.swing.JTextArea();
        submit_exp = new javax.swing.JButton();
        exp_cancel = new javax.swing.JButton();
        name_label = new javax.swing.JLabel();
        amount_label = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        type_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("add new expense ");

        add_new_exp_dailog_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        decription_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        decription_label.setText("Description:");
        add_new_exp_dailog_panel.add(decription_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 100, 30));
        add_new_exp_dailog_panel.add(exp_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 190, 30));

        exp_amount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        exp_amount.setModel(new javax.swing.SpinnerNumberModel());
        add_new_exp_dailog_panel.add(exp_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 88, 190, 30));
        add_new_exp_dailog_panel.add(exp_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 110, 30));

        exp_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "workshop", "office", "other" }));
        add_new_exp_dailog_panel.add(exp_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 110, 30));

        exp_description.setColumns(20);
        exp_description.setRows(5);
        jScrollPane1.setViewportView(exp_description);

        add_new_exp_dailog_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 310, 120));

        submit_exp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submit_exp.setText("Submit");
        submit_exp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_expActionPerformed(evt);
            }
        });
        add_new_exp_dailog_panel.add(submit_exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, -1, -1));

        exp_cancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exp_cancel.setText("cancel");
        exp_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exp_cancelActionPerformed(evt);
            }
        });
        add_new_exp_dailog_panel.add(exp_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        name_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name_label.setText("Expense Name:");
        add_new_exp_dailog_panel.add(name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 110, 30));

        amount_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        amount_label.setText("Amount:");
        add_new_exp_dailog_panel.add(amount_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 100, 30));

        date_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        date_label.setText("Date:");
        add_new_exp_dailog_panel.add(date_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 100, 30));

        type_label.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        type_label.setText("Expense Type:");
        add_new_exp_dailog_panel.add(type_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add_new_exp_dailog_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add_new_exp_dailog_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submit_expActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_expActionPerformed
        // TODO add your handling code here:
         insertvalid=true;
         name=exp_name.getText();
         amount=(Integer)exp_amount.getValue();
         desc=exp_description.getText();
         type=exp_type.getSelectedItem().toString();
         SimpleDateFormat mdyFormat = new SimpleDateFormat("yyyy-M-dd");
         if(amount<=0 ){popup("please enter valid  amount!!","error","error");insertvalid=false;}  
         if(name.trim().length()==0){popup("please enter valid name!!","error","error");insertvalid=false;}
         try{
         from_dat = mdyFormat.format( exp_date.getDate());
        
         }
         catch(Exception e)
         {popup("please enter valid date!!","error","error");insertvalid=false;}
        if(insertvalid)
        {
        try {
            String insert="exp_name=\'"+name+"\',exp_amount=\'"+amount+"\',date=\'"+from_dat+"\',expense_type=\'"+type+"\',description=\'"+desc+"\'";
            op=new db_op();
           sucess= op.setdata("expense_workshop",insert);
          if(sucess)
          {
           popup("SUCESSFULLY ADDED!!!","sucess","sucess");
           dispose();
          }
          else{popup("error: please fill all required detail!!","","error");}
         
        } catch (Exception ex) {
            popup("error: in sql query !!"+ex.toString(),null,"error");
        }
        }
        //System.out.print(insert);
   
    }//GEN-LAST:event_submit_expActionPerformed

    private void exp_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exp_cancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exp_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                profit dialog = new profit(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add_new_exp_dailog_panel;
    private javax.swing.JLabel amount_label;
    private javax.swing.JLabel date_label;
    private javax.swing.JLabel decription_label;
    private javax.swing.JSpinner exp_amount;
    private javax.swing.JButton exp_cancel;
    private org.jdesktop.swingx.JXDatePicker exp_date;
    private javax.swing.JTextArea exp_description;
    private javax.swing.JTextField exp_name;
    private javax.swing.JComboBox exp_type;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name_label;
    private javax.swing.JButton submit_exp;
    private javax.swing.JLabel type_label;
    // End of variables declaration//GEN-END:variables

  public void popup(String msg,String title,String type)
  {
     
      if(type.equalsIgnoreCase("error"))
      {
          //System.out.println("error");
      JOptionPane.showMessageDialog(this,msg,title,JOptionPane.ERROR_MESSAGE);
      }    
      if(type.equalsIgnoreCase("sucess"))
      {
         // System.out.print("sucess");
      JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
      }
  
  }
}

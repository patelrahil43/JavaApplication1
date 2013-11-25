/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc.workshop_comp;

import ptc.workshop_comp.add_new.expense;
import com.xzq.osc.field.DateValuePicker;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.plaf.DatePickerUI;
import ptc.workshop;
import ptc.workshop_comp.add_new.service;


/**
 *
 * @author Rahil
 */
public class services extends javax.swing.JPanel {

    /**
     * Creates new form main_expense
     */
    service  addnew_service_dailog;
    ResultSet getdata;
    db_op op;
    public services() throws ClassNotFoundException, SQLException {
        initComponents();
        setVisible(true);
        /* set format of datepciker text box */
        from_date.setFormats("dd-M-yyyy");
        to_date.setFormats("dd-M-yyyy");
        refreshdata();
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        record_table = new javax.swing.JTable();
        search_panel1 = new javax.swing.JPanel();
        viewby_label = new javax.swing.JLabel();
        from_date = new org.jdesktop.swingx.JXDatePicker();
        to_label = new javax.swing.JLabel();
        to_date = new org.jdesktop.swingx.JXDatePicker();
        search_button = new javax.swing.JButton();
        excel = new javax.swing.JLabel();
        pdf = new javax.swing.JLabel();
        add_new_button = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        record_table.setAutoCreateRowSorter(true);
        record_table.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        record_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "jobcard no", "custumer name", "custmer id", "service type", "date", "taluka", "village", "service no.", "tractor hours", "total ammount", "edit", "delete"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        record_table.setToolTipText("service detail");
        record_table.setRowHeight(25);
        record_table.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(record_table);
        record_table.getColumnModel().getColumn(0).setPreferredWidth(30);

        viewby_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewby_label.setText("from:");

        to_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        to_label.setText("to:");

        search_button.setText("search");
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        excel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rahil\\Documents\\NetBeansProjects\\JavaApplication1\\src\\logo\\excel.png")); // NOI18N

        pdf.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rahil\\Documents\\NetBeansProjects\\JavaApplication1\\src\\logo\\pdf-file-32.png")); // NOI18N

        add_new_button.setText("add new");
        add_new_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout search_panel1Layout = new javax.swing.GroupLayout(search_panel1);
        search_panel1.setLayout(search_panel1Layout);
        search_panel1Layout.setHorizontalGroup(
            search_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewby_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(from_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(to_label, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(to_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(add_new_button, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                .addComponent(excel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pdf)
                .addGap(12, 12, 12))
        );
        search_panel1Layout.setVerticalGroup(
            search_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, search_panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(search_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(excel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(to_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewby_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(from_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(to_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(search_panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(search_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add_new_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addGap(236, 236, 236))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        // TODO add your handling code here:
        try
        {
            SimpleDateFormat mdyFormat = new SimpleDateFormat("dd-M-yyyy");
            String from_dat = mdyFormat.format(from_date.getDate());
            String to_dat = mdyFormat.format(to_date.getDate());
            //System.out.print(to_dat);
        }
        catch(NullPointerException ex)
        {
             JOptionPane.showMessageDialog(null, "please enter valid to and from date!!!","error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_search_buttonActionPerformed

    private void add_new_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_buttonActionPerformed
        // TODO add your handling code here:
        addnew_service_dailog=new service(new javax.swing.JFrame(), true);
        addnew_service_dailog.setAlwaysOnTop(true);
        addnew_service_dailog.setVisible(true);
        try {
            refreshdata();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_new_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_new_button;
    private javax.swing.JLabel excel;
    private org.jdesktop.swingx.JXDatePicker from_date;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pdf;
    private javax.swing.JTable record_table;
    private javax.swing.JButton search_button;
    private javax.swing.JPanel search_panel1;
    private org.jdesktop.swingx.JXDatePicker to_date;
    private javax.swing.JLabel to_label;
    private javax.swing.JLabel viewby_label;
    // End of variables declaration//GEN-END:variables

public static void main(String args[]) throws ClassNotFoundException, SQLException
{
new services();
}
public void refreshdata() throws ClassNotFoundException, SQLException
{
        db_op op=new db_op();
        getdata=op.getData("service");
        record_table.setModel(DbUtils.resultSetToTableModel(getdata));
}

}
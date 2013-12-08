/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc.workshop_comp;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import ptc.db_conn;
/**
 *
 * @author Rahil
 */
public class db_op {
    
    Statement st;
    java.sql.Connection conn = null;
    ResultSet rs;
    String db_field[][];
    private PreparedStatement pst;
    public db_op() throws ClassNotFoundException, SQLException
   {
        Class.forName("com.mysql.jdbc.Driver");
     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ptc","root", "p@ssw0rd");
     st=(Statement) conn.createStatement();
   
   }
 public ResultSet getData(String tablename)
 {
    String colnames=gettablecols(tablename);
    
   String query="select "+colnames+" from "+tablename;
   //System.out.println(colnames);
    return execquery(query);
     
 }   
  public ResultSet getdatasearch(String tablename,String keyword)
 {
    String colnames=gettablecols(tablename);
    String query=null;
    if(tablename.equalsIgnoreCase("stock_workshop"))
    {
                 query="select "+colnames+" from "+tablename+" where (part_name LIKE \'%"+keyword+"%\') OR (part_no LIKE \'%"+keyword+"%\') OR (amount LIKE \'%"+keyword+"%\') OR (qty LIKE \'%"+keyword+"\') OR (total_amount LIKE \'%"+keyword+"\')";
    }
        //System.out.println(query);
        return execquery(query);
     
 } 
   public ResultSet getdatasearch(String tablename,String from,String to)
 {
    String colnames=gettablecols(tablename);
    String query=null;
    if(tablename=="expense_workshop" || tablename=="service" || tablename=="profit_workshop")
    {
                 query="select "+colnames+" from "+tablename+" WHERE date BETWEEN  \'"+from+"\' and \'"+to+"\'";
    }
    // System.out.println(query);       
    return execquery(query);
 } 
 public boolean setdata(String tablename,String string ) throws SQLException
 {
     String query="INSERT INTO "+tablename+" set "+string;
    // System.out.print(query);
    if(st.executeUpdate(query)==1)
        return true;
    else
     return false;
 }
 
 public String[] checkexist(String tablename,String part_no) throws SQLException
 {
     int i=0;
     String string[]=new String[5];
     String query="SELECT part_no,part_namel,qty,amount from "+tablename+" WHERE part_no=\'"+part_no+"\'";
     rs=st.executeQuery(query);
     System.out.print(query);
     while(rs.next())
     {  
       i++;
       string[0]=Integer.toString(rs.getInt("part_no"));
       string[1]=rs.getString("part_namel");
       string[2]=Integer.toString(rs.getInt("qty"));
       string[3]=Integer.toString(rs.getInt("amount"));
       string[4]=Integer.toString(rs.getInt("total_amount"));
     }
     System.out.print(string[2]+string[3]);
         return string;
        
 }
 
 public ResultSet execquery(String query) 
 {
        try {
            pst=conn.prepareStatement(query);
            rs=pst.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(db_op.class.getName()).log(Level.SEVERE, null, ex);
        }
 return rs;
 }
 
 public static String gettablecols(String tablenanme)
 {
     String colnames=null;
     
     if(tablenanme=="expense_workshop")
     {
     colnames="exp_id AS \'EXPENSE NO.\',exp_name AS \'EXPENSE NAME\',expense_type AS \'EXPENSE TYPE\',exp_amount AS \'EXPENSE AMOUNT\',date AS \'DATE\',description AS \'COMMENT\'";
     }
     if(tablenanme=="profit_workshop")
     {
     colnames="pro_id AS \'PROFIT NO.\',pro_name AS \'PROFIT NAME\',profit_type AS \'PROFIT TYPE\',pro_amount AS \'PROFIT AMOUNT\',date AS \'DATE\',description AS \'COMMENT\'";
     }
     if(tablenanme=="stock_workshop")
     {
     colnames="part_no AS \'PART NO \',part_name as \'PART NAME\',qty AS \'QTY\',amount AS \'AMOUNT\',total_amount AS \'TOTAL AMOUNT\'";
     }
     if(tablenanme=="service")
     {
     //colnames="jobcard no,customer_name,service_type,date,taluka,village,tractor_hours,description,total_amount";
     colnames="*";
     }
     return colnames;
 }
    
}

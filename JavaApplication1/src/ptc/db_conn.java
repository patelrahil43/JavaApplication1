/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ptc;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author Rahil
 */
public class db_conn {
    
    Statement st;
    Connection conn = null;
    ResultSet rs;
    public db_conn() throws ClassNotFoundException, SQLException
    {
     Class.forName("com.mysql.jdbc.Driver");
     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ptc","root", "p@ssw0rd");
     st=(Statement) conn.createStatement();
     //String query="insert into users set username='rahil'";
     //st.executeUpdate(query);
     //System.out.print("sucessfully");
    //conn.close();
    
    
    }
    public boolean login_checker(String username,String password) throws SQLException
    {
      String db_username=null,db_password=null;
      String query="SELECT username,password from users where username=\'"+username+'\'';
      //System.out.print(password);
      rs=st.executeQuery(query);
      // System.out.println(ptc.JavaMD5Hash.cryptWithMD5(password));
     
      while(rs.next())
      {
          db_username= rs.getString("username");
          db_password=rs.getString("password");
        //System.out.print(db_password+' ' +db_username);
      }
       //System.out.print(db_password+password+' '+username+db_username);
      if((username.equals(db_username)) && (password.equals(db_password))) {return true;}
       else {return false;}
      
    }
    
  
    
 public static void main(String args[]) throws ClassNotFoundException, SQLException
  {
  db_conn db1=new db_conn();
  if(db1.login_checker("rahil", "p@ssw0rd"))
  {  
      System.out.print("sucessfully");
  }
  
  }
}

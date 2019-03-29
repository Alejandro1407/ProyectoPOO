package Datos;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    public static Connection Conectarse(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/POO","root","");
            return conn;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }//Conectarse
    /*
    public static boolean ExecuteUpdate(String Query){
        try{
            Connection conn = Conectarse();
            if(conn == null){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error durante la conexion");
                return false;
            }
            Statement ps = conn.createStatement();
            ps.executeUpdate(Query);
            return true;
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Ha ocurrido un error " + e.getMessage());
            return false;
        }
    }//ExecuteUpdate
    
    public static ResultSet ExecuteQuery(String Query){
         try{
            Connection conn = Conectarse();
            if(conn == null){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error durante la conexion");
                return null;
            }
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(Query);
            return rs;
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Ha ocurrido un error " + e.getMessage());
            return null;
        }
    }//ExecuteQuery
    */
   public static void CallProc(){
       try{
       
       
       }catch(Exception e){
       
       }
   }//CallProc
    
    
    
}

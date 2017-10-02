/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams.db;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Rasan
 */
public class DB {
    private static Connection con;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/amsdb", "amsuser", "1234");
            return con;
        }catch(Exception ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Exception in getConnection: " + ex.getMessage());
        }
        return null;
    }
    
}

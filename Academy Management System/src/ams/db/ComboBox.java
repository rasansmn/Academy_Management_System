/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams.db;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Rasan
 */
public class ComboBox {
    private static Connection con;
    
    public static void bindCombo(JComboBox cmbbox, String tablename, String colname){
        try{
            con = DB.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select " + colname + " from "+ tablename);
            cmbbox.removeAllItems();
            while(rs.next()){
                cmbbox.addItem(rs.getString(colname));
            }
            con.close();    
        }catch(Exception ex){
            System.err.printf(ex.getMessage());
        }
    }
}

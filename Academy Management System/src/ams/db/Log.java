/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams.db;
import ams.db.DB;
import java.sql.*;
/**
 *
 * @author Rasan
 */
public class Log {
    public static void insert(String entity, String action, int uid){
        Connection con;
        try{
            con = DB.getConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into tbllog (entity, action, userid) values ('" + entity + "', '" + action + "', " + uid + ")");
            con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

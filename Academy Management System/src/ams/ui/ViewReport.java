/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams.ui;

/**
 *
 * @author Rasan
 */
import java.util.HashMap;
import java.awt.Container;
import java.sql.Connection;
import javax.swing.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import ams.db.DB;

public class ViewReport extends JFrame{
    public ViewReport(String fileName){
        this(fileName, null);
    }
    public ViewReport(String fileName, HashMap para){
        super("report");
        Connection con = DB.getConnection();
        try{
            JasperPrint print = JasperFillManager.fillReport(fileName, para, con);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);
        }catch(JRException ex){
            ex.printStackTrace();
        }
        setBounds(10,10,900,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}

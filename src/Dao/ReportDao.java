/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Controller.Koneksi;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReportDao {

    Koneksi con;
    Statement st;
    ResultSet rs;

    public void CetakLaporanKaryawan(String langkah2, String fuzzyfikasi, String namabarang, String naik, String turun, String banyak, String sedikit, String R1, String R2, String R3, String R4) {

        con = new Koneksi();

        try {
            HashMap parameter = new HashMap();
            File file = new File("src/Report/HasilPrediksi.jasper");
            parameter.put("namabarang", namabarang);
            parameter.put("naik", naik);
            parameter.put("turun", turun);
            parameter.put("banyak", banyak);
            parameter.put("sedikit", sedikit);
            parameter.put("langkah2", langkah2);
            parameter.put("fuzzyfikasi", fuzzyfikasi);
            parameter.put("R1", R1);
            parameter.put("R2", R2);
            parameter.put("R3", R3);
            parameter.put("R4", R4);
            JasperReport jp = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jp, parameter, con.connect());
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

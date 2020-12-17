/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FormulaDao1 {
    
    Koneksi con;
    Statement st;
    ResultSet rs;
    
    public Double maxValuePmt;
    public Double minValuePmt;
    public Double maxValuePsd;
    public Double minValuePsd;
    public Double maxValuePmb;
    public Double minValuePmb;
    public Double R1;
    public Double R2;
    public Double R3;
    public Double R4;
    public Double maxPmb;
    public Double minPmb;

    public Double getMaxPmb() {
        return maxPmb;
    }

    public void setMaxPmb(Double maxPmb) {
        this.maxPmb = maxPmb;
    }

    public Double getMinPmb() {
        return minPmb;
    }

    public void setMinPmb(Double minPmb) {
        this.minPmb = minPmb;
    }

    public Double getMaxValuePmb() {
        return maxValuePmb;
    }

    public void setMaxValuePmb(Double maxValuePmb) {
        this.maxValuePmb = maxValuePmb;
    }

    public Double getMaxValuePmt() {
        return maxValuePmt;
    }

    public void setMaxValuePmt(Double maxValuePmt) {
        this.maxValuePmt = maxValuePmt;
    }

    public Double getMaxValuePsd() {
        return maxValuePsd;
    }

    public void setMaxValuePsd(Double maxValuePsd) {
        this.maxValuePsd = maxValuePsd;
    }

    public Double getMinValuePmb() {
        return minValuePmb;
    }

    public void setMinValuePmb(Double minValuePmb) {
        this.minValuePmb = minValuePmb;
    }

    public Double getMinValuePmt() {
        return minValuePmt;
    }

    public void setMinValuePmt(Double minValuePmt) {
        this.minValuePmt = minValuePmt;
    }

    public Double getMinValuePsd() {
        return minValuePsd;
    }

    public void setMinValuePsd(Double minValuePsd) {
        this.minValuePsd = minValuePsd;
    }

    public Double getR1() {
        return R1;
    }

    public void setR1(Double R1) {
        this.R1 = R1;
    }

    public Double getR2() {
        return R2;
    }

    public void setR2(Double R2) {
        this.R2 = R2;
    }

    public Double getR3() {
        return R3;
    }

    public void setR3(Double R3) {
        this.R3 = R3;
    }

    public Double getR4() {
        return R4;
    }

    public void setR4(Double R4) {
        this.R4 = R4;
    }
    
    public Double FindMaxPermintaan(String nama){
        Double max = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT MAX(jumlah) As maxPmt FROM tb_prediksi WHERE nama = '"+nama+"'");
            while(rs.next()){
                max = rs.getDouble("maxPmt");
            }
        }catch(SQLException ex){
            
        }
        
        return max;
    }
    
    public Double FindMaxPersediaan(String nama){
        Double max = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT MAX(stok) As maxPsd FROM tb_prediksi WHERE nama = '"+nama+"'");
            while(rs.next()){
                max = rs.getDouble("maxPsd");
            }
        }catch(SQLException ex){
            
        }
        
        return max;
    }
    
    public Double FindMaxPembelian(String idbarang){
        Double max = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT MAX(jumlah) As maxPmb FROM dt_masuk WHERE idbarang = '"+idbarang+"'");
            while(rs.next()){
                max = rs.getDouble("maxPmb");
            }
        }catch(SQLException ex){
            
        }
        
        return max;
    }
    
    public Double FindMinPermintaan(String nama){
        Double min = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT MIN(jumlah) As minPmt FROM tb_prediksi WHERE nama = '"+nama+"'");
            while(rs.next()){
                min = rs.getDouble("minPmt");
            }
        }catch(SQLException ex){
            
        }
        
        return min;
    }
    
    public Double FindMinPersediaan(String nama){
        Double min = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT MIN(stok) As minPsd FROM tb_prediksi WHERE nama = '"+nama+"'");
            while(rs.next()){
                min = rs.getDouble("minPsd");
            }
        }catch(SQLException ex){
            
        }
        
        return min;
    }
    
    public Double FindMinPembelian(String idbarang){
        Double min = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT MIN(jumlah) As minPmb FROM dt_masuk WHERE idbarang = '"+idbarang+"'");
            while(rs.next()){
                min = rs.getDouble("minPmb");
            }
        }catch(SQLException ex){
            
        }
        
        return min;
    }
}

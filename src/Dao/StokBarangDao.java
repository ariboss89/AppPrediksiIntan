/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import Model.tb_prediksi;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class StokBarangDao extends tb_prediksi {
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public void Save(String idbarang, String nama, String bulan, int tahun, int permintaan, int persediaan, int pembelian) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_prediksi(kode_barang, nama_barang, bulan, tahun, permintaan, persediaan, pembelian)values('" + idbarang + "','" + nama + "','" + bulan + "','" +tahun + "','" + persediaan + "','" + permintaan + "','" +pembelian + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Update(int idprediksi, String idbarang, String nama, String bulan, int tahun, int permintaan, int persediaan, int pembelian) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_prediksi set nama_barang='" + nama + "', bulan='" + bulan + "', tahun='" + tahun + "', persediaan='" + persediaan + "', permintaan='" + permintaan + "', pembelian='" +pembelian+"', kode_barang ='"+idbarang+"' where id_prediksi = '" + idprediksi + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }
    
    public void Delete(int idprediksi) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_prediksi where id_prediksi = '" + idprediksi + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
        } catch (SQLException e) {

        }
    }

    public String[][] ShowData() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id_prediksi) AS Jumlah FROM tb_prediksi";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_prediksi";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][8];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("id_prediksi");
                data[r][1] = res.getString("kode_barang");
                data[r][2] = res.getString("nama_barang");
                data[r][3] = res.getString("bulan");
                data[r][4] = res.getString("tahun");
                data[r][5] = res.getString("permintaan");
                data[r][6] = res.getString("persediaan");
                data[r][7] = res.getString("pembelian");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][8];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 8; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }

    public String[][] SearchData(String search) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id_prediksi) AS Jumlah FROM tb_prediksi WHERE nama_barang = '"+search+"'";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_prediksi";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][8];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("id_prediksi");
                data[r][1] = res.getString("kode_barang");
                data[r][2] = res.getString("nama_barang");
                data[r][3] = res.getString("bulan");
                data[r][4] = res.getString("tahun");
                data[r][5] = res.getString("permintaan");
                data[r][6] = res.getString("persediaan");
                data[r][7] = res.getString("pembelian");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][8];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 8; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
    
    public int StokPersediaan(String IdBarang){
        con = new Koneksi();
        int stok = 0;
        
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_barang WHERE idbarang ='"+IdBarang+"'");
            while(res.next()){
                stok = res.getInt("stok");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return stok;
    }
    
    public int SumPembelian(String idbarang, String bulan, String tahun){
        con = new Koneksi();
        int sumPermintaan = 0;
        
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT SUM(jumlah) as hitungPembelian FROM dt_masuk WHERE tanggal like '%"+bulan+"%' AND tanggal like '%"+tahun+"%' AND idbarang like '%"+idbarang+"%'");
            while(res.next()){
                sumPermintaan = res.getInt("hitungPembelian");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return sumPermintaan;
    }
    
    public int SumPenjualan(String nama, String bulan, String tahun){
        con = new Koneksi();
        int sumPermintaan = 0;
        
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT SUM(jumlah) as hitungPermintaan FROM dt_keluar WHERE tanggal like '%"+bulan+"%' AND tanggal like '%"+tahun+"%' AND nama = '"+nama+"' ");
            while(res.next()){
                sumPermintaan = res.getInt("hitungPermintaan");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return sumPermintaan;
    }
}

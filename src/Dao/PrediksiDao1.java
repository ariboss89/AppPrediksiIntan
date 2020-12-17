/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import Model.tb_prediksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class PrediksiDao1 extends tb_prediksi{
    
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    private String idbarang;

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }
    
    public String[][] ShowPembelian(String idbarang) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(iddetailmasuk) AS Jumlah FROM dt_masuk";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from dt_masuk WHERE idbarang = '"+idbarang+"'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][5];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("iddetailmasuk");
                data[r][1] = res.getString("idmasuk");
                data[r][2] = res.getString("idbarang");
                data[r][3] = res.getString("tanggal");
                data[r][4] = res.getString("jumlah");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][5];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 5; c++) {
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
    
    public String[][] ShowPenjualan(String nama) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_prediksi";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_prediksi WHERE nama = '"+nama+"'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("tanggal");
                data[r][2] = res.getString("nama");
                data[r][3] = res.getString("harga");
                data[r][4] = res.getString("jumlah");
                data[r][5] = res.getString("stok");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][6];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 6; c++) {
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

    public String[][] SearchData(String nama, String tahun) {

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
            query = "select *from tb_prediksi WHERE nama_barang = '"+nama+"' AND tahun = '"+tahun+"'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][7];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("kode_barang");
                data[r][1] = res.getString("nama_barang");
                data[r][2] = res.getString("bulan");
                data[r][3] = res.getString("tahun");
                data[r][4] = res.getString("permintaan");
                data[r][5] = res.getString("persediaan");
                data[r][6] = res.getString("pembelian");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][7];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 7; c++) {
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
    
    public int StokBarang(String nama){
        con = new Koneksi();
        int stok = 0;
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_barang WHERE nama = '"+nama+"'");
            while(res.next()){
                stok = res.getInt("stok");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return stok;
    }
}

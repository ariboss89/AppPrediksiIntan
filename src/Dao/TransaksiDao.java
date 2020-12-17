/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import Model.tr_keluar;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class TransaksiDao extends tr_keluar{
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
//    public void UpdateStokBarangMasuk(String nama, int stok, Date tanggal) {
//        con = new Koneksi();
//        con.connect();
//        try {
//            st = con.conn.createStatement();
//            query = "update barangmasuk set stok='" + stok + "' where nama = '" + nama + "' and tanggal = '" + tanggal + "'";
//            st.executeUpdate(query);
//            st.close();
//            con.conn.close();
//        } catch (SQLException e) {
//
//        }
//    }
    
    public void UpdateStokBarang(String nama, int stok) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_barang set stok='" + stok + "' where nama = '" + nama + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {

        }
    }
    
    public void Save(String Id, Date tanggal, int jumlah, int total, int bayar, int kembali, String pelanggan) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tr_keluar(idkeluar, tanggal, jumlah, total, bayar, kembalian, pelanggan)values('" + Id + "','" + tanggal + "','" + jumlah + "','" + total + "','" + bayar + "','" + kembali + "','" + pelanggan + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Tunggu Sebentar ... , Struk Akan di Cetak");
        } catch (SQLException e) {
        }
    }
    
    public void SaveDetail(String Id, String idtransaksi, String nama, int harga, int jumlah, int total, Date tanggal, int stok) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into dt_keluar(iddetailkeluar, idkeluar, tanggal, nama, harga, jumlah, total, stok)values('" + Id + "','" + idtransaksi + "','"+tanggal+"','" + nama + "','" + harga + "','" + jumlah + "','" + total + "', '"+stok+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Barang di Tambahkan");
        } catch (SQLException e) {
        }
    }
    
    public void Delete(String Id) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_supplier where idsupplier = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {

        }
    }

    public String[][] ShowData(String idtransaksi) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(iddetailkeluar) AS Jumlah FROM dt_keluar";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from dt_keluar where idkeluar = '"+idtransaksi+"'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("iddetailkeluar");
                data[r][1] = res.getString("idkeluar");
                data[r][2] = res.getString("nama");
                data[r][3] = res.getString("harga");
                data[r][4] = res.getString("jumlah");
                data[r][5] = res.getString("total");
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

    public String[][] SearchData(String Id) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(idkeluar) AS Jumlah FROM tr_keluar";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tr_keluar where idkeluar like '%" + Id + "%'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][5];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("idkeluar");
                data[r][1] = res.getString("tanggal");
                data[r][2] = res.getString("jumlah");
                data[r][3] = res.getString("total");
                data[r][4] = res.getString("bayar");
                data[r][4] = res.getString("kembalian");
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
}

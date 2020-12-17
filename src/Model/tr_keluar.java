/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Date;

/**
 *
 * @author User
 */
public class tr_keluar{
    private String idkeluar;
    private Date tanggal;
    private int jumlah;
    private int total;
    private int bayar;
    private int kembalian;
    private String idpelanggan;
    private String IdDetail;
    private java.sql.Date tanggalMasuk;
    private int stokBarangMasuk;
    private int stokBarang;
    private int minStokBarang;
    private int Penampung;
    private String namaBarang;

    public String getIdDetail() {
        return IdDetail;
    }

    public void setIdDetail(String IdDetail) {
        this.IdDetail = IdDetail;
    }

    public int getMinStokBarang() {
        return minStokBarang;
    }

    public void setMinStokBarang(int minStokBarang) {
        this.minStokBarang = minStokBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getPenampung() {
        return Penampung;
    }

    public void setPenampung(int Penampung) {
        this.Penampung = Penampung;
    }

    public int getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(int stokBarang) {
        this.stokBarang = stokBarang;
    }

    public int getStokBarangMasuk() {
        return stokBarangMasuk;
    }

    public void setStokBarangMasuk(int stokBarangMasuk) {
        this.stokBarangMasuk = stokBarangMasuk;
    }

    public java.sql.Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(java.sql.Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }
    
    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        this.bayar = bayar;
    }

    public String getIdkeluar() {
        return idkeluar;
    }

    public void setIdkeluar(String idkeluar) {
        this.idkeluar = idkeluar;
    }

    public String getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(String idpelanggan) {
        this.idpelanggan = idpelanggan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getKembalian() {
        return kembalian;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

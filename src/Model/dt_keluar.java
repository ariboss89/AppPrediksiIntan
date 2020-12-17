/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author User
 */
public class dt_keluar {
    private String iddetailkeluar;
    private String idkeluar;
    private String idbarang;
    private int harga;
    private int jumlah;
    private int total;

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public String getIddetailkeluar() {
        return iddetailkeluar;
    }

    public void setIddetailkeluar(String iddetailkeluar) {
        this.iddetailkeluar = iddetailkeluar;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getIdkeluar() {
        return idkeluar;
    }

    public void setIdkeluar(String idkeluar) {
        this.idkeluar = idkeluar;
    }
}

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
public class tb_prediksi {
    public int idPrediksi;
    public String kode_barang;
    public String nama_barang;
    public Date tanggal;
    public Double permintaan;
    public Double persediaan;
    public Double pmtNaik;
    public Double pmtTurun;
    public Double pmtMax;
    public Double pmtMin;
    public Double psdBanyak;
    public Double psdSedikit;
    public Double psdMax;
    public Double psdMin;
    public Double pmbBertambah;
    public Double pmbBerkurang;
    public Double pmbMax;
    public Double pmbMin;
    public String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIdPrediksi() {
        return idPrediksi;
    }

    public void setIdPrediksi(int idPrediksi) {
        this.idPrediksi = idPrediksi;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Double getPermintaan() {
        return permintaan;
    }

    public void setPermintaan(Double permintaan) {
        this.permintaan = permintaan;
    }

    public Double getPersediaan() {
        return persediaan;
    }

    public void setPersediaan(Double persediaan) {
        this.persediaan = persediaan;
    }

    public Double getPmtNaik() {
        return pmtNaik;
    }

    public void setPmtNaik(Double pmtNaik) {
        this.pmtNaik = pmtNaik;
    }

    public Double getPmtTurun() {
        return pmtTurun;
    }

    public void setPmtTurun(Double pmtTurun) {
        this.pmtTurun = pmtTurun;
    }

    public Double getPmtMax() {
        return pmtMax;
    }

    public void setPmtMax(Double pmtMax) {
        this.pmtMax = pmtMax;
    }

    public Double getPmtMin() {
        return pmtMin;
    }

    public void setPmtMin(Double pmtMin) {
        this.pmtMin = pmtMin;
    }

    public Double getPsdBanyak() {
        return psdBanyak;
    }

    public void setPsdBanyak(Double psdBanyak) {
        this.psdBanyak = psdBanyak;
    }

    public Double getPsdSedikit() {
        return psdSedikit;
    }

    public void setPsdSedikit(Double psdSedikit) {
        this.psdSedikit = psdSedikit;
    }

    public Double getPsdMax() {
        return psdMax;
    }

    public void setPsdMax(Double psdMax) {
        this.psdMax = psdMax;
    }

    public Double getPsdMin() {
        return psdMin;
    }

    public void setPsdMin(Double psdMin) {
        this.psdMin = psdMin;
    }

    public Double getPmbBertambah() {
        return pmbBertambah;
    }

    public void setPmbBertambah(Double pmbBertambah) {
        this.pmbBertambah = pmbBertambah;
    }

    public Double getPmbBerkurang() {
        return pmbBerkurang;
    }

    public void setPmbBerkurang(Double pmbBerkurang) {
        this.pmbBerkurang = pmbBerkurang;
    }

    public Double getPmbMax() {
        return pmbMax;
    }

    public void setPmbMax(Double pmbMax) {
        this.pmbMax = pmbMax;
    }

    public Double getPmbMin() {
        return pmbMin;
    }

    public void setPmbMin(Double pmbMin) {
        this.pmbMin = pmbMin;
    }
}

package com.younggan.intermediate1.data;

/**
 * Created by ihsan on 26/03/2016.
 */
public class Data {
    private String id,idpelanggan, nama, alamat, gradu, tarif, piutang,bk, petugas, status;

    public Data() {
    }

    public Data(String id, String idpelanggan, String nama, String alamat, String gradu, String tarif, String piutang, String bk, String petugas, String status) {
        this.id = id;
        this.idpelanggan = idpelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.gradu = gradu;
        this.tarif = tarif;
        this.piutang = piutang;
        this.bk = bk;
        this.petugas = petugas;
        this.status = status;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(String idpelanggan) {
        this.idpelanggan = idpelanggan;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getGradu() {
        return gradu;
    }

    public void setGradu(String gradu) {
        this.gradu = gradu;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getPiutang() {
        return piutang;
    }

    public void setPiutang(String piutang) {
        this.piutang = piutang;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public String getPetugas() {
        return petugas;
    }

    public String getBk() {
        return bk;
    }

    public void setBk(String bk) {
        this.bk = bk;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

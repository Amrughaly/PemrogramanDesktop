/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_Keyboard;

/**
 *
 * @author Thinkpad
 */
public class Keyboard {
    private String tanggal_pembelian;
    private String merek;
    private String harga;
    private String jenis;
    private String warna;

    public Keyboard (String tanggal, String merek, String harga, String jenis, String warna) {
        this.tanggal_pembelian = tanggal;
        this.merek = merek;
        this.harga = harga;
        this.jenis = jenis;
        this.warna = warna;
    }

    public String getProdi() {
        return warna;
    }

    public void setProdi(String prodi) {
        this.warna = prodi;
    }

    public String getNpm() {
        return tanggal_pembelian;
    }

    public void setNpm(String npm) {
        this.tanggal_pembelian = npm;
    }

    public String getNama() {
        return merek;
    }

    public void setNama(String nama) {
        this.merek = nama;
    }

    public String getTanggalLahir() {
        return harga;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.harga = tanggalLahir;
    }

    public String getGender() {
        return jenis;
    }

    public void setGender(String gender) {
        this.jenis = gender;
    }

    public String gettanggal_pembelian() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getmerek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getharga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getjenis() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getwarna() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


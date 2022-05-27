package p_keyboard;

public class p_keyboard {
     private int id;
    private String nama_lampu;
    private String daya;
    private String tanggal;
    private int berat;
    private final String merek;
    private final Enum jenis;
    private final int harga;

    public p_keyboard(int id, String merek, Enum jenis, String tanggal, int harga) {
        this.id = id;
        this.merek = merek;
        this.jenis = jenis;
        this.tanggal = tanggal;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getMerek() {
        return nama_lampu;
    }

    public String getJenis() {
        return daya;
    }

    public String getTanggal() {
        return tanggal;
    } 

    public int getHarga() {
        return berat;
    }
}

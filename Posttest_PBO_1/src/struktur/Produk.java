package struktur;

public class Produk {
    private String nama;
    private double harga;
    private int stok;
    private Kategori kategori;

    public Produk(String nama, double harga, int stok, Kategori kategori) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Harga: Rp" + harga + ", Stok: " + stok + ", Kategori: " + kategori;
    }
}

package struktur;

public class ProdukPastry extends Produk {
    private int ukuran; 

    public ProdukPastry(String nama, double harga, int stok, Kategori kategori, int ukuran) {
        super(nama, harga, stok, kategori);
        this.ukuran = ukuran;
    }

    public int getUkuran() {
        return ukuran;
    }

    public String getUkuranString() {
        switch (ukuran) {
            case 1: return "Mini";
            case 2: return "Sedang";
            case 3: return "Jumbo";
            default: return "Tidak Valid";
        }
    }

    @Override
    public String getDetailTambahan() {
        return " - Ukuran: " + getUkuranString();
    }
}
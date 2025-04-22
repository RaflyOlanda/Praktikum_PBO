package struktur;

public class ProdukRoti extends Produk {
    private String rasa;

    public ProdukRoti(String nama, double harga, int stok, Kategori kategori, String rasa) {
        super(nama, harga, stok, kategori);
        this.rasa = rasa;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    @Override
    public String getDetailTambahan() {
        return " - Rasa: " + rasa;
    }

    @Override
    public String getJenisProduk() {
        return "Roti";
    }
}

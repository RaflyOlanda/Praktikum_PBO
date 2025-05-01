package struktur;

public class ProdukRoti extends Produk implements DeskripsiProduk {
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

    @Override
    public void tampilkanDeskripsi() {
        System.out.println(getNama() + " adalah roti rasa " + rasa + ", cocok untuk sarapan dan camilan.");
    }

    @Override
    public boolean stokMenipis() {
        return getStok() <= 5;
    }

}

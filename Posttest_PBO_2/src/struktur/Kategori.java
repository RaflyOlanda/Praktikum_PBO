
package struktur;

public class Kategori {
    private String namaKategori;

    
    public Kategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    
    public String getNamaKategori() {
        return namaKategori;
    }

    
    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }
    
    @Override
    public String toString() {
        return namaKategori;
    }
}

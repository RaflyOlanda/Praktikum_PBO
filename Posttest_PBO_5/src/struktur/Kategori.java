
package struktur;

public final class Kategori {
    private final String namaKategori;

    
    public Kategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    
    public String getNamaKategori() {
        return namaKategori;
    }
    
    @Override
    public String toString() {
        return namaKategori;
    }
}

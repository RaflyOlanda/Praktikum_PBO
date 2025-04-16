import java.util.Scanner;
import struktur.Kategori;
import struktur.ManajemenProduk;

public class LunarBakeshop {
    public static void main(String[] args) {
        ManajemenProduk manajemenProduk = new ManajemenProduk();
        Scanner scanner = new Scanner(System.in);

        Kategori roti = manajemenProduk.getDaftarKategori().get(0);
        Kategori pastry = manajemenProduk.getDaftarKategori().get(1);

        // Tambah produk roti (overloading 1)
        manajemenProduk.tambahProduk("Roti Coklat", 15000, 30, roti, "Coklat");
        // Tambah produk pastry (overloading 2)
        manajemenProduk.tambahProduk("Croissant", 25000, 20, pastry, 3);

        while (true) {
            System.out.println("\n=== Lunar Bakeshop ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Produk");
            System.out.println("3. Edit Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    manajemenProduk.tambahProduk();
                    break;
                case 2:
                    manajemenProduk.tampilkanProduk();
                    break;
                case 3:
                    manajemenProduk.editProduk();
                    break;
                case 4:
                    manajemenProduk.hapusProduk();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem Lunar Bakeshop!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        }
    }
}
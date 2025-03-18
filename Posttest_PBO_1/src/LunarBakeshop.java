import java.util.Scanner;
import struktur.ManajemenProduk;

public class LunarBakeshop {
    public static void main(String[] args) {
        ManajemenProduk manajemenProduk = new ManajemenProduk();
        Scanner scanner = new Scanner(System.in);

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
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        }
    }
}

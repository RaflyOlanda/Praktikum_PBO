import java.util.InputMismatchException;
import java.util.Scanner;
import struktur.Kategori;
import struktur.ManajemenProduk;
import struktur.Pelanggan;

public class LunarBakeshop {
    public static void main(String[] args) {
        ManajemenProduk manajemenProduk = new ManajemenProduk();
        Pelanggan pelanggan = new Pelanggan(manajemenProduk);
        Scanner scanner = new Scanner(System.in);

        try {
            Kategori roti = manajemenProduk.getDaftarKategori().get(0);
            Kategori pastry = manajemenProduk.getDaftarKategori().get(1);

            // Tambah produk roti (overloading 1)
            manajemenProduk.tambahProduk("Roti Coklat", 15000, 30, roti, "Coklat");
            // Tambah produk pastry (overloading 2)
            manajemenProduk.tambahProduk("Croissant", 25000, 20, pastry, 3);

            while (true) {
                try {
                    System.out.println("\n=== Lunar Bakeshop ===");
                    System.out.println("1. Menu Admin");
                    System.out.println("2. Menu Pelanggan");
                    System.out.println("3. Keluar");
                    System.out.print("Pilih menu utama: ");

                    int mainMenu = getValidIntInput(scanner);

                    switch (mainMenu) {
                        case 1:
                            menuAdmin(manajemenProduk, scanner);
                            break;
                        case 2:
                            menuPelanggan(pelanggan, scanner);
                            break;
                        case 3:
                            System.out.println("Terima kasih telah menggunakan sistem Lunar Bakeshop!");
                            return;
                        default:
                            System.out.println("Pilihan tidak valid! Silakan pilih 1-3.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid! Harap masukkan angka.");
                    scanner.nextLine(); 
                } catch (Exception e) {
                    System.out.println("Terjadi kesalahan: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan sistem: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void menuAdmin(ManajemenProduk manajemenProduk, Scanner scanner) {
        while (true) {
            try {
                System.out.println("\n=== Menu Admin ===");
                System.out.println("1. Tambah Produk");
                System.out.println("2. Tampilkan Produk");
                System.out.println("3. Edit Produk");
                System.out.println("4. Hapus Produk");
                System.out.println("5. Lihat Detail Produk");
                System.out.println("6. Kembali ke Menu Utama");
                System.out.print("Pilih menu: ");

                int pilihan = getValidIntInput(scanner);

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
                        manajemenProduk.tampilkanDetailProduk();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan pilih 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }

    private static void menuPelanggan(Pelanggan pelanggan, Scanner scanner) {
        while (true) {
            try {
                System.out.println("\n=== Menu Pelanggan ===");
                System.out.println("1. Beli Produk");
                System.out.println("2. Kembali ke Menu Utama");
                System.out.print("Pilih menu: ");

                int pilihan = getValidIntInput(scanner);

                switch (pilihan) {
                    case 1:
                        pelanggan.beliProduk();
                        break;
                    case 2:
                        return;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan pilih 1-2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }

    private static int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Input harus berupa angka. Silakan coba lagi: ");
                scanner.nextLine(); 
            }
        }
    }
}
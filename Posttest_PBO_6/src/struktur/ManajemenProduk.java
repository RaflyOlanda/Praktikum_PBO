package struktur;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenProduk {
    private ArrayList<Produk> daftarProduk = new ArrayList<>();
    private ArrayList<Kategori> daftarKategori = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private static int totalProduk = 2;

    public static int getTotalProduk() {
        return totalProduk;
    }

    public ManajemenProduk() {
        daftarKategori.add(new Kategori("Roti"));
        daftarKategori.add(new Kategori("Pastry"));
    }

    public ArrayList<Produk> getDaftarProduk() {
        return daftarProduk;
    }

    public ArrayList<Kategori> getDaftarKategori() {
        return daftarKategori;
    }

    
    public void tambahProduk() {
        try {
            System.out.print("Masukkan nama produk: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan harga produk: ");
            double harga = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Masukkan stok produk: ");
            int stok = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Pilih kategori:");
            for (int i = 0; i < daftarKategori.size(); i++) {
                System.out.println((i + 1) + ". " + daftarKategori.get(i).getNamaKategori());
            }
            System.out.print("Masukkan nomor kategori: ");
            int kategoriIndex = scanner.nextInt() - 1;
            scanner.nextLine();

            if (kategoriIndex >= 0 && kategoriIndex < daftarKategori.size()) {
                Kategori kategoriDipilih = daftarKategori.get(kategoriIndex);
                Produk produkBaru;

                if (kategoriDipilih.getNamaKategori().equalsIgnoreCase("Roti")) {
                    System.out.print("Masukkan rasa roti: ");
                    String rasa = scanner.nextLine();
                    produkBaru = new ProdukRoti(nama, harga, stok, kategoriDipilih, rasa);
                } else if (kategoriDipilih.getNamaKategori().equalsIgnoreCase("Pastry")) {
                    System.out.println("Pilih ukuran pastry:");
                    System.out.println("1. Mini");
                    System.out.println("2. Sedang");
                    System.out.println("3. Jumbo");
                    System.out.print("Masukkan pilihan (1-3): ");
                    int ukuran = scanner.nextInt();
                    scanner.nextLine();

                    if (ukuran < 1 || ukuran > 3) {
                        System.out.println("Ukuran tidak valid! Default ke Sedang (2)");
                        ukuran = 2;
                    }

                    produkBaru = new ProdukPastry(nama, harga, stok, kategoriDipilih, ukuran);
                } else {
                    System.out.println("Kategori tidak dikenali! Produk tidak ditambahkan.");
                    return;
                }

                daftarProduk.add(produkBaru);
                System.out.println("Produk berhasil ditambahkan!");
                totalProduk++;
            } else {
                System.out.println("Kategori tidak valid!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Pastikan memasukkan angka untuk harga, stok, dan pilihan.");
            scanner.nextLine();
        }
    }

    // Overloading 1: Tambah produk roti dengan rasa (String)
    public void tambahProduk(String nama, double harga, int stok, Kategori kategori, String rasa) {
        if (!kategori.getNamaKategori().equalsIgnoreCase("Roti")) {
            System.out.println("Error: Kategori harus 'Roti'");
            return;
        }
        daftarProduk.add(new ProdukRoti(nama, harga, stok, kategori, rasa));
        System.out.println("Produk roti berhasil ditambahkan!");
    }

    // Overloading 2: Tambah produk pastry dengan ukuran (int)
    public void tambahProduk(String nama, double harga, int stok, Kategori kategori, int ukuran) {
        if (!kategori.getNamaKategori().equalsIgnoreCase("Pastry")) {
            System.out.println("Error: Kategori harus 'Pastry'");
            return;
        }
        if (ukuran < 1 || ukuran > 3) {
            System.out.println("Error: Ukuran harus 1 (Mini), 2 (Sedang), atau 3 (Jumbo)");
            return;
        }
        daftarProduk.add(new ProdukPastry(nama, harga, stok, kategori, ukuran));
        System.out.println("Produk pastry berhasil ditambahkan!");
    }


    public void tampilkanProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada produk!");
        } else {
            System.out.println("\n=== Daftar Produk ===");
            for (int i = 0; i < daftarProduk.size(); i++) {
                Produk p = daftarProduk.get(i);
                System.out.print((i + 1) + ". " + p);
    
                if (p instanceof DeskripsiProduk d && d.stokMenipis()) {
                    System.out.print(" [Stok Menipis]");
                }
    
                System.out.println();
            }
            System.out.println("=====================");
            System.out.println("Total produk terdaftar: " + totalProduk);
        }
    }
    

    public void editProduk() {
        tampilkanProduk();
        if (daftarProduk.isEmpty()) return;

        try {
            System.out.print("Pilih nomor produk yang ingin diedit: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarProduk.size()) {
                Produk produk = daftarProduk.get(index);

                System.out.print("Masukkan nama baru: ");
                produk.setNama(scanner.nextLine());

                System.out.print("Masukkan harga baru: ");
                produk.setHarga(scanner.nextDouble());
                scanner.nextLine();

                System.out.print("Masukkan stok baru: ");
                produk.setStok(scanner.nextInt());
                scanner.nextLine();

                System.out.println("Pilih kategori baru:");
                for (int i = 0; i < daftarKategori.size(); i++) {
                    System.out.println((i + 1) + ". " + daftarKategori.get(i).getNamaKategori());
                }
                System.out.print("Masukkan nomor kategori: ");
                int kategoriIndex = scanner.nextInt() - 1;
                scanner.nextLine();

                if (kategoriIndex >= 0 && kategoriIndex < daftarKategori.size()) {
                    produk.setKategori(daftarKategori.get(kategoriIndex));
                }

                System.out.println("Produk berhasil diperbarui!");

                if (produk instanceof DeskripsiProduk deskriptif && deskriptif.stokMenipis()) {
                    System.out.println("Peringatan: Stok produk ini menipis!");
                }

            } else {
                System.out.println("Nomor produk tidak valid!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Pastikan angka dimasukkan dengan benar.");
            scanner.nextLine();
        }
    }
    

    public void hapusProduk() {
        tampilkanProduk();
        if (daftarProduk.isEmpty()) return;

        try {
            System.out.print("Pilih nomor produk yang ingin dihapus: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarProduk.size()) {
                daftarProduk.remove(index);
                totalProduk--;
                System.out.println("Produk berhasil dihapus!");
            } else {
                System.out.println("Nomor produk tidak valid!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Harus berupa angka.");
            scanner.nextLine();
        }
    }

    public void tampilkanDetailProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada produk.");
            return;
        }

        tampilkanProduk();

        try {
            System.out.print("Pilih nomor produk untuk melihat detail: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < daftarProduk.size()) {
                Produk produk = daftarProduk.get(index);
                System.out.println("\n--- Detail Produk ---");
                System.out.println(produk);

                if (produk instanceof DeskripsiProduk deskripsi) {
                    deskripsi.tampilkanDeskripsi();
                }
            } else {
                System.out.println("Nomor tidak valid!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka.");
            scanner.nextLine();
        }
    }
}
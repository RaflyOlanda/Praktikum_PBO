package struktur;

import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenProduk {
    private ArrayList<Produk> daftarProduk = new ArrayList<>();
    private ArrayList<Kategori> daftarKategori = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ManajemenProduk() {
        daftarKategori.add(new Kategori("Roti"));
        daftarKategori.add(new Kategori("Pastry"));
    }

    public void tambahProduk() {
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
            Produk produkBaru = new Produk(nama, harga, stok, daftarKategori.get(kategoriIndex));
            daftarProduk.add(produkBaru);
            System.out.println("Produk berhasil ditambahkan!");
        } else {
            System.out.println("Kategori tidak valid!");
        }
    }

    public void tampilkanProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada produk!");
        } else {
            System.out.println("\n=== Daftar Produk ===");
            for (int i = 0; i < daftarProduk.size(); i++) {
                System.out.println((i + 1) + ". " + daftarProduk.get(i));
            }
        }
    }

    public void editProduk() {
        tampilkanProduk();
        if (daftarProduk.isEmpty()) return;
        
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
        } else {
            System.out.println("Nomor produk tidak valid!");
        }
    }
    

    public void hapusProduk() {
        tampilkanProduk();
        if (daftarProduk.isEmpty()) return;
        
        System.out.print("Pilih nomor produk yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (index >= 0 && index < daftarProduk.size()) {
            daftarProduk.remove(index);
            System.out.println("Produk berhasil dihapus!");
        } else {
            System.out.println("Nomor produk tidak valid!");
        }
    }
}

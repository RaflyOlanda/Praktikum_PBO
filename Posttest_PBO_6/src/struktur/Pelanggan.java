package struktur;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Pelanggan {
    private ManajemenProduk manajemenProduk;
    private Scanner scanner;

    public Pelanggan(ManajemenProduk manajemenProduk) {
        this.manajemenProduk = manajemenProduk;
        this.scanner = new Scanner(System.in);
    }

    public void beliProduk() {
        try {
            manajemenProduk.tampilkanProduk();
            if (manajemenProduk.getDaftarProduk().isEmpty()) return;

            System.out.print("Pilih nomor produk yang ingin dibeli: ");
            int index = getValidIntInput(scanner) - 1;
            scanner.nextLine();

            if (index >= 0 && index < manajemenProduk.getDaftarProduk().size()) {
                Produk produk = manajemenProduk.getDaftarProduk().get(index);

                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                int jumlah = getValidIntInput(scanner);
                scanner.nextLine();

                if (jumlah <= 0) {
                    System.out.println("Jumlah harus lebih dari 0!");
                    return;
                }

                if (produk.getStok() >= jumlah) {
                    double totalHarga = produk.getHarga() * jumlah;
                    System.out.printf("Total harga: Rp%,.2f%n", totalHarga);
                    
                    System.out.print("Masukkan uang pembayaran: Rp");
                    double pembayaran = getValidDoubleInput(scanner);
                    scanner.nextLine();

                    if (pembayaran >= totalHarga) {
                        produk.setStok(produk.getStok() - jumlah);
                        System.out.println("Pembelian berhasil!");
                        if (pembayaran > totalHarga) {
                            System.out.printf("Kembalian: Rp%,.2f%n", (pembayaran - totalHarga));
                        }
                    } else {
                        System.out.println("Uang tidak cukup! Pembelian dibatalkan.");
                    }
                } else {
                    System.out.println("Stok tidak mencukupi! Stok tersedia: " + produk.getStok());
                }
            } else {
                System.out.println("Nomor produk tidak valid!");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat proses pembelian: " + e.getMessage());
        }
    }

    private int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Input harus berupa angka. Silakan coba lagi: ");
                scanner.nextLine();
            }
        }
    }

    private double getValidDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Input harus berupa angka. Silakan coba lagi: ");
                scanner.nextLine();
            }
        }
    }
}
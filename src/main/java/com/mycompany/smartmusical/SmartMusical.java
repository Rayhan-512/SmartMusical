package com.mycompany.smartmusical;
import java.util.Scanner;

public class SmartMusical {

    public static void cariAlatMusik(String nama, AlatMusik[] daftar, int jumlah) {
        System.out.println("Mencari alat musik berdasarkan nama: " + nama);
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                System.out.print("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Alat musik tidak ditemukan.");
    }

    public static void cariAlatMusik(double harga, AlatMusik[] daftar, int jumlah) {
        System.out.printf("\nMencari alat musik dengan harga: Rp%,.0f%n", harga);
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (Double.compare(daftar[i].getHarga(), harga) == 0) {
                System.out.print("- Ditemukan: ");
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Alat musik dengan harga tersebut tidak ditemukan.");
    }

    public static void tampilkanMenu() {
        System.out.println("============================================");
        System.out.println("       SISTEM PENDATAAN ALAT MUSIK          ");
        System.out.println("============================================");
        System.out.println("1. Tambah Alat Musik Baru");
        System.out.println("2. Tampilkan Seluruh Alat Musik");
        System.out.println("3. Cari Alat Musik");
        System.out.println("4. Tampilkan Total Alat Musik");
        System.out.println("5. Keluar");
        System.out.println("============================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlatMusik[] daftar = new AlatMusik[10];
        int jumlah = 0;
        boolean berjalan = true;

        System.out.println("============================================");
        System.out.println("     SELAMAT DATANG DI SISTEM PENDATAAN     ");
        System.out.println("                 ALAT MUSIK                 ");
        System.out.println("============================================");

        while (berjalan) {
            tampilkanMenu();
            System.out.print("Pilih menu (1-5): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka");
                scanner.nextLine();
                continue;
            }
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlah >= daftar.length) {
                        System.out.println("Kapasitas penyimpanan sudah penuh.");
                        break;
                    }

                        System.out.println("\n-- Pilih Jenis Alat Musik --");
                        System.out.println("1. Gitar");
                        System.out.println("2. Piano");
                        System.out.println("3. Drum");
                        System.out.print("Pilihan (1-3): ");
                        
                        if (!scanner.hasNextInt()) {
                            System.out.println("Pilihan harus berupa angka.");
                            scanner.nextLine();
                            break;
                        }
                        
                        int jenis = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (jenis < 1 || jenis > 3) {
                            System.out.println("Jenis alat musik tidak valid.");
                            break;
                        }

                        System.out.print("Nama Alat Musik: ");
                        String nama = scanner.nextLine();
                        
                        if (nama.trim().isEmpty()) {
                            System.out.println("Nama alat musik tidak boleh kosong");
                            break;
                        }
                        
                        System.out.print("Harga Alat Musik: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Harga harus berupa angka");
                            scanner.nextLine();
                            break;
                        }
                        
                        double harga = scanner.nextDouble();
                        scanner.nextLine();
                        
                        if (harga <= 0) {
                        System.out.println("Harga harus lebih dari 0.");
                        break;
                    }
                    
                    System.out.print("Tahun Produksi: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Tahun harus berupa angka.");
                        scanner.nextLine();
                        break;
                    }

                    int tahun = scanner.nextInt();
                    scanner.nextLine();

                    if (tahun < 1900 || tahun > 2026) {
                        System.out.println("Tahun produksi harus antara 1900 sampai 2026.");
                        break;
                    }

                    AlatMusik alatMusikBaru;

                    if (jenis == 1) {

                        System.out.print("Jumlah Senar: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Jumlah senar harus berupa angka.");
                            scanner.nextLine();
                            break;
                        }

                        int senar = scanner.nextInt();
                        scanner.nextLine();

                        if (senar <= 0) {
                            System.out.println("Jumlah senar harus lebih dari 0.");
                            break;
                        }

                        alatMusikBaru = new Gitar(nama, harga, tahun, senar);

                    } else if (jenis == 2) {
                        System.out.print("Jumlah Tuts: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Jumlah tuts harus berupa angka.");
                            scanner.nextLine();
                            break;
                        }

                        int tuts = scanner.nextInt();
                        scanner.nextLine();

                        if (tuts <= 0) {
                            System.out.println("Jumlah tuts harus lebih dari 0.");
                            break;
                        }

                        alatMusikBaru = new Piano(nama, harga, tahun, tuts);

                    } else {
                        System.out.print("Jumlah Komponen Drum: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("Jumlah komponen harus berupa angka.");
                            scanner.nextLine();
                            break;
                        }

                        int komponen = scanner.nextInt();
                        scanner.nextLine();

                        if (komponen <= 0) {
                            System.out.println("Jumlah komponen harus lebih dari 0.");
                            break;
                        }

                        alatMusikBaru = new Drum(nama, harga, tahun, komponen);
                    }

                    daftar[jumlah] = alatMusikBaru;
                    jumlah++;
                    AlatMusik.tambahTotalAlatMusik();
                    System.out.println("Alat musik berhasil ditambahkan!");
                    break;

                case 2:
                    System.out.println("\n========== DAFTAR SELURUH ALAT MUSIK ==========");
                    if (jumlah == 0) {
                        System.out.println("Belum ada alat musik yang tersimpan.");

                    } else {
                        for (int i = 0; i < jumlah; i++) {
                            System.out.println("\nAlat Musik ke-" + (i + 1));
                            daftar[i].tampilkanInfo();
                            daftar[i].caraPerawatan();
                        }

                        System.out.println("--------------------------------------------");
                        System.out.println("Total alat musik: " + AlatMusik.getTotalAlatMusik());
                    }
                    break;

                case 3:
                    System.out.println("\n========== PENCARIAN ALAT MUSIK ==========");
                    System.out.println("1. Cari berdasarkan nama");
                    System.out.println("2. Cari berdasarkan harga");
                    System.out.print("Pilih (1-2): ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Pilihan harus berupa angka.");
                        scanner.nextLine();
                        break;
                    }

                    int mode = scanner.nextInt();
                    scanner.nextLine();

                    if (mode == 1) {
                        System.out.print("Masukkan nama alat musik: ");
                        String namaCari = scanner.nextLine();
                        cariAlatMusik(namaCari, daftar, jumlah);

                    } else if (mode == 2) {
                        System.out.print("Masukkan harga alat musik: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Harga harus berupa angka.");
                            scanner.nextLine();
                            break;
                        }

                        double hargaCari =scanner.nextDouble();
                        scanner.nextLine();

                        if (hargaCari <= 0) {
                            System.out.println("Harga harus lebih dari 0.");
                            break;
                        }

                        cariAlatMusik(hargaCari, daftar, jumlah);

                    } else {
                        System.out.println("Pilihan pencarian tidak valid.");
                    }
                    
                    break;

                case 4:
                    System.out.println("Total alat musik yang berhasil dibuat: " + AlatMusik.getTotalAlatMusik());
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan Smart Musical!.");
                    berjalan = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu 1-5.");
            }
        }

        scanner.close();
    }
}
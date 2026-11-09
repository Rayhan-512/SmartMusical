package com.mycompany.smartmusical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmartMusical {

    private final ArrayList<AlatMusik> daftarAlatMusik;
    private final HashMap<String, Pelanggan> dataPelanggan;
    private final RuangPenyimpanan ruangPenyimpanan;

    public SmartMusical() {

        daftarAlatMusik = new ArrayList<>();
        dataPelanggan = new HashMap<>();
        ruangPenyimpanan = new RuangPenyimpanan("Ruang Penyimpanan SmartMusical", 20);
    }

    public void tampilkanInfoRuang() {
        System.out.println("\n=== INFORMASI RUANG PENYIMPANAN ===");
        ruangPenyimpanan.tampilkanInfo();
    }

    public void tambahAlatMusik(AlatMusik alat) throws AlatMusikException {

        if (alat == null) {
            throw new AlatMusikException("Objek alat musik tidak boleh kosong.");
        }

        daftarAlatMusik.add(alat);
        AlatMusik.tambahTotalAlatMusik();
        System.out.println("Alat musik berhasil ditambahkan.");
    }

    public void lihatSemuaKoleksi() {
        if (daftarAlatMusik.isEmpty()) {
            System.out.println("Belum ada alat musik yang tersimpan.");
            return;
        }

        System.out.println("\n========== DAFTAR ALAT MUSIK ==========");
        for (int i = 0; i < daftarAlatMusik.size(); i++) {
            AlatMusik alat = daftarAlatMusik.get(i);
            System.out.println("\nAlat Musik ke-" + (i + 1));
            alat.tampilkanInfo();
            alat.tampilkanKarakteristik();
            if (alat instanceof DapatDirawat) {
                DapatDirawat perawatan =
                    (DapatDirawat) alat;
                perawatan.caraPerawatan();
            }
        }

        System.out.println("\nJumlah alat musik: " + daftarAlatMusik.size());
    }

    public AlatMusik cariAlatMusik(String nama) throws AlatMusikException {

        if (nama == null || nama.trim().isEmpty()) {
            throw new AlatMusikException("Nama alat musik tidak boleh kosong.");
        }

        for (AlatMusik alat : daftarAlatMusik) {
            if (alat.getNama().equalsIgnoreCase(nama.trim())) {
                return alat;
            }
        }

        throw new AlatMusikException("Alat musik dengan nama '" + nama + "' tidak ditemukan.");
    }

    public AlatMusik getAlatMusik(int nomor) throws AlatMusikException {

        if (nomor < 1 || nomor > daftarAlatMusik.size()) {
            throw new AlatMusikException("Nomor alat musik tidak tersedia.");
        }
        return daftarAlatMusik.get(nomor - 1);
    }

    public int getJumlahKoleksi() {
        return daftarAlatMusik.size();
    }

    public void tambahPelanggan(Pelanggan pelanggan) throws AlatMusikException {

        if (pelanggan == null) {
            throw new AlatMusikException("Data pelanggan tidak boleh kosong.");
        }

        String id = pelanggan.getId();

        if (dataPelanggan.containsKey(id)) {
            throw new AlatMusikException("ID pelanggan sudah terdaftar.");
        }

        dataPelanggan.put(id, pelanggan);
        System.out.println("Pelanggan berhasil ditambahkan.");
    }

    public Pelanggan cariPelanggan(String id) throws AlatMusikException {

        if (id == null || id.trim().isEmpty()) {
            throw new AlatMusikException("ID pelanggan tidak boleh kosong.");
        }

        Pelanggan pelanggan = dataPelanggan.get(id.trim());

        if (pelanggan == null) {
            throw new AlatMusikException("Pelanggan dengan ID tersebut tidak ditemukan.");
        }

        return pelanggan;
    }

    public void lihatSemuaAnggota() {
        if (dataPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan yang terdaftar.");
            return;
        }

        System.out.println("\n========== DAFTAR PELANGGAN ==========");
        for (Map.Entry<String, Pelanggan> data : dataPelanggan.entrySet()) {
            data.getValue().tampilkanInfo();
            System.out.println("--------------------------------");
        }

        System.out.println("Jumlah pelanggan: " + dataPelanggan.size());
    }

    public int getJumlahPelanggan() {
        return dataPelanggan.size();
    }

    public static int bacaInteger(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka bulat.");
            }
        }
    }

    public static double bacaDouble(Scanner scanner, String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka.");
            }
        }
    }

    public static AlatMusik inputAlatMusik(Scanner scanner)throws AlatMusikException {
        System.out.println("\n-- PILIH JENIS ALAT MUSIK --");
        System.out.println("1. Gitar");
        System.out.println("2. Piano");
        System.out.println("3. Drum");
        System.out.println("4. Biola");
        int jenis = bacaInteger(scanner, "Pilihan jenis (1-4): ");
        if (jenis < 1 || jenis > 4) {
            throw new AlatMusikException("Pilihan jenis alat musik tidak valid.");
        }

        System.out.print("Nama alat musik: ");
        String nama = scanner.nextLine();
        if (nama.trim().isEmpty()) {
            throw new AlatMusikException("Nama alat musik tidak boleh kosong.");
        }

        double harga = bacaDouble(scanner, "Harga alat musik: ");
        if (harga <= 0) {
            throw new AlatMusikException("Harga harus lebih dari 0.");
        }

        int tahun = bacaInteger(scanner, "Tahun produksi: ");
        if (tahun < 1900 || tahun > 2026) {
            throw new AlatMusikException("Tahun produksi harus antara 1900 sampai 2026.");
        }
        int jumlah;
        switch (jenis) {
            case 1:
                jumlah = bacaInteger(scanner, "Jumlah senar gitar: ");
                if (jumlah <= 0) {
                    throw new AlatMusikException("Jumlah senar harus lebih dari 0.");
                }

                return new Gitar(nama, harga, tahun, jumlah);

            case 2:
                jumlah = bacaInteger(scanner, "Jumlah tuts piano: ");
                if (jumlah <= 0) {
                    throw new AlatMusikException("Jumlah tuts harus lebih dari 0.");
                }

                return new Piano(nama, harga, tahun, jumlah);

            case 3:
                jumlah = bacaInteger(scanner, "Jumlah komponen drum: ");
                if (jumlah <= 0) {
                    throw new AlatMusikException("Jumlah komponen harus lebih dari 0.");
                }

                return new Drum(nama, harga, tahun, jumlah);

            default:
                jumlah = bacaInteger(scanner, "Jumlah senar biola: ");
                if (jumlah <= 0) {
                    throw new AlatMusikException("Jumlah senar harus lebih dari 0.");
                }

                return new Biola(nama, harga, tahun, jumlah);
        }
    }

    public static void menuPelanggan(Scanner scanner, SmartMusical sistem) throws AlatMusikException {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n========== KELOLA PELANGGAN ==========");
            System.out.println("1. Tambah pelanggan");
            System.out.println("2. Lihat semua pelanggan");
            System.out.println("3. Cari pelanggan berdasarkan ID");
            System.out.println("4. Kembali ke menu utama");
            int pilihan = bacaInteger(scanner, "Pilih menu pelanggan: ");

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    if (id.trim().isEmpty()
                            || nama.trim().isEmpty()) {
                        throw new AlatMusikException("ID dan nama pelanggan tidak boleh kosong.");
                    }

                    Pelanggan pelangganBaru = new Pelanggan(id, nama);

                    sistem.tambahPelanggan(pelangganBaru);
                    break;

                case 2:
                    sistem.lihatSemuaAnggota();
                    break;

                case 3:
                    System.out.print("Masukkan ID pelanggan yang dicari: ");
                    Pelanggan hasil = sistem.cariPelanggan(scanner.nextLine());
                    System.out.println("Data pelanggan ditemukan:");
                    hasil.tampilkanInfo();
                    break;

                case 4:
                    kembali = true;
                    break;

                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }
        }
    }

    public static void jalankanTransaksi(Scanner scanner, SmartMusical sistem, TransaksiPeminjaman transaksi) throws AlatMusikException {
        if (sistem.getJumlahKoleksi() == 0
                || sistem.getJumlahPelanggan() == 0) {
            throw new AlatMusikException("Data pelanggan atau alat musik belum tersedia.");
        }

        sistem.lihatSemuaAnggota();
        System.out.print("Masukkan ID pelanggan: ");
        Pelanggan pelanggan = sistem.cariPelanggan(scanner.nextLine());
        sistem.lihatSemuaKoleksi();
        int nomor = bacaInteger(scanner, "Pilih nomor alat musik: ");
        AlatMusik alat = sistem.getAlatMusik(nomor);
        transaksi.prosesPinjam(pelanggan, alat);
    }

    public static void tampilkanMenu() {
        System.out.println("\n============================================");
        System.out.println("           SISTEM SMARTMUSICAL");
        System.out.println("============================================");
        System.out.println("1. Informasi ruang penyimpanan");
        System.out.println("2. Tampilkan semua alat musik");
        System.out.println("3. Kelola data pelanggan");
        System.out.println("4. Tambah alat musik");
        System.out.println("5. Cari alat musik");
        System.out.println("6. Transaksi peminjaman");
        System.out.println("7. Simulasi memainkan alat musik");
        System.out.println("8. Tampilkan jumlah data");
        System.out.println("9. Keluar");
        System.out.println("============================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartMusical sistem = new SmartMusical();
        TransaksiPeminjaman transaksi =
            new TransaksiPeminjaman();
        try {
            sistem.tambahAlatMusik(new Gitar("Gitar Akustik", 1500000, 2024, 6));
            sistem.tambahAlatMusik(new Piano("Piano Digital", 4500000, 2023, 88));
            sistem.tambahAlatMusik(new Drum("Drum Akustik", 3200000, 2022, 5));
            sistem.tambahAlatMusik(new Biola("Biola Pemula", 1200000, 2025, 4));
            sistem.tambahPelanggan(new Pelanggan("P001", "Andi"));
            sistem.tambahPelanggan(new Pelanggan("P002", "Budi"));
            sistem.tambahPelanggan(new Pelanggan("P003", "Citra"));
        } catch (AlatMusikException e) {
            System.out.println("Gagal menyiapkan data awal: " + e.getMessage());
        }
        boolean berjalan = true;

        System.out.println("\nSelamat datang di Sistem SmartMusical!");
        while (berjalan) {
            tampilkanMenu();
            int pilihan = bacaInteger(scanner, "Pilih menu (1-9): ");
            try {
                switch (pilihan) {
                    case 1:
                        sistem.tampilkanInfoRuang();
                        break;
                        
                    case 2:
                        sistem.lihatSemuaKoleksi();
                        break;
                        
                    case 3:
                        menuPelanggan(scanner, sistem);
                        break;
                        
                    case 4:
                        AlatMusik alatBaru =
                            inputAlatMusik(scanner);
                        sistem.tambahAlatMusik(alatBaru);
                        break;
                        
                    case 5:
                        System.out.print("Masukkan nama alat musik: ");
                        AlatMusik hasil = sistem.cariAlatMusik(scanner.nextLine());
                        System.out.println("Data alat musik ditemukan:");
                        hasil.tampilkanInfo();
                        break;

                    case 6:
                        jalankanTransaksi(scanner, sistem, transaksi);
                        break;

                    case 7:
                        sistem.lihatSemuaKoleksi();
                        for (int i = 0;
                                i < sistem.getJumlahKoleksi(); i++) {
                            AlatMusik alat =
                                sistem.getAlatMusik(i + 1);
                            if (alat instanceof DapatDimainkan) {
                                System.out.println("\nMemainkan " + alat.getNama());
                                DapatDimainkan pemain =
                                    (DapatDimainkan) alat;
                                pemain.mainkan();
                            }
                        }
                        break;

                    case 8:
                        System.out.println("Jumlah alat musik: " + sistem.getJumlahKoleksi());
                        System.out.println("Jumlah pelanggan: "+ sistem.getJumlahPelanggan());
                        System.out.println("Total transaksi: "+ TransaksiPeminjaman.getTotalTransaksi());
                        break;

                    case 9:
                        System.out.println("Terima kasih telah menggunakan SmartMusical.");
                        berjalan = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak tersedia. Pilih menu 1-9.");
                }

            } catch (AlatMusikException e) {
                System.out.println("Kesalahan: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
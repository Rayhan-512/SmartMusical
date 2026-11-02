package com.mycompany.smartmusical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class SmartMusical {

    public static void validasiDataAlatMusik(String nama, double harga, int tahun) throws AlatMusikException {

        if (nama == null || nama.trim().isEmpty()) {
            throw new AlatMusikException("Nama alat musik tidak boleh kosong.");
        }

        if (harga <= 0) {
            throw new AlatMusikException("Harga alat musik harus lebih dari 0.");
        }

        if (tahun < 1900 || tahun > 2026) {
            throw new AlatMusikException("Tahun produksi harus antara 1900 sampai 2026.");
        }
    }

    public static void tampilkanSemua(ArrayList<AlatMusik> daftar) {

        if (daftar.isEmpty()) {
            System.out.println("Belum ada alat musik yang tersimpan.");
            return;
        }

        System.out.println("\n========== DAFTAR ALAT MUSIK (ArrayList) ==========");

        for (int i = 0; i < daftar.size(); i++) {
            AlatMusik alat = daftar.get(i);

            System.out.println("\nAlat Musik ke-" + (i + 1));

            alat.tampilkanInfo();
            alat.tampilkanKarakteristik();

            if (alat instanceof DapatDirawat) {
                DapatDirawat perawat = (DapatDirawat) alat;
                perawat.caraPerawatan();
            }
        }

        System.out.println("\nJumlah alat musik: " + daftar.size());
    }

    public static void cariAlatMusik(String nama, ArrayList<AlatMusik> daftar) throws AlatMusikException {

        if (nama == null || nama.trim().isEmpty()) {
            throw new AlatMusikException("Nama pencarian tidak boleh kosong.");
        }

        for (AlatMusik alat : daftar) {
            if (alat.getNama().equalsIgnoreCase(nama.trim())) {
                System.out.println("Data alat musik ditemukan:");
                alat.tampilkanInfo();
                return;
            }
        }

        throw new AlatMusikException("Alat musik dengan nama '" + nama+ "' tidak ditemukan.");
    }

    public static AlatMusik buatAlatMusik(Scanner scanner) throws AlatMusikException {
        System.out.println("\nPilih jenis alat musik:");
        System.out.println("1. Gitar");
        System.out.println("2. Piano");
        System.out.println("3. Drum");
        System.out.println("4. Biola");
        System.out.print("Pilihan jenis: ");

        int jenis = scanner.nextInt();
        scanner.nextLine();

        if (jenis < 1 || jenis > 4) {
            throw new AlatMusikException("Pilihan jenis alat musik tidak valid.");
        }

        System.out.print("Nama alat musik: ");
        String nama = scanner.nextLine();

        System.out.print("Harga alat musik: ");
        double harga = scanner.nextDouble();

        System.out.print("Tahun produksi: ");
        int tahun = scanner.nextInt();
        scanner.nextLine();

        validasiDataAlatMusik(nama, harga, tahun);

        String keterangan =
            jenis == 2 ? "tuts"
            : jenis == 3 ? "komponen"
            : "senar";

        System.out.print("Jumlah " + keterangan + ": ");

        int jumlah = scanner.nextInt();
        scanner.nextLine();

        if (jumlah <= 0) {
            throw new AlatMusikException("Jumlah karakteristik alat musik harus lebih dari 0.");
        }

        switch (jenis) {
            case 1:
                return new Gitar(nama, harga, tahun, jumlah);
            case 2:
                return new Piano(nama, harga, tahun, jumlah);
            case 3:
                return new Drum(nama, harga, tahun, jumlah);
            default:
                return new Biola(nama, harga, tahun, jumlah);
        }
    }

    public static void simulasiMainkan(ArrayList<AlatMusik> daftar) {

        if (daftar.isEmpty()) {
            System.out.println("Belum ada alat musik yang tersimpan.");
            return;
        }

        System.out.println("\n========== SIMULASI MEMAINKAN ALAT MUSIK ==========");

        for (int i = 0; i < daftar.size(); i++) {
            AlatMusik alat = daftar.get(i);

            System.out.println("\n" + (i + 1) + ". " + alat.getNama());

            if (alat instanceof DapatDimainkan) {
                DapatDimainkan pemain = (DapatDimainkan) alat;
                pemain.mainkan();
            }
        }
    }

    public static void tampilkanHashMap(HashMap<String, AlatMusik> inventaris) {

        if (inventaris.isEmpty()) {System.out.println("Data inventaris HashMap masih kosong.");
            return;
        }

        System.out.println(
            "\n========== DATA INVENTARIS (HashMap) =========="
        );

        for (Map.Entry<String, AlatMusik> data: inventaris.entrySet()) {

            System.out.println("Kode Inventaris: " + data.getKey());
            data.getValue().tampilkanInfo();
            System.out.println("-----------------------------------------------");
        }
    }

    public static void tambahHashMap(String kode, int nomorAlat, ArrayList<AlatMusik> daftar,
            HashMap<String, AlatMusik> inventaris) throws AlatMusikException {

        if (kode == null || kode.trim().isEmpty()) {
            throw new AlatMusikException("Kode inventaris tidak boleh kosong.");
        }

        kode = kode.trim();

        if (inventaris.containsKey(kode)) {
            throw new AlatMusikException("Kode inventaris sudah digunakan.");
        }

        if (nomorAlat < 1 || nomorAlat > daftar.size()) {
            throw new AlatMusikException("Nomor alat musik tidak ditemukan di ArrayList.");
        }

        inventaris.put(kode, daftar.get(nomorAlat - 1));

        System.out.println("Data berhasil ditambahkan ke HashMap.");
    }

    public static void cariHashMap(
            String kode,
            HashMap<String, AlatMusik> inventaris)
            throws AlatMusikException {

        if (kode == null || kode.trim().isEmpty()) {
            throw new AlatMusikException("Kode pencarian tidak boleh kosong.");
        }

        kode = kode.trim();

        if (!inventaris.containsKey(kode)) {
            throw new AlatMusikException("Kode inventaris '" + kode + "' tidak ditemukan.");
        }

        AlatMusik alat = inventaris.get(kode);

        System.out.println("Data inventaris ditemukan:");
        System.out.println("Kode: " + kode);
        alat.tampilkanInfo();
    }

    public static void menuHashMap(
            Scanner scanner,
            ArrayList<AlatMusik> daftar,
            HashMap<String, AlatMusik> inventaris)
            throws AlatMusikException {

        boolean kembali = false;

        while (!kembali) {
            System.out.println("\n========== KELOLA HASHMAP ==========");
            System.out.println("1. Tampilkan semua data inventaris");
            System.out.println("2. Tambah data inventaris");
            System.out.println("3. Cari data berdasarkan kode");
            System.out.println("4. Kembali ke menu utama");
            System.out.print("Pilih menu HashMap: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanHashMap(inventaris);
                    break;

                case 2:
                    if (daftar.isEmpty()) {
                        throw new AlatMusikException("Tambahkan alat musik ke ArrayList terlebih dahulu.");
                    }

                    tampilkanSemua(daftar);

                    System.out.print("Masukkan kode inventaris baru: ");

                    String kode = scanner.nextLine();

                    System.out.print("Pilih nomor alat musik dari daftar: ");

                    int nomor = scanner.nextInt();
                    scanner.nextLine();

                    tambahHashMap(
                        kode, nomor, daftar, inventaris
                    );
                    break;

                case 3:
                    System.out.print(
                        "Masukkan kode inventaris yang dicari: "
                    );

                    String kodeCari = scanner.nextLine();

                    cariHashMap(kodeCari, inventaris);
                    break;

                case 4:
                    kembali = true;
                    break;

                default:
                    System.out.println(
                        "Pilihan menu HashMap tidak valid."
                    );
            }
        }
    }

    public static void tampilkanMenu() {
        System.out.println(
            "\n============================================"
        );
        System.out.println(
            "          SISTEM PENDATAAN SMARTMUSICAL"
        );
        System.out.println(
            "============================================"
        );
        System.out.println(
            "1. Tampilkan seluruh alat musik"
        );
        System.out.println(
            "2. Tambah alat musik baru"
        );
        System.out.println(
            "3. Cari alat musik berdasarkan nama"
        );
        System.out.println(
            "4. Simulasi memainkan seluruh alat musik"
        );
        System.out.println(
            "5. Kelola data inventaris"
        );
        System.out.println(
            "6. Tampilkan total alat musik"
        );
        System.out.println(
            "7. Keluar"
        );
        System.out.println(
            "============================================"
        );
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<AlatMusik> daftar = new ArrayList<>();

        HashMap<String, AlatMusik> inventaris =
            new HashMap<>();

        daftar.add(
            new Gitar("Gitar Akustik", 1500000, 2024, 6)
        );

        daftar.add(
            new Piano("Piano Digital", 4500000, 2023, 88)
        );

        daftar.add(
            new Drum("Drum Akustik", 3200000, 2022, 5)
        );

        daftar.add(
            new Biola("Biola Pemula", 1200000, 2025, 4)
        );

        for (int i = 0; i < daftar.size(); i++) {
            AlatMusik.tambahTotalAlatMusik();
        }

        inventaris.put("GT001", daftar.get(0));
        inventaris.put("PN001", daftar.get(1));
        inventaris.put("DR001", daftar.get(2));

        boolean berjalan = true;

        System.out.println(
            "Selamat datang di Sistem Pendataan SmartMusical!"
        );

        while (berjalan) {
            try {
                tampilkanMenu();

                System.out.print("Pilih menu (1-7): ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        tampilkanSemua(daftar);
                        break;

                    case 2:
                        AlatMusik alatBaru =
                            buatAlatMusik(scanner);

                        daftar.add(alatBaru);
                        AlatMusik.tambahTotalAlatMusik();

                        System.out.println(
                            "Alat musik berhasil ditambahkan ke ArrayList."
                        );
                        break;

                    case 3:
                        System.out.print(
                            "Masukkan nama alat musik yang dicari: "
                        );

                        String namaCari = scanner.nextLine();

                        cariAlatMusik(namaCari, daftar);
                        break;

                    case 4:
                        simulasiMainkan(daftar);
                        break;

                    case 5:
                        menuHashMap(
                            scanner, daftar, inventaris
                        );
                        break;

                    case 6:
                        System.out.println(
                            "Total alat musik: "
                            + AlatMusik.getTotalAlatMusik()
                        );
                        break;

                    case 7:
                        berjalan = false;

                        System.out.println(
                            "Terima kasih telah menggunakan SmartMusical!"
                        );
                        break;

                    default:
                        System.out.println(
                            "Pilihan tidak valid. Silakan pilih menu 1-7."
                        );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                    "Error Input: Masukkan angka sesuai pilihan atau data yang diminta."
                );

                scanner.nextLine();

            } catch (AlatMusikException e) {

                System.out.println(
                    "Error Data: " + e.getMessage()
                );

            } finally {

                System.out.println(
                    "Finally: proses menu telah selesai diperiksa."
                );
            }
        }

        scanner.close();
    }
}
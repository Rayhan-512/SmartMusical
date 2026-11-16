package com.mycompany.smartmusical;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransaksiPeminjaman {
    private static int totalTransaksi = 0;
    private static final String FILE_LOG = "log_transaksi.txt";

    public void prosesPinjam(Pelanggan pelanggan, AlatMusik alat) {
        System.out.println("\n========== TRANSAKSI PEMINJAMAN ==========");

        if (pelanggan == null || alat == null) {
            System.out.println("Transaksi gagal. Data tidak tersedia.");
            return;
        }

        totalTransaksi++;
        String nomor = "TRX" + totalTransaksi;
        String waktu = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        );

        System.out.println("Nomor Transaksi : " + nomor);
        System.out.println("Waktu           : " + waktu);
        System.out.println("Nama Pelanggan  : " + pelanggan.getNama());
        System.out.println("ID Pelanggan    : " + pelanggan.getId());
        System.out.println("Nama Alat Musik : " + alat.getNama());
        System.out.println("Status          : Peminjaman berhasil diproses.");

        try (FileWriter writer = new FileWriter(FILE_LOG, true)) {
            writer.write("Nomor Transaksi : " + nomor + System.lineSeparator());
            writer.write("Waktu           : " + waktu + System.lineSeparator());
            writer.write("Nama Pelanggan  : " + pelanggan.getNama() + System.lineSeparator());
            writer.write("ID Pelanggan    : " + pelanggan.getId() + System.lineSeparator());
            writer.write("Nama Alat Musik : " + alat.getNama() + System.lineSeparator());
            writer.write("Status          : Peminjaman berhasil diproses." + System.lineSeparator());
            writer.write("----------------------------------------" + System.lineSeparator());
            System.out.println("Riwayat transaksi berhasil dicatat ke " + FILE_LOG);
        } catch (IOException e) {
            System.out.println("Gagal mencatat log transaksi: " + e.getMessage());
        }
    }

    public static int getTotalTransaksi() {
        return totalTransaksi;
    }
}

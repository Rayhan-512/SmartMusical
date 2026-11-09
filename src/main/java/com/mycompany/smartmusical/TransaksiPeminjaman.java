package com.mycompany.smartmusical;

public class TransaksiPeminjaman {

    private static int totalTransaksi = 0;

    public void prosesPinjam(Pelanggan pelanggan, AlatMusik alat) {

        System.out.println("\n========== TRANSAKSI PEMINJAMAN ==========");

        if (pelanggan == null || alat == null) {
            System.out.println("Transaksi gagal. Data tidak tersedia.");
            return;
        }

        totalTransaksi++;

        System.out.println("Nomor Transaksi : TRX" + totalTransaksi);
        System.out.println("Nama Pelanggan  : " + pelanggan.getNama());
        System.out.println("ID Pelanggan    : " + pelanggan.getId());
        System.out.println("Nama Alat Musik : " + alat.getNama());
        System.out.println("Status          : Peminjaman berhasil diproses.");
    }

    public static int getTotalTransaksi() {
        return totalTransaksi;
    }
}
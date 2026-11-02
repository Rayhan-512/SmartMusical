package com.mycompany.smartmusical;

public abstract class AlatMusik {
    private String nama;
    private double harga;
    private int tahunProduksi;

    private static int totalAlatMusik = 0;

    public AlatMusik(String nama, double harga, int tahunProduksi) {
        this.nama = nama;
        this.harga = harga;
        this.tahunProduksi = tahunProduksi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public static void tambahTotalAlatMusik() {
        totalAlatMusik++;
    }

    public static int getTotalAlatMusik() {
        return totalAlatMusik;
    }

    public void tampilkanInfo() {
        System.out.printf("Nama: %-18s | Harga: Rp%,.0f | Tahun: %d%n", nama, harga, tahunProduksi);
    }

    public abstract void tampilkanKarakteristik();
}
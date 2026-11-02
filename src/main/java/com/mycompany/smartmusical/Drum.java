package com.mycompany.smartmusical;

public class Drum extends AlatMusik implements DapatDimainkan, DapatDirawat {

    private int jumlahKomponen;

    public Drum(String nama, double harga,int tahunProduksi, int jumlahKomponen) {
        super(nama, harga, tahunProduksi);
        this.jumlahKomponen = jumlahKomponen;
    }

    public int getJumlahKomponen() {
        return jumlahKomponen;
    }

    public void setJumlahKomponen(int jumlahKomponen) {
        this.jumlahKomponen = jumlahKomponen;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("Jenis: Drum | Jumlah Komponen: %d%n", jumlahKomponen);
    }

    @Override
    public void tampilkanKarakteristik() {
        System.out.println("Karakteristik: Drum menghasilkan bunyi ketika permukaannya dipukul.");
    }

    @Override
    public void mainkan() {
        System.out.println("Drum dimainkan dengan cara dipukul.");
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Perawatan Drum: Bersihkan permukaan drum dan simpan di tempat kering.");
    }
}
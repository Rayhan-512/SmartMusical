package com.mycompany.smartmusical;

public class Gitar extends AlatMusik implements DapatDimainkan, DapatDirawat {

    private int jumlahSenar;

    public Gitar(String nama, double harga,int tahunProduksi, int jumlahSenar) {
        super(nama, harga, tahunProduksi);
        this.jumlahSenar = jumlahSenar;
    }

    public int getJumlahSenar() {
        return jumlahSenar;
    }

    public void setJumlahSenar(int jumlahSenar) {
        this.jumlahSenar = jumlahSenar;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("Jenis: Gitar | Jumlah Senar: %d%n", jumlahSenar);
    }

    @Override
    public void tampilkanKarakteristik() {
        System.out.println("Karakteristik: Gitar menghasilkan suara dengan memetik senarnya.");
    }

    @Override
    public void mainkan() {
        System.out.println("Gitar dimainkan dengan cara dipetik.");
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Perawatan Gitar: Bersihkan senar dan simpan di tempat kering.");
    }
}
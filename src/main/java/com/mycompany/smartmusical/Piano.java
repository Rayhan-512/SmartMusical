package com.mycompany.smartmusical;

public class Piano extends AlatMusik implements DapatDimainkan, DapatDirawat {

    private int jumlahTuts;

    public Piano(String nama, double harga,int tahunProduksi, int jumlahTuts) {
        super(nama, harga, tahunProduksi);
        this.jumlahTuts = jumlahTuts;
    }

    public int getJumlahTuts() {
        return jumlahTuts;
    }

    public void setJumlahTuts(int jumlahTuts) {
        this.jumlahTuts = jumlahTuts;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("Jenis: Piano | Jumlah Tuts: %d%n", jumlahTuts);
    }

    @Override
    public void tampilkanKarakteristik() {
        System.out.println("Karakteristik: Piano menghasilkan nada saat tuts ditekan.");
    }

    @Override
    public void mainkan() {
        System.out.println("Piano dimainkan dengan cara menekan tuts.");
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Perawatan Piano: Jaga kebersihan tuts dan hindari tempat lembap.");
    }
}
package com.mycompany.smartmusical;

public class Biola extends AlatMusik implements DapatDimainkan, DapatDirawat {

    private int jumlahSenar;

    public Biola(String nama, double harga, int tahunProduksi, int jumlahSenar) {

        super(nama, harga, tahunProduksi);
        setJumlahSenar(jumlahSenar);
    }

    public int getJumlahSenar() {
        return this.jumlahSenar;
    }

    public void setJumlahSenar(int jumlahSenar) {
        if (jumlahSenar <= 0) {
            System.out.println("Jumlah senar harus lebih dari 0.");
            return;
        }

        this.jumlahSenar = jumlahSenar;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("Jenis: Biola | Jumlah Senar: %d%n",this.jumlahSenar);
    }

    @Override
    public void tampilkanKarakteristik() {
        System.out.println("Karakteristik: Biola menghasilkan suara saat senarnya digesek dengan bow.");
    }

    @Override
    public void mainkan() {
        System.out.println("Biola dimainkan dengan cara digesek menggunakan bow.");
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Perawatan Biola: Simpan di dalam case dan jaga senar tetap bersih.");
    }
}
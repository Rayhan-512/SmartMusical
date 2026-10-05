package com.mycompany.smartmusical;

public class Biola extends AlatMusik {
    private int jumlahSenar;
    
    public Biola(String nama, double harga, int tahun, int jumlahSenar) {
        super(nama, harga, tahun);
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
        System.out.printf("Biola | Nama: %s | Harga: Rp%,.0f | Tahun: %d | Jumlah Senar: %d%n", 
                getNama(), getHarga(), getTahunProduksi(), jumlahSenar);
    }
    
    @Override
    public void caraPerawatan() {
        System.out.println("Perawatan: Simpan biola di dalam case dan jaga senar tetap bersih.");
    }
    
    @Override
    public void mainkan() {
        System.out.println("Biola dimainkan dengan cara digesek menggunakan bow.");
    }
}
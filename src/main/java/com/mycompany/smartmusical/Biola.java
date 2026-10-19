package com.mycompany.smartmusical;

public class Biola extends AlatMusik implements DapatDimainkan, DapatDirawat{
    private int jumlahSenar;
    
    public Biola(String nama, double harga, int tahun, int jumlahSenar) {
        super(nama, harga, tahun);
        this.jumlahSenar = jumlahSenar;
    }
    
    public int getJumlahSenar() {
        return jumlahSenar;
    }
    
    public void setJumlahSenar(int jumlahSenar) {
        if (jumlahSenar <= 0) {
            System.out.println(
                "Jumlah senar biola harus lebih dari 0.");
            return;
        }
        this.jumlahSenar = jumlahSenar;
    }
    
    @Override
    public void tampilkanInfo() {
        System.out.printf("Nama: %-18s | Harga: Rp%,.0f | Tahun: %d%n",
            getNama(), getHarga(), getTahunProduksi());
        System.out.printf("Jenis: Biola | Jumlah Senar: %d%n", jumlahSenar);
    }

    @Override
    public void tampilkanKarakteristik() {
        System.out.println("Karakteristik: Biola menghasilkan suara saat senarnya digesek dengan bow.");
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
package com.mycompany.smartmusical;

public class Gitar extends AlatMusik implements DapatDimainkan, DapatDirawat {
    private int jumlahSenar;

    public Gitar(String nama, double harga, int tahunProduksi, int jumlahSenar) {
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
        System.out.printf("Jenis: Gitar | Jumlah Senar: %d%n", this.jumlahSenar);
    }
    
    @Override
    public void tampilkanKarakteristik() {
        System.out.println("Karakteristik: Gitar menghasilkan suara dengan memetik senarnya.");
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Perawatan Gitar: Bersihkan senar dan simpan gitar di tempat kering.");
    }
    
    @Override
    public void mainkan() {
        System.out.println("Gitar dimainkan dengan cara dipetik.");
    }
}

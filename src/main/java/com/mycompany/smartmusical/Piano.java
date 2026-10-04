package com.mycompany.smartmusical;

public class Piano extends AlatMusik {
    private int jumlahTuts;

    public Piano(String nama, double harga, int tahunProduksi, int jumlahTuts) {
        super(nama, harga, tahunProduksi);
        setJumlahTuts(jumlahTuts);
    }

    public int getJumlahTuts() { 
        return this.jumlahTuts; 
    }

    public void setJumlahTuts(int jumlahTuts) {
        if (jumlahTuts <= 0) {
        System.out.println("Jumlah tuts harus lebih dari 0.");
        }
        
        this.jumlahTuts = jumlahTuts;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf("Jenis: Piano | Jumlah Tuts: %d%n", this.jumlahTuts);
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Perawatan Piano: Jaga kebersihan tuts dan hindari tempat lembap.");
    }
}
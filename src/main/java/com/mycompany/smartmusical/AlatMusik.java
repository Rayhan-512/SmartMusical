package com.mycompany.smartmusical;

public class AlatMusik {
    private String nama;
    private double harga;
    private int tahunProduksi;
    
    private static int totalAlatMusik = 0;

    public AlatMusik(String nama, double harga, int tahunProduksi) {
        setNama(nama);
        setHarga(harga);
        setTahunProduksi(tahunProduksi);
    }

    public String getNama() { 
        return this.nama; 
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama alat musik tidak boleh kosong.");
        }
        
        this.nama = nama.trim();
    }

    public double getHarga() { 
        return this.harga; 
    }

    public void setHarga(double harga) {
        if (harga <= 0) {
            System.out.println("Harga harus lebih dari 0.");
        }
        
        this.harga = harga;
    }

    public int getTahunProduksi() { 
        return this.tahunProduksi; 
    }

    public void setTahunProduksi(int tahunProduksi) {
        if (tahunProduksi < 1900 || tahunProduksi > 2026) {
            System.out.println("Tahun produksi harus antara 1900 sampai 2026.");
        }
        
        this.tahunProduksi = tahunProduksi;
    }

    public static void tambahTotalAlatMusik() { 
        totalAlatMusik++; 
    }

    public static int getTotalAlatMusik() { 
        return totalAlatMusik; 
    }

    public void tampilkanInfo() {
        System.out.printf("[Alat Musik] Nama: %-18s | Harga: Rp%,.0f | Tahun: %d%n",
                this.nama, this.harga, this.tahunProduksi);
    }

    public void caraPerawatan() {
        System.out.println("Perawatan: Simpan di tempat yang bersih, kering, dan aman.");
    }
}

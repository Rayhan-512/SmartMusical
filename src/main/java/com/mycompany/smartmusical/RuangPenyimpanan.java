package com.mycompany.smartmusical;

public class RuangPenyimpanan {

    private String namaRuang;
    private int kapasitas;

    public RuangPenyimpanan(String namaRuang, int kapasitas) {
        this.namaRuang = namaRuang;
        this.kapasitas = kapasitas;
    }

    public String getNamaRuang() {
        return this.namaRuang;
    }

    public int getKapasitas() {
        return this.kapasitas;
    }

    public void setNamaRuang(String namaRuang) {
        this.namaRuang = namaRuang;
    }

    public void setKapasitas(int kapasitas) {
        if (kapasitas > 0) {
            this.kapasitas = kapasitas;
        } else {
            System.out.println("Kapasitas harus lebih dari 0.");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Nama Ruang : " + namaRuang);
        System.out.println("Kapasitas  : " + kapasitas + " alat musik");
    }
}
package com.mycompany.smartmusical;

public class Pelanggan implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String nama;

    public Pelanggan(String id, String nama) {
        setId(id);
        setNama(nama);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("ID pelanggan tidak boleh kosong.");
            return;
        }

        this.id = id.trim();
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama pelanggan tidak boleh kosong.");
            return;
        }

        this.nama = nama.trim();
    }

    public void tampilkanInfo() {
        System.out.println("ID   : " + id);
        System.out.println("Nama : " + nama);
    }
}
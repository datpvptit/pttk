package com.rs.garaMan218.model;

public class Xe218 {

    private int id;
    private String bienSo;
    private String chungLoai;
    public Xe218() {
    }

    public Xe218(int id, String bienSo, String chungLoai) {
        this.id = id;
        this.bienSo = bienSo;
        this.chungLoai = chungLoai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getChungLoai() {
        return chungLoai;
    }

    public void setChungLoai(String chungLoai) {
        this.chungLoai = chungLoai;
    }

    @Override
    public String toString() {
        return  bienSo + " " +  chungLoai ;
    }
}

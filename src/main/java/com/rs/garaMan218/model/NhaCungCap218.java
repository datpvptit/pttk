package com.rs.garaMan218.model;


public class NhaCungCap218 {

    private int id;
    private String ten;
    private String email;
    private String soDienThoai;
    private String maSoThue;
    private String diaChi;
    public NhaCungCap218(String ten, String diaChi) {
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public NhaCungCap218(int id, String ten, String email, String soDienThoai, String maSoThue) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.maSoThue = maSoThue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}

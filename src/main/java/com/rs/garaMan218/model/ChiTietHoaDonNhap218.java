package com.rs.garaMan218.model;

import java.time.LocalDateTime;

public class ChiTietHoaDonNhap218 {
    private int id;
    private String ten;
    private String donVi;
    private float donGia;
    private float soLuong;
    private float thanhTien;

    public ChiTietHoaDonNhap218(String ten, String donVi, float donGia, float soLuong, float thanhTien) {
        this.ten = ten;
        this.donVi = donVi;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
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

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float tongTien) {
        this.thanhTien = tongTien;
    }
}

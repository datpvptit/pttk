package com.rs.garaMan218.model;

import java.time.LocalDate;

public class TKNhaCungCapTheoSoLuongHangNhap218 extends NhaCungCap218 {
    private float soLanNhap;
    private float soLuong;
    private float tongTien;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    public TKNhaCungCapTheoSoLuongHangNhap218(int id,
                                              String ten,
                                              String email,
                                              String soDienThoai,
                                              String maSoThue,
                                              int soLanNhap,
                                              float tongTien,
                                              float tongSoLuong) {
        super(id, ten, email, soDienThoai,maSoThue);
        this.soLanNhap = soLanNhap;
        this.tongTien = tongTien;
        this.soLuong = tongSoLuong;
    }

    public float getSoLanNhap() {
        return soLanNhap;
    }

    public void setSoLanNhap(float soLanNhap) {
        this.soLanNhap = soLanNhap;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}

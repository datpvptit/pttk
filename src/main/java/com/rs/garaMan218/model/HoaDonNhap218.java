package com.rs.garaMan218.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class HoaDonNhap218 {
    private int id;
    private LocalDateTime thoiGian;
    private float tongTien;
    private float soLuong;
    private NhanVien218 nhanVien218;
    private NhaCungCap218 nhaCungCap218;
    private List<ChiTietHoaDonNhap218> chiTietHoaDonNhap218List;
    private String ghiChu;

    public HoaDonNhap218(int id, LocalDateTime thoiGian, float tongTien, float soLuong, NhanVien218 nhanVien218, NhaCungCap218 nhaCungCap218, List<ChiTietHoaDonNhap218> chiTietHoaDonNhap218List) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.tongTien = tongTien;
        this.soLuong = soLuong;
        this.nhanVien218 = nhanVien218;
        this.nhaCungCap218 = nhaCungCap218;
        this.chiTietHoaDonNhap218List = chiTietHoaDonNhap218List;
    }

    public HoaDonNhap218(int id, LocalDateTime thoiGian, float tongTien, float soLuong, NhanVien218 nhanVien218) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.tongTien = tongTien;
        this.soLuong = soLuong;
        this.nhanVien218 = nhanVien218;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDateTime thoiGian) {
        this.thoiGian = thoiGian;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public float getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(float soLuong) {
        this.soLuong = soLuong;
    }

    public NhanVien218 getNhanVien218() {
        return nhanVien218;
    }

    public void setNhanVien218(NhanVien218 nhanVien218) {
        this.nhanVien218 = nhanVien218;
    }

    public NhaCungCap218 getNhaCungCap218() {
        return nhaCungCap218;
    }

    public void setNhaCungCap218(NhaCungCap218 nhaCungCap218) {
        this.nhaCungCap218 = nhaCungCap218;
    }

    public List<ChiTietHoaDonNhap218> getChiTietHoaDonNhap218List() {
        return chiTietHoaDonNhap218List;
    }

    public void setChiTietHoaDonNhap218List(List<ChiTietHoaDonNhap218> chiTietHoaDonNhap218List) {
        this.chiTietHoaDonNhap218List = chiTietHoaDonNhap218List;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}

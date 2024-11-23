package com.rs.garaMan218.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class LichHen218 {
    private int id;
    private KhachHang218 khachHang218;
    private LocalDate ngayDat;
    private LocalTime gioDat;
    private Xe218 xe218;
    private String loaiDichVu;
    private String trangThai;

    public LichHen218(KhachHang218 khachHang218, LocalDate ngayDat, LocalTime gioDat, Xe218 xe218, String loaiDichVu) {
        this.khachHang218 = khachHang218;
        this.ngayDat = ngayDat;
        this.gioDat = gioDat;
        this.xe218 = xe218;
        this.loaiDichVu = loaiDichVu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KhachHang218 getKhachHang218() {
        return khachHang218;
    }

    public void setKhachHang218(KhachHang218 khachHang218) {
        this.khachHang218 = khachHang218;
    }

    public LocalDate getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDate ngayDat) {
        this.ngayDat = ngayDat;
    }

    public LocalTime getGioDat() {
        return gioDat;
    }

    public void setGioDat(LocalTime gioDat) {
        this.gioDat = gioDat;
    }

    public Xe218 getXe218() {
        return xe218;
    }

    public void setXe218(Xe218 xe218) {
        this.xe218 = xe218;
    }

    public String getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(String loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

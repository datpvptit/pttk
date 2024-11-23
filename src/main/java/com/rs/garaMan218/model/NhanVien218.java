package com.rs.garaMan218.model;

import java.util.Date;

public class NhanVien218 extends ThanhVien218 {
    private String viTri;
    private String maNhanVien;
    public NhanVien218() {
        super();
    }

    public NhanVien218(String ten, String maNhanVien) {
        super(ten);
        this.maNhanVien = maNhanVien;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
}

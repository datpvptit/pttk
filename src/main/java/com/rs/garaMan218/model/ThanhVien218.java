package com.rs.garaMan218.model;

import java.util.Date;

public class ThanhVien218 {

    private int id;
    private String username;
    private String password;
    private String hoTen;
    private Date ngaySinh;
    private String soDienThoai;
    private String email;
    private String vaiTro;
    private String diaChi;

    public ThanhVien218() {
    }

    public ThanhVien218(int id, String vaiTro){
        this.id = id;
        this.vaiTro = vaiTro;
    }

    public ThanhVien218(String hoTen) {
        this.hoTen = hoTen;
    }

    public ThanhVien218(int id, String hoTen, String soDienThoai, String email) {
        this.id = id;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}

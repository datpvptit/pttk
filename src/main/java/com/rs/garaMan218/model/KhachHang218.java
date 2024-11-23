package com.rs.garaMan218.model;

import java.util.List;

public class KhachHang218 extends ThanhVien218 {
    private String hang;
    private List<Xe218> xe218List;

    public KhachHang218() {
        super();
    }

    public KhachHang218(int id, String hoTen, String soDienThoai, String email, List<Xe218> xe218List) {
        super(id, hoTen, soDienThoai, email);
        this.xe218List = xe218List;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public List<Xe218> getXe218List() {
        return xe218List;
    }

    public void setXe218List(List<Xe218> xe218List) {
        this.xe218List = xe218List;
    }
}

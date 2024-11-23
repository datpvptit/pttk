package com.rs.garaMan218.dao;

import com.rs.garaMan218.model.LichHen218;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class LichHen218DAO extends DAO{

    public LichHen218DAO(){
        super();
    }

    public boolean luuLichHen(LichHen218 lichHen) throws SQLException {

        boolean kq = false;

        String url = "INSERT INTO  tbllichhen218(tblkhachhang218id, tblxe218id, loaiDichVu, ngayDat, gioDat) " +
                "VALUES (?, ?, ?, ?, ?)";

        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(url);
            ps.setInt(1, lichHen.getKhachHang218().getId());
            ps.setInt(2, lichHen.getXe218().getId());
            ps.setString(3, lichHen.getLoaiDichVu());
            ps.setDate(4, Date.valueOf(lichHen.getNgayDat()));
            ps.setTime(5, Time.valueOf(lichHen.getGioDat()));
            ps.executeUpdate();

            kq = true;

            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }

        return kq;
    }
}

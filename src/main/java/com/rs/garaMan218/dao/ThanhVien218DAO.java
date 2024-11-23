package com.rs.garaMan218.dao;

import com.rs.garaMan218.model.LichHen218;
import com.rs.garaMan218.model.ThanhVien218;

import java.sql.*;

public class ThanhVien218DAO extends DAO{

    public ThanhVien218DAO(){
        super();
    }

    public ThanhVien218 kiemTraDangNhap(String username, String password) throws SQLException {


        String url = "SELECT tv.id, tv.vaiTro FROM tblthanhvien218 as tv WHERE tv.username = ? AND tv.password = ?";

        try (PreparedStatement stmt = con.prepareStatement(url)) {
            stmt.setString(1, username);  // Set the username parameter
            stmt.setString(2, password);  // Set the password parameter

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ThanhVien218 thanhVien218 = new ThanhVien218(
                        rs.getInt("id"),
                        rs.getString("vaiTro")
                );

                return thanhVien218;
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL exceptions
        }

        return null;
    }
}

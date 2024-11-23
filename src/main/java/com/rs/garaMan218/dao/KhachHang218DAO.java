package com.rs.garaMan218.dao;

import com.rs.garaMan218.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHang218DAO extends DAO{

    public KhachHang218DAO(){
        super();
    }

    public KhachHang218 layThongTinKhachHang(int idKhachHang) throws SQLException {

        String khSql = """
                    SELECT 
                        tv.id,
                        tv.hoTen,
                        tv.soDienThoai,
                        tv.email
                    FROM 
                        tblthanhvien218 AS tv
                    INNER JOIN 
                        tblkhachhang218 AS kh
                        ON kh.tblthanhvien218id = tv.id
                    WHERE 
                        kh.tblthanhvien218id = ?
                """;


        String xeSql = """
                    SELECT 
                        xe.id,
                        xe.bienSo,
                        xe.chungLoai
                    FROM 
                        tblxe218 AS xe
                    INNER JOIN 
                        tblkhachhang218 AS kh
                        ON kh.tblthanhvien218id = xe.tblkhachhang218id
                    WHERE 
                        kh.tblthanhvien218id = ?
                """;


        PreparedStatement preparedStatementKH = con.prepareStatement(khSql);
        preparedStatementKH.setInt(1, idKhachHang);

        ResultSet resultSetKH = preparedStatementKH.executeQuery();

        PreparedStatement preparedStatementXe = con.prepareStatement(xeSql);
        preparedStatementXe.setInt(1, idKhachHang);

        ResultSet resultSetXe = preparedStatementXe.executeQuery();

        if (resultSetKH.next()) {

            List<Xe218> xe218List = new ArrayList<>();

            while (resultSetXe.next()) {
                Xe218 xe218 = new Xe218(
                        resultSetXe.getInt("id"),
                        resultSetXe.getString("bienSo"),
                        resultSetXe.getString("chungLoai")
                );
                xe218List.add(xe218);
            }

            KhachHang218 khachHang218 = new KhachHang218(
                    resultSetKH.getInt("id"),
                    resultSetKH.getString("hoTen"),
                    resultSetKH.getString("soDienThoai"),
                    resultSetKH.getString("email"),
                    xe218List
            );

            return khachHang218;
        }
        return null;
    }
}

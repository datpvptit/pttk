package com.rs.garaMan218.dao;

import com.rs.garaMan218.model.TKNhaCungCapTheoSoLuongHangNhap218;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeNhaCungCap218DAO extends DAO{

    public ThongKeNhaCungCap218DAO(){
        super();
    }

    public List<TKNhaCungCapTheoSoLuongHangNhap218> getTKNCCTheoLuongHangNhapByTime(Date batDau, Date ketThuc) throws SQLException, IOException{
        String sql = """
                SELECT 
                    ncc.id, 
                    ncc.ten, 
                    ncc.email, 
                    ncc.soDienThoai, 
                    ncc.maSoThue, 
                    COUNT(DISTINCT hdn.id) AS soLanNhap,
                    (SELECT SUM(h.tongTien)
                         FROM tblhoadonnhap218 h
                         WHERE h.tblnhacungcap218id = ncc.id) AS tong,
                    SUM(cthd.soLuong) AS soLuong
                FROM 
                    tblnhacungcap218 AS ncc
                INNER JOIN 
                    tblhoadonnhap218 AS hdn 
                    ON ncc.id = hdn.tblnhacungcap218id
                INNER JOIN
                    tblchitiethoadonnhap218 AS cthd
                    ON hdn.id = cthd.tblhoadonnhap218id
                WHERE 
                    DATE(hdn.thoiGian) >= ?
                    AND DATE(hdn.thoiGian) <= ?
                GROUP BY 
                    ncc.id, ncc.ten
                ORDER BY 
                    tong ASC;
                """;

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setDate(1, new java.sql.Date(batDau.getTime()));
        preparedStatement.setDate(2, new java.sql.Date(ketThuc.getTime()));

        ResultSet resultSet = preparedStatement.executeQuery();

        List<TKNhaCungCapTheoSoLuongHangNhap218> save = new ArrayList<>();
        while (resultSet.next()) {
            TKNhaCungCapTheoSoLuongHangNhap218 item = new TKNhaCungCapTheoSoLuongHangNhap218(
                    resultSet.getInt("id"),
                    resultSet.getString("ten"),
                    resultSet.getString("email"),
                    resultSet.getString("soDienThoai"),
                    resultSet.getString("maSoThue"),
                    resultSet.getInt("soLanNhap"),
                    resultSet.getFloat("tong"),
                    resultSet.getFloat("soLuong"));
            save.add(item);
        }

        return save;
    }
}

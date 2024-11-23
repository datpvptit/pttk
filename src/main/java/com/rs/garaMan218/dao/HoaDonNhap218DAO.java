package com.rs.garaMan218.dao;

import com.rs.garaMan218.model.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonNhap218DAO extends DAO{

    public HoaDonNhap218DAO(){
        super();
    }

    public List<HoaDonNhap218> layDanhSachHoaDonNhapNhaCungCap(Date batDau, Date ketThuc, int idNhaCungCap) throws SQLException, IOException{
        String sql = """
                SELECT 
                    hdn.id, 
                    hdn.thoiGian, 
                    hdn.tongTien,
                    sum(cthd.soLuong) as soLuong,
                    tv.hoTen,
                    nv.maNhanVien
                FROM 
                    tblhoadonnhap218 AS hdn
                INNER JOIN 
                    tblchitiethoadonnhap218 AS cthd
                    ON hdn.id = cthd.tblhoadonnhap218id
                INNER JOIN 
                    tblnhanvien218 AS nv
                    ON hdn.tblnhanvien218id = nv.tblthanhvien218id
                INNER JOIN 
                    tblthanhvien218 AS tv
                    ON nv.tblthanhvien218id = tv.id
                INNER JOIN 
                    tblnhacungcap218 AS ncc
                    ON hdn.tblnhacungcap218id = ncc.id
                WHERE 
                    DATE(hdn.thoiGian) >= ?
                    AND DATE(hdn.thoiGian) <= ?
                    AND ncc.id = ?
                GROUP BY 
                    hdn.id
                ORDER BY 
                    hdn.thoiGian ASC;
                """;

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setDate(1, new Date(batDau.getTime()));
        preparedStatement.setDate(2, new Date(ketThuc.getTime()));
        preparedStatement.setInt(3, idNhaCungCap);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<HoaDonNhap218> hoaDonNhap218List = new ArrayList<>();
        while (resultSet.next()) {

            NhanVien218 nhanVien218 = new NhanVien218(
                    resultSet.getString("hoTen"),
                    resultSet.getString("maNhanVien"));

            HoaDonNhap218 item = new HoaDonNhap218(
                    resultSet.getInt("id"),
                    resultSet.getTimestamp("thoiGian").toLocalDateTime(),
                    resultSet.getFloat("tongTien"),
                    resultSet.getFloat("soLuong"),
                    nhanVien218
                    );
            hoaDonNhap218List.add(item);
        }

        return hoaDonNhap218List;
    }

    public HoaDonNhap218 layChiTietHoaDonNhap(int idHoaDon) throws SQLException, IOException {
        String sql = """
                SELECT 
                    hdn.id, 
                    hdn.thoiGian, 
                    hdn.tongTien,
                    sum(cthd.soLuong) as soLuong,
                    tv.hoTen,
                    nv.maNhanVien,
                    ncc.ten,
                    ncc.diaChi
                FROM 
                    tblhoadonnhap218 AS hdn
                INNER JOIN 
                    tblchitiethoadonnhap218 AS cthd
                    ON hdn.id = cthd.tblhoadonnhap218id
                INNER JOIN 
                    tblnhanvien218 AS nv
                    ON hdn.tblnhanvien218id = nv.tblthanhvien218id
                INNER JOIN
                    tblthanhvien218 AS tv
                    ON nv.tblthanhvien218id = tv.id
                INNER JOIN 
                    tblnhacungcap218 AS ncc
                    ON hdn.tblnhacungcap218id = ncc.id
                WHERE 
                    hdn.id = ?
                GROUP BY 
                    hdn.id;
                """;

        // Sử dụng PreparedStatement cho truy vấn lấy thông tin hóa đơn nhập
        PreparedStatement preparedStatementHD = con.prepareStatement(sql);
        preparedStatementHD.setInt(1, idHoaDon);

        ResultSet resultSetHD = preparedStatementHD.executeQuery();

        String chiTietSql = """
                    SELECT 
                        pt.ten as tenPhuTung,
                        pt.donVi as donVi,
                        cthd.donGia,
                        cthd.soLuong,
                        (cthd.soLuong * cthd.donGia) AS thanhTien
                    FROM 
                        tblchitiethoadonnhap218 AS cthd
                    INNER JOIN 
                        tblhoadonnhap218 AS hdn
                        ON cthd.tblhoadonnhap218id = hdn.id
                    INNER JOIN 
                        tblphutung218 AS pt
                        ON cthd.tblphutung218id = pt.id
                    WHERE 
                        cthd.tblhoadonnhap218id = ?
                    ORDER BY 
                        pt.ten
                """;

        // Sử dụng PreparedStatement cho truy vấn chi tiết hóa đơn
        PreparedStatement preparedStatementCTHD = con.prepareStatement(chiTietSql);
        preparedStatementCTHD.setInt(1, idHoaDon);

        ResultSet resultSetCTHD = preparedStatementCTHD.executeQuery();

        if (resultSetHD.next()) {
            // Lấy thông tin địa chỉ từ resultSetHD
            NhaCungCap218 nhaCungCap218 = new NhaCungCap218(
                    resultSetHD.getString("ten"),
                    resultSetHD.getString("diaChi")
            );

            NhanVien218 nhanVien218 = new NhanVien218(
                    resultSetHD.getString("hoTen"),
                    resultSetHD.getString("maNhanVien")
            );

            // Lấy danh sách chi tiết hóa đơn nhập
            List<ChiTietHoaDonNhap218> chiTietHoaDonNhap218List = new ArrayList<>();

            while (resultSetCTHD.next()) {
                ChiTietHoaDonNhap218 chiTietHoaDonNhap218 = new ChiTietHoaDonNhap218(
                        resultSetCTHD.getString("tenPhuTung"),
                        resultSetCTHD.getString("donVi"),
                        resultSetCTHD.getFloat("donGia"),
                        resultSetCTHD.getFloat("soLuong"),
                        resultSetCTHD.getFloat("thanhTien")
                );

                chiTietHoaDonNhap218List.add(chiTietHoaDonNhap218);
            }

            HoaDonNhap218 hoaDonNhap218 = new HoaDonNhap218(
                    resultSetHD.getInt("id"),
                    resultSetHD.getTimestamp("thoiGian").toLocalDateTime(),
                    resultSetHD.getFloat("tongTien"),
                    resultSetHD.getFloat("soLuong"),
                    nhanVien218,
                    nhaCungCap218,
                    chiTietHoaDonNhap218List
            );
            return hoaDonNhap218;
        }

        return null;
    }

}

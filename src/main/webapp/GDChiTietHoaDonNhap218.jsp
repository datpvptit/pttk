<%@ page import="java.util.List" %>
<%@ page import="com.rs.garaMan218.dao.*, com.rs.garaMan218.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết hóa đơn nhập</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/CTHDN.css">
</head>
<body>
<header>
    <div class="header-container">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/image/logo.png" alt="Logo"/>
            <p>PTIT GARA</p>
        </div>
        <div class="title">
            <h1>Xem chi tiết một hóa đơn nhập</h1>
        </div>
        <div class="navigation">
            <button onclick="history.back()">Quay lại</button>
        </div>
    </div>
</header>

<div class="container">
    <header>
        <h2>Chi tiết hóa đơn nhập</h2>
    </header>

    <%
        // Lấy các tham số từ request
        int id = Integer.parseInt(request.getParameter("id"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        try {
            // Lấy thông tin nhà cung cấp
            HoaDonNhap218 hoaDonNhap218 = new HoaDonNhap218DAO().layChiTietHoaDonNhap(id);
    %>

    <!-- Form Nhập Ngày và Thông tin Nhà cung cấp -->
    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
        <tr>
            <th colspan="5">Thông tin hóa đơn nhập</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td colspan="2" ><b>ID Hóa đơn</b></td>
            <td colspan="3" ><%= hoaDonNhap218.getId() %></td>
        </tr>
        <tr>
            <td colspan="2"><b>Thời gian nhập:</b></td>
            <td colspan="3"><%= hoaDonNhap218.getThoiGian().format(formatter) %></td>
        </tr>
        <tr>
            <td colspan="2"><b>Nhà cung cấp:</b></td>
            <td colspan="3"><%= hoaDonNhap218.getNhaCungCap218().getTen() %></td>
        </tr>
        <tr>
            <td colspan="2"><b>Địa chỉ:</b></td>
            <td colspan="3"><%= hoaDonNhap218.getNhaCungCap218().getDiaChi() %></td>
        </tr>
        <tr>
            <td colspan="2"><b>Nhân viên nhập:</b></td>
            <td colspan="3"><%= hoaDonNhap218.getNhanVien218().getHoTen() %></td>
        </tr>
        <tr>
            <td colspan="2"><b>Mã nhân viên:</b></td>
            <td colspan="3"><%= hoaDonNhap218.getNhanVien218().getMaNhanVien() %></td>
        </tr>
        </tbody>
        <thead>
        <tr>
            <th colspan="5">Danh sách phụ tùng</th>
        </tr>
        <tr>
            <td><b>Tên phụ tùng</b></td>
            <td><b>Đơn vị</b></td>
            <td><b>Đơn giá</b></td>
            <td><b>Số lượng</b></td>
            <td><b>Thành tiền</b></td>
        </tr>
        </thead>
        <%
            java.text.NumberFormat currencyFormatter = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("vi", "VN"));
            for(ChiTietHoaDonNhap218 chiTietHoaDonNhap218 : hoaDonNhap218.getChiTietHoaDonNhap218List()){%>
            <tr>
                <td><%= chiTietHoaDonNhap218.getTen()%></td>
                <td><%= chiTietHoaDonNhap218.getDonVi()%></td>
                <td><%=  currencyFormatter.format(chiTietHoaDonNhap218.getDonGia())%></td>
                <td><%= chiTietHoaDonNhap218.getSoLuong()%></td>
                <td><%= currencyFormatter.format(chiTietHoaDonNhap218.getThanhTien())%></td>
            </tr>

            <%}%>
            <tr>
                <td colspan="3"><b>Tổng</b></td>
                <td><b><%= hoaDonNhap218.getSoLuong()%></b></td>
                <td><b><%= currencyFormatter.format(hoaDonNhap218.getTongTien())%></b></td>
            </tr>
            <%} catch (SQLException e) {
                throw new RuntimeException(e);
            }
    %>
</div>

</body>
</html>

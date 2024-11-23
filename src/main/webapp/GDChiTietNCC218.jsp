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
    <title>Thống kê nhà cung cấp</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/DSLNNCC.css">
</head>
<body>
<header>
    <div class="header-container">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/image/logo.png" alt="Logo"/>
            <p>PTIT GARA</p>
        </div>
        <div class="title">
            <h1>Xem chi tiết một nhà cung cấp</h1>
        </div>
        <div class="navigation">
            <button  onclick="history.back()">Quay lại</button>
        </div>
    </div>

</header>
<div class="container">
    <header>
        <h2>Danh sách các lần nhập</h2>
    </header>

    <%
        int id = Integer.parseInt(request.getParameter("id"));
        Date batDau = Date.valueOf(request.getParameter("batDau"));
        Date ketThuc = Date.valueOf(request.getParameter("ketThuc"));

    try {
        NhaCungCap218 nhaCungCap218 = new NhaCungCap218DAO().layNhaCungCap(id); %>

    <table name = thongTinDanhSachHoaDon >
        <thead>
        </thead>
        <tbody>
            <tr>
                <td colspan="2"><b>Tên nhà cung cấp : <%=nhaCungCap218.getTen()%></b></td>
                <td colspan="2"><b>Ngày bắt đầu : <%=batDau%></b></td>
                <td colspan="2"><b>Ngày kết thúc : <%=ketThuc%></b></td>
            </tr>
        </tbody>
        <thead>
        <tr>
            <th>STT</th>
            <th>Thời gian nhập</th>
            <th>Số lượng nhập</th>
            <th>Tổng giá trị hóa đơn</th>
            <th colspan="2">Nhân viên nhập</th>
        </tr>
        </thead>
    <%

        java.text.NumberFormat currencyFormatter = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("vi", "VN"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            List<HoaDonNhap218> hoaDonNhap218List = new HoaDonNhap218DAO().layDanhSachHoaDonNhapNhaCungCap(batDau, ketThuc, id);
            int index = 1;
            for(HoaDonNhap218 hoaDonNhap218 : hoaDonNhap218List){%>
            <tr>
                <td><%= index++ %></td>
                <td><%= hoaDonNhap218.getThoiGian().format(formatter) %></td>
                <td><%= hoaDonNhap218.getSoLuong() %></td>
                <td><%= currencyFormatter.format(hoaDonNhap218.getTongTien()) %></td>
                <td><%= hoaDonNhap218.getNhanVien218().getHoTen()%></td>
                <td><button class="btn-td" onclick="window.location.href=`/quản-lý/xem-báo-cáo/chi-tiết-hóa-đơn-nhập?id=<%= hoaDonNhap218.getId() %>`">CHI TIẾT</button></td>
            </tr>

    <%
        }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    %>

</div>



</body>
</html>
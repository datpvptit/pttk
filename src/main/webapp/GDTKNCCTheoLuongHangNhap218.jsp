<%@ page import="java.util.List" %>
<%@ page import="com.rs.garaMan218.dao.*, com.rs.garaMan218.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thống kê nhà cung cấp</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/TKNCCTLHN.css">
</head>
<body>
<header>
    <div class="header-container">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/image/logo.png" alt="Logo"/>
            <p>PTIT GARA</p>
        </div>
        <div class="title">
            <h1>Thống kê nhà cung cấp theo lượng hàng nhập</h1>
        </div>
        <div class="navigation">
            <button  onclick="history.back()">Quay lại</button>
        </div>
    </div>

</header>
<div class="container">
    <!-- Header -->
    <header>
        <h1>Danh sách thống kê nhà cung cấp</h1>
    </header>

    <!-- Form Nhập Ngày -->
    <form method="POST" action="">
        <div class="form-group">
            <label for="startDate">Ngày bắt đầu:</label>
            <input
                    type="date"
                    id="startDate"
                    name="batDau"
                    value="<%= request.getParameter("batDau") != null ? request.getParameter("batDau") : "" %>"
                    required>
        </div>
        <div class="form-group">
            <label for="endDate">Ngày kết thúc:</label>
            <input
                    type="date"
                    id="endDate"
                    name="ketThuc"
                    value="<%= request.getParameter("ketThuc") != null ? request.getParameter("ketThuc") : "" %>"
                    required>
        </div>
        <button name = "thongKe"type="submit" class="btn">THỐNG KÊ</button>
    </form>
    <table name = "thongTinThongKe">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên nhà cung cấp</th>
            <th>Số điện thoại</th>
            <th>Số lần nhập</th>
            <th>Tổng số đơn vị nhập</th>
            <th colspan="2">Tổng giá trị hóa đơn</th>
        </tr>
        </thead>
    <!-- Bảng Thống Kê -->
    <%
    %>
    <%
        java.text.NumberFormat currencyFormatter = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("vi", "VN"));
    %>
    <%


    if ("POST".equalsIgnoreCase(request.getMethod())) {

        try {
            Date batDau = Date.valueOf(request.getParameter("batDau"));
            Date ketThuc = Date.valueOf(request.getParameter("ketThuc"));

            List<TKNhaCungCapTheoSoLuongHangNhap218> listThongKe = new ThongKeNhaCungCap218DAO().getTKNCCTheoLuongHangNhapByTime(batDau, ketThuc);

            if (listThongKe != null && !listThongKe.isEmpty()) {
                int index = 1;
                for (TKNhaCungCapTheoSoLuongHangNhap218 supplier : listThongKe) {
        %>

        <tr>

            <td><%= index++ %></td>
            <td><%= supplier.getTen() %></td>
            <td><%= supplier.getSoDienThoai() %></td>
            <td><%= supplier.getSoLanNhap() %></td>
            <td><%= supplier.getSoLuong() %></td>
            <td><%= currencyFormatter.format(supplier.getTongTien()) %></td>
            <td><button class="btn-td" onclick="window.location.href=`/quản-lý/xem-báo-cáo/chi-tiết-nhà-cung-cấp?id=<%= supplier.getId() %>&batDau=<%= batDau %>&ketThuc=<%= ketThuc %>`">CHI TIẾT</button></td>
        </tr>
            <% }
            } else { %>
        <tr>
            <td colspan="6" style="text-align: center;">Không có dữ liệu thống kê trong khoảng thời gian đã chọn.</td>
        </tr>
            <% }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi truy vấn dữ liệu thống kê", e);
        }
    }%>
</div>



</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="com.rs.garaMan218.dao.*, com.rs.garaMan218.model.*" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Giao diện đặt lịch hẹn</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/GDDatLichHen.css" />
    <script src="${pageContext.request.contextPath}/js/GDDatLichHen218.js"></script>
</head>
<body>
<header>
    <div class="header-container">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/image/logo.png" alt="Logo" />
            <p>PTIT GARA</p>
        </div>
        <div class="title">
            <h1>Đặt lịch hẹn trực tuyến</h1>
        </div>
        <div class="navigation">
            <button  onclick="history.back()">Quay lại</button>
        </div>
    </div>
</header>
<div class="container">
    <h2>Thông tin lịch hẹn</h2>

    <%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ThanhVien218 thanhVien218 = (ThanhVien218) session.getAttribute("thanhVien218");
    if(thanhVien218 != null){
        KhachHang218 khachHang218 = new KhachHang218DAO().layThongTinKhachHang(thanhVien218.getId());
        List<Xe218> xe218List = khachHang218.getXe218List();

        session.setAttribute("khachHang218", khachHang218);
        session.setAttribute("xe218List", xe218List);
    %>

        <!-- Form Đặt Lịch Hẹn -->
        <form name="thongTinLichHenTrucTuyen" action="" method="post">
            <div class="form-group">
                <label for="name">Họ và tên:</label>
                <input type="text" id="name" name="tenKhachHang" value="<%= khachHang218.getHoTen()%>" readonly>
            </div>
            <div class="form-group">
                <label for="phone">Số điện thoại:</label>
                <input type="text" id="phone" name="soDienThoai" value="<%= khachHang218.getSoDienThoai()%>" readonly>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<%= khachHang218.getEmail()%>" readonly>
            </div>
            <div class="form-group">
                <label for="date">Chọn ngày:</label>
                <input type="date" id="date" name="ngayDat" required>
            </div>
            <div class="form-group">
                <label for="time">Chọn giờ:</label>
                <input type="time" id="time" name="gioDat" required>
            </div>
            <div class="form-group">
                <label for="vehicle">Chọn xe của bạn:</label>
                <select id="vehicle" name="xe" required>
                    <option value="">-- Chọn xe --</option>
                    <%
                        // Giả sử bạn có danh sách xe trong biến `danhSachXe`
                        List<Xe218> danhSachXe = khachHang218.getXe218List(); // Lấy danh sách xe từ đối tượng khách hàng
                        for (Xe218 xe : danhSachXe) {
                    %>
                    <option value="<%= xe.getId() %>"><%= xe.toString() %></option>
                    <% } %>
                </select>
            </div>
            <div class="form-group">
                <label for="typeService">Loại dịch vụ</label>
                <select id="vehicle" name="loaiDichVu" required>
                    <option value="Sửa chữa">Sửa chữa</option>
                    <option value="Bảo dưởng">Bảo dưởng</option>
                    <option value="Thay thế phụ tùng">Thay thế phụ tùng</option>
                </select>
            </div>
            <button type="submit">Đăng ký</button>
        </form>

    <%}
    %>
</div>
<div class="popup" id="popup">
    <img src="${pageContext.request.contextPath}/image/404-tick.png">
    <h2>Thành công!</h2>
    <p>    Thông tin lịch hẹn đã được ghi nhận. </p>
    <p>PTIT GARA rất hân hạnh được phục vụ quý khách !</p>
    <button type="button" onclick="closePopup()">OK</button>
</div>

<!-- Xử lý thông báo thành công sau khi gửi form -->
<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        KhachHang218 khachHang218 = (KhachHang218)session.getAttribute("khachHang218");
        List<Xe218> xe218List = khachHang218.getXe218List();

        int idXe = Integer.parseInt(request.getParameter("xe"));

        Xe218 xe218 = xe218List.stream()
                .filter(xe -> xe.getId() == idXe)
                .findFirst()
                .orElse(null);

        LichHen218 lichHen = new LichHen218(
                (KhachHang218) session.getAttribute("khachHang218"),
                LocalDate.parse(request.getParameter("ngayDat")),
                LocalTime.parse(request.getParameter("gioDat")),
                xe218,
                request.getParameter("loaiDichVu"));

        if((new LichHen218DAO()).luuLichHen(lichHen)){
%>
            <script type="text/javascript">
                openPopup();
            </script>
<%

        }
    }
%>

</body>
</html>
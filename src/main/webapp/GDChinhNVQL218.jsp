<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giao diện chính nhân viên quản lý</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/GDChinhKhachHang.css"/>
</head>
<body>
<header>
    <div class="header-container">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/image/logo.png" alt="Logo"/>
            <p>PTIT GARA</p>
        </div>
        <div class="title">
            <h1>Trang chủ nhân viên quản lý</h1>
        </div>
    </div>
</header>
<div class="container">
    <h2>Lựa chọn chức năng</h2>
    <div class="button-container">
        <button name="xemBaoCao" onclick="window.location.href='/quản-lý/xem-báo-cáo'">Xem báo cáo</button>
    </div>
</div>

</body>
</html>
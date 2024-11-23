<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giao diện chính khách hàng</title>

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
            <h1>Chào mừng khách hàng đến với PTIT GARA</h1>
        </div>
    </div>
</header>
<div class="container">
  <h2>Chúng tôi có thể giúp bạn ?</h2>
  <div class="button-container">
    <button name="datLichHenTrucTuyen" onclick="window.location.href='/khách-hàng/đặt-lịch-hẹn-trực-tuyến'">Đặt lịch hẹn</button>
  </div>
</div>

</body>
</html>

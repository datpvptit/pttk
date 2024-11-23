<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Giao diện xem báo cáo</title>

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
      <h1>Xem các loại báo cáo</h1>
    </div>
    <div class="navigation">
      <button  onclick="history.back()">Quay lại</button>
    </div>
  </div>
</header>
<div class="container">
  <h2>Lựa chọn loại báo cáo</h2>
  <div class="button-container">
    <button name="xemTKNCCTheoLuongHangNhap" onclick="window.location.href='/quản-lý/xem-báo-cáo/thống-kê-nhà-cung-cấp'">Thống kê nhà cung cấp theo lượng hàng nhập</button>
  </div>
</div>

</body>
</html>
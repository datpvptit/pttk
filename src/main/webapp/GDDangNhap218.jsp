<%@ page import="com.rs.garaMan218.dao.ThanhVien218DAO" %>
<%@ page import="com.rs.garaMan218.model.ThanhVien218" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.UnsupportedEncodingException" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập hệ thống</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/GDDangNhap.css"/>
</head>
<body>
<header>
    <div class="header-container">
        <div class="logo">
            <img src="${pageContext.request.contextPath}/image/logo.png" alt="Logo"/>
            <p>PTIT GARA</p>
        </div>
        <div class="title">
            <h1>Đăng nhập hệ thống</h1>
        </div>
    </div>
</header>

<div class="container">
    <h2>Đăng nhập vào hệ thống</h2>
    <form action="" method="POST" class="login-form">
        <div class="form-group">
            <label for="username">Tên đăng nhập:</label>
            <input type="text" id="username" name="username" required placeholder="Nhập tên đăng nhập">
        </div>
        <div class="form-group">
            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required placeholder="Nhập mật khẩu">
        </div>

        <%
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                try {
                    ThanhVien218 thanhVien218 = new ThanhVien218DAO().kiemTraDangNhap(
                            request.getParameter("username"),
                            request.getParameter("password")
                    );

                    if (thanhVien218 == null) {
        %>
        <!-- Display error message if login fails -->
        <div class="form-group" style="color: red;">
            <label >Thông tin tài khoản hoặc mật khẩu không chính xác</label>
        </div>
        <%
                    } else {
                        session.setAttribute("thanhVien218", thanhVien218);
                        String redirectUrl = "";
                        if ("Nhân viên".equals(thanhVien218.getVaiTro())) {
                            redirectUrl = "quản-lý";
                        } else if ("Khách hàng".equals(thanhVien218.getVaiTro())) {
                            redirectUrl = "khách-hàng";
                        }

                        try {
                            // URL encode to handle special characters like Vietnamese letters
                            String encodedUrl = URLEncoder.encode(redirectUrl, "UTF-8");
                            response.sendRedirect(request.getContextPath() + "/" + encodedUrl);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Encoding error");
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        %>

        <div class="form-group">
            <button type="submit" class="btn">Đăng nhập</button>
        </div>
    </form>
</div>

</body>
</html>

document.getElementById("searchButton").addEventListener("click", function() {
    // Xử lý tìm kiếm ở đây
    const startDate = document.getElementById("startDate").value;
    const endDate = document.getElementById("endDate").value;

    console.log(startDate, endDate)
    window.location.href = "/thongKeTheoNgay?batDau=" + startDate + "&ketThuc=" + endDate;
});

function handleClick(){
    window.location.href = "GDDangNhap218.jsp"
}
document.getElementById("searchButton").addEventListener("click", function() {
    // Xử lý tìm kiếm ở đây
    const startDate = document.getElementById("startDate").value;
    const endDate = document.getElementById("endDate").value;
    console.log("Bắt đầu:", startDate, "Kết thúc:", endDate);
});

function handleClick(){
    window.location.href = "GDChinhNVQL218.jsp"
}

function handleClickChiTiet(id, batDau, ketThuc){
    window.location.href = "/thongKeChiTietNhaCungCap094?id=" + id + "&batDau=" + batDau + "&ketThuc=" + ketThuc;
}

var backButton = document.getElementById("backButton")
backButton.addEventListener('click', () => {
    window.location.href = "/dsMonAn"
});

function handleClick(index, name) {

    window.location.href = "/chiTietMonAn?id=" + index + "&trangThai=1&" + "tenMonAn=" + name;
}

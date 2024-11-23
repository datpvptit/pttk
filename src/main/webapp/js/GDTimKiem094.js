// // Mảng mẫu dữ liệu món ăn
// const dishes = [
//     { id: 1, name: 'Phở Bò', description: 'Phở Bò Hà Nội', price: 50000 },
//     { id: 2, name: 'Bún Chả', description: 'Bún Chả Hà Nội', price: 45000 },
//     { id: 3, name: 'Bánh Mì', description: 'Bánh Mì Thịt Nướng', price: 25000 },
//     { id: 4, name: 'Cơm Sườn', description: 'Cơm Sườn Nướng', price: 35000 }
// ];
//
// const searchInput = document.getElementById('searchInput');
// const searchButton = document.getElementById('searchButton');
// const backButton = document.getElementById('backButton');
// const tableBody = document.getElementById('tableBody');
//
// function renderDishes(data) {
//     tableBody.innerHTML = '';
//     data.forEach((dish, index) => {
//         const row = document.createElement('tr');
//         row.innerHTML = `
//           <td>${index + 1}</td>
//           <td>${dish.name}</td>
//           <td>${dish.description}</td>
//           <td>${dish.price.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}</td>
//         `;
//         tableBody.appendChild(row);
//     });
// }
//
// searchButton.addEventListener('click', () => {
//     const searchTerm = searchInput.value.toLowerCase();
//     const filteredDishes = dishes.filter(dish =>
//         dish.name.toLowerCase().includes(searchTerm)
//     );
//     renderDishes(filteredDishes);
// });
//
// // Hiển thị danh sách món ăn ban đầu
// renderDishes(dishes);

const button = document.getElementById("searchButton")

button.addEventListener("click", ()=>{
    var inputValue = document.getElementById("searchInput").value;
    console.log(inputValue)
    window.location.href = "/timMonAn?tenMonAn=" + inputValue;

})

function handleClick(index) {
    window.location.href = "/chiTietMonAn?id=" + index + "&trangThai=0";
}
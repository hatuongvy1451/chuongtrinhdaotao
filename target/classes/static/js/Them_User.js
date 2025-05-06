/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


function addUser(event){
    event.preventDefault();
    
    const userData ={
        tenDangNhap: document.getElementById('tenDangNhap').value,
        matKhau: document.getElementById('matKhau').value,
        hoTen: document.getElementById('hoTenTK').value,
        email: document.getElementById('email').value,
        vaiTro: document.getElementById('vaiTro').value,
        trangThai: 1
    };
    
    fetch("/nguoidung/them", {
        method: "POST",
        headers:{
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(userData)
    })
    .then(response=>{
        if(!response.ok){
            throw new Error("Thêm mới người dùng thất bại");
        }
        return response.json();
    })
    .then(data=>{
        alert("Thêm mới người dùng thành công!");
        var myModal = new bootstrap.Modal(document.getElementById('modalThemTaiKhoan'));
        myModal.hide();
        location.reload();
    })
    .catch(error=>{
        console.error("Lỗi thêm user", error);
        alert("Lỗi thêm người dùng");
    });
    
}
document.getElementById('formThemTaiKhoan').addEventListener('submit', addUser);
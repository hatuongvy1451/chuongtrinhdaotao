/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function suaNguoiDung(id){
    fetch(`/nguoidung/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy người dùng!");
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            document.getElementById("suaIDNguoiDung").value = data.id;
            document.getElementById("suaTenDN").value = data.tenDangNhap;
            document.getElementById("suaHoTen").value = data.hoTen;
            document.getElementById("suaEmail").value = data.email;
            document.getElementById("suaMatKhau").value = data.matKhau;
            if(data.vaiTro === 1 || data.vaiTro === 0){
                document.getElementById("suaVaiTro").value = data.vaiTro;
            }
            if(data.trangThai === 1 || data.trangThai === 0){
                document.getElementById("suaTrangThaiTK").value = data.trangThai;
            }
            
            var myModal = new bootstrap.Modal(document.getElementById('modalSuaTaiKhoan'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu người dùng:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatNguoiDung(event){
    event.preventDefault();
    
    const id = document.getElementById("suaIDNguoiDung").value;
    const tenDangNhap = document.getElementById("suaTenDN").value;
    const hoTen = document.getElementById("suaHoTen").value;
    const email = document.getElementById("suaEmail").value;
    const matKhau = document.getElementById("suaMatKhau").value;
    const vaiTro = document.getElementById("suaVaiTro").value;
    const trangThai = document.getElementById("suaTrangThaiTK").value;
    
    const nguoiDungData = {
        id: id,
        tenDangNhap: tenDangNhap,
        hoTen: hoTen,
        email: email,
        matKhau: matKhau,
        vaiTro: vaiTro,
        trangThai: trangThai
    };
    
    fetch(`/nguoidung/sua/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(nguoiDungData)
    })
    .then(async response => {
        if (!response.ok) {
            const errorText = await response.text(); 
            throw new Error(errorText || "Cập nhật người dùng không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cập nhật người dùng thành công!", data);
        alert("Cập nhật người dùng thành công!");
        
        var myModal = new bootstrap.Modal(document.getElementById('modalSuaTaiKhoan'));
        myModal.hide();
        
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cập nhật người dùng:", error);
        alert(error.message);
    });
}
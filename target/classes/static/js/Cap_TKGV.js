/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function capTaiKhoanGiangVien(id){
    fetch(`/giangvien/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy giảng viên!");
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("idGiangVien").value = data.id;
            document.getElementById("hoTenGV").value = data.tenGiangVien;
            document.getElementById("emailGiangVien").value = data.emailGiangVien;
         
            var myModal = new bootstrap.Modal(document.getElementById('modalCapTaiKhoan'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu giảng viên:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function luuTaiKhoanGV(event){
    event.preventDefault();
    
    const saveButton = document.querySelector('button[type="submit"]');
    saveButton.disabled = true;
    
    const id = document.getElementById("idGiangVien").value;
    const tenGiangVien = document.getElementById("hoTenGV").value;
    const emailGiangVien = document.getElementById("emailGiangVien").value;
    const tenDangNhap = document.getElementById("tenDangNhapGV").value;
    const matKhau = document.getElementById("matKhauGV").value;
    
    const tkgiangVienData = {
        tenDangNhap: tenDangNhap,
        matKhau: matKhau,
        hoTen: tenGiangVien,
        email: emailGiangVien
    };
    
    fetch(`/giangvien/captaikhoan/${id}`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(tkgiangVienData)
    })
    .then(async response => {
        if (!response.ok) {
            const errorText = await response.text(); 
            throw new Error(errorText || "Cấp tài khoản giảng viên không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cấp tài khoản giảng viên thành công!", data);
        alert("Cấp tài khoản giảng viên thành công!");
        
        // Đóng modal
        var myModal = new bootstrap.Modal(document.getElementById('modalCapTaiKhoan'));
        myModal.hide();
        
        document.getElementById("formCapTaiKhoan").reset();

        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cấp tài khoản giảng viên:", error);
        alert(error.message);
    })
    .finally(() => {
        saveButton.disabled = false;
    });
}



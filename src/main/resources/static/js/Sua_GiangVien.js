/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function suaGiangVien(id){
    fetch(`/giangvien/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy giảng viên!");
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            document.getElementById("idGV").value = data.id;
            document.getElementById("suaMaGV").value = data.maGiangVien;
            document.getElementById("suaTenGV").value = data.tenGiangVien;
            document.getElementById("suaEmailGV").value = data.emailGiangVien;
            document.getElementById("suaChuyenMon").value = data.chuyenMon;
            if(data.loaiGiangVien === 1 || data.loaiGiangVien === 0){
                document.getElementById("suaLoaiGV").value = data.loaiGiangVien;
            }
            if(data.trangThai === 1 || data.trangThai === 0){
                document.getElementById("suaTrangThaiGV").value = data.trangThai;
            }
            
            var myModal = new bootstrap.Modal(document.getElementById('modalSuaGV'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu giảng viên:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatGiangVien(event){
    event.preventDefault();
    
    const id = document.getElementById("idGV").value;
    const maGiangVien = document.getElementById("suaMaGV").value;
    const tenGiangVien = document.getElementById("suaTenGV").value;
    const emailGiangVien = document.getElementById("suaEmailGV").value;
    const chuyenMon = document.getElementById("suaChuyenMon").value;
    const loaiGiangVien = document.getElementById("suaLoaiGV").value;
    const trangThai = document.getElementById("suaTrangThaiGV").value;
    
    const giangVienData = {
        id: id,
        maGiangVien: maGiangVien,
        tenGiangVien: tenGiangVien,
        emailGiangVien: emailGiangVien,
        chuyenMon: chuyenMon,
        loaiGiangVien: loaiGiangVien,
        trangThai: trangThai
    };
    
    fetch(`/giangvien/sua/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(giangVienData)
    })
    .then(async response => {
        if (!response.ok) {
            const errorText = await response.text(); 
            throw new Error(errorText || "Cập nhật giảng viên không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cập nhật giảng viên thành công!", data);
        alert("Cập nhật giảng viên thành công!");
        
        var myModal = new bootstrap.Modal(document.getElementById('modalSuaGV'));
        myModal.hide();
        
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cập nhật giảng viên:", error);
        alert(error.message);
    });
}
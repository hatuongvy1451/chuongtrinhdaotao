/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


function themGiangVien(event){
    event.preventDefault();
    
    const giangVienData ={
        maGiangVien: document.getElementById('maGV').value,
        tenGiangVien: document.getElementById('tenGV').value,
        emailGiangVien: document.getElementById('emailGV').value,
        chuyenMon: document.getElementById('chuyenMon').value,
        loaiGiangVien: parseInt(document.getElementById('loaiGV').value), // ép kiểu
        trangThai: 1
    };
    
    fetch("/giangvien/them", {
        method: "POST",
        headers:{
            "Content-Type": "application/json"
        },
        body: JSON.stringify(giangVienData)
        
    })
    .then(response=>{
        if(!response.ok){
           if (response.status === 409) { 
                return response.json().then(err => {
                    throw new Error(err.message || "Mã giảng viên đã tồn tại!");
                });
            } else {
                throw new Error("Thêm giảng viên thất bại!");
            }
        }
        return response.json();
    })
    .then(data=>{
        alert("Thêm giảng viên thành công!") ;
        var myModal = new bootstrap.Modal(document.getElementById("modalThemGV"));
        myModal.hide();
        location.reload();
    })
    .catch(error=>{
        console.error("Lỗi thêm giảng viên!", error);
        alert(error.message);
    });
}

document.getElementById('formThemGV').addEventListener("submit", themGiangVien);

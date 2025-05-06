/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function addDeCuongChitiet(event){
    event.preventDefault();
    
    const deCuongChiTietData = {
        hocPhan: {id: document.getElementById('themMaHocPhan').value},
        moTa: document.getElementById('themMoTa').value,
        mucTieu: document.getElementById('themMucTieu').value,
        chuongNoiDung: document.getElementById('themChuongNoiDung').value,
        phuongPhapGiangDay: document.getElementById('themPhuongPhapGiangDay').value,
        phuongPhapDanhGia: document.getElementById('themPhuongPhapDanhGia').value,
        taiLieuThamKhao: document.getElementById('themTaiLieu').value,
        trangThai: document.getElementById('themTrangThai').value
        
    };
    
    fetch("/decuongchitiet/them", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(deCuongChiTietData)
    }).then(response=>{
        if(!response.ok){
            throw new Error("Thêm mới cột điểm thất bại");
        }
        return response.json();
    }).then(data=>{
        alert("Thêm mới dề cương chi tiết thành công");
        var myModal = new bootstrap.Modal(document.getElementById("modalThemDeCuong"));
        myModal.hide();
        location.reload();
    }).catch(error=>{
        console.error("Lỗi thêm mới đề cương chi tiết", error);
        alert("Lỗi thêm mới đề cương chi tiết");
    });
    
    
}
document.getElementById('formThemDeCuong').addEventListener("submit", addDeCuongChitiet);



/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function themKhoiKienThuc(event){
    event.preventDefault();
    
    const kktData = {
        maKhoi: document.getElementById('maKhoiKT').value,
        tenKhoi: document.getElementById('tenKhoiKT').value,
        trangThai: 1 
    };
    
    
    fetch("/khoikienthuc/them", {
        method : "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(kktData)
    })
    .then(response => {
        if(!response.ok){
            throw new Error("Thêm khối kiến thức thất bại");
        }
        return response.json();
    })
    .then(data=>{
        alert("Thêm khối kiến thức thành công!");
        var myModal = new bootstrap.Modal(document.getElementById('modalAddKhoiKT'));
        myModal.hide();
        location.reload();
    })
    .catch(error=>{
        console.error("Lỗi thêm Khối Kiến Thúc", error);
        alert("Lỗi khi thêm khối kiến thức");
    });
}
document.getElementById('formThemKKT').addEventListener("submit", themKhoiKienThuc);
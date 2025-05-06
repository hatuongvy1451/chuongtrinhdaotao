/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function addCotDiem(event){
    event.preventDefault();
    
    const cotDiemData={
      idDeCuongCT: document.getElementById('deCuongChiTiet').value,
      tenCotDiem: document.getElementById('tenCotDiem').value,
      tyLePhanTram: document.getElementById('tyLe').value,
      hinhThuc: document.getElementById('hinhThuc').value
    };
    
    fetch("/cotdiem/them", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cotDiemData)
    }).then(response=>{
        if(!response.ok){
            throw new Error("Thêm mới cột điểm thất bại");
        }
        return response.json();
    }).then(data=>{
        alert("Thêm mới cột điểm thành công!");
        var myModal = new bootstrap.Modal(document.getElementById("modalAddCotDiem"));
        myModal.hide();
        location.reload();
    }).catch(error=>{
       console.error("Lỗi thêm mới cột điểm!", error) ;
       alert("Lỗi thêm mới cột điểm!");
    });
}

document.getElementById('formThemCotDiem').addEventListener("submit", addCotDiem);

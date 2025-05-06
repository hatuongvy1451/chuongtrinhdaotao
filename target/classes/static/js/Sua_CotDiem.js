/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function suaCotDiem(id){
    fetch(`/cotdiem/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy cột điểm!");
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("editIdCotDiem").value = data.id;
            document.getElementById("editDeCuongChiTiet").value = data.idDeCuongCT;
            document.getElementById("editTenCotDiem").value = data.tenCotDiem;
            document.getElementById("editTyLe").value = data.tyLePhanTram;
            document.getElementById("editHinhThuc").value = data.hinhThuc;
            
            var myModal = new bootstrap.Modal(document.getElementById('modalEditCotDiem'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu cột điểm:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatCotDiem(event){
    event.preventDefault();
    
    const id = document.getElementById("editIdCotDiem").value;
    const idDeCuongCT = document.getElementById("editDeCuongChiTiet").value;
    const tenCotDiem = document.getElementById("editTenCotDiem").value;
    const tyLePhanTram = document.getElementById("editTyLe").value;
    const hinhThuc = document.getElementById("editHinhThuc").value;
    
    const cotDiemData = {
        id: id,
        idDeCuongCT: idDeCuongCT,
        tenCotDiem: tenCotDiem,
        tyLePhanTram: tyLePhanTram,
        hinhThuc: hinhThuc
    };
    
    fetch(`/cotdiem/sua/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cotDiemData)
    })
    .then(response => {
        if(!response.ok){
            throw new Error("Cập nhật cột điểm không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cập nhật cột điểm thành công!", data);
        alert("Cập nhật cột điểm thành công!");
        
        var myModal = new bootstrap.Modal(document.getElementById('modalEditCotDiem'));
        myModal.hide();
        
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cập nhật cột điểm:", error);
        alert("Lỗi khi cập nhật cột điểm!");
    });
}

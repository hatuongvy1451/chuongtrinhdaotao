/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function suaKhoiKienThuc(id){
    fetch(`/khoikienthuc/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy khối kiến thức!");
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            document.getElementById("suaIDKhoiKienThuc").value = data.id;
            document.getElementById("editMaKhoiKT").value = data.maKhoi;
            document.getElementById("editTenKhoiKT").value = data.tenKhoi;
            if(data.trangThai === 1 || data.trangThai === 0){
                document.getElementById("editTrangThai").value = data.trangThai;
            }
            
            var myModal = new bootstrap.Modal(document.getElementById('modalEditKhoiKT'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu khối kiến thức:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatKhoiKienThuc(event){
    event.preventDefault();
    
    const id = document.getElementById("suaIDKhoiKienThuc").value;
    const maKhoi = document.getElementById("editMaKhoiKT").value;
    const tenKhoi = document.getElementById("editTenKhoiKT").value;
    const trangThai = document.getElementById("editTrangThai").value;
    
    const keHoachDayHocData = {
        id: id,
        maKhoi: maKhoi,
        tenKhoi: tenKhoi,
        trangThai: trangThai
    };
    
    fetch(`/khoikienthuc/sua/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(keHoachDayHocData)
    })
    .then(response => {
        if(!response.ok){
            throw new Error("Cập nhật khối kiến thức không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cập nhật khối kiến thức thành công!", data);
        alert("Cập nhật khối kiến thức thành công!");
        
        var myModal = new bootstrap.Modal(document.getElementById('modalEditKhoiKT'));
        myModal.hide();
        
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cập nhật khối kiến thức:", error);
        alert("Lỗi khi cập nhật khối kiến thức!");
    });
}

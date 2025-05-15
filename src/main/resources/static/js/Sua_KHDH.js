/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function suaKeHoachDayHoc(id){
    fetch(`/kehoachdayhoc/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy kế hoạch dạy học!");
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            document.getElementById("suaIDKeHoachDayHoc").value = data.id;
            document.getElementById("suaCTDT").value = `${data.ctdt.id} - ${data.ctdt.maCTDT}`;
            document.getElementById("suaHocPhanDayHoc").value = `${data.hocPhan.id} - ${data.hocPhan.tenHocPhan}`;
            document.getElementById("suaHK").value = data.hocKyThucHien;
            document.getElementById("suaNamHoc").value = data.namHoc;
            if(data.trangThai === 1 || data.trangThai === 0){
                document.getElementById("suaTrangThaiKHDH").value = data.trangThai;
            }
            
            var myModal = new bootstrap.Modal(document.getElementById('modalSuaKHDH'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu kế hoạch dạy học:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatKeHoachDayHoc(event){
    event.preventDefault();
    
    const id = document.getElementById("suaIDKeHoachDayHoc").value;
    const ctdt = document.getElementById("suaCTDT").value.split(" - ")[0];
    const hocPhanDayHoc = document.getElementById("suaHocPhanDayHoc").value.split(" - ")[0];
    const hocKyThucHien = document.getElementById("suaHK").value;
    const namHoc = document.getElementById("suaNamHoc").value;
    const trangThai = document.getElementById("suaTrangThaiKHDH").value;
    
    if (isNaN(hocKyThucHien) || hocKyThucHien < 1) {
        alert("Học kỳ thực hiện phải là số và lớn hơn hoặc bằng 1!");
        return;
    }

    const namHocRegex = /^\d{4}-\d{4}$/;
    if (!namHocRegex.test(namHoc)) {
        alert("Năm học phải có định dạng YYYY-YYYY (ví dụ: 2024-2025)!");
        return;
    }

    const [namTruoc, namSau] = namHoc.split('-').map(Number);
    if (namSau - namTruoc !== 1) {
        alert("Năm học không hợp lệ! Năm sau phải lớn hơn năm trước đúng 1.");
        return;
    }
    
    const keHoachDayHocData = {
        id: id,
        ctdt: {id: ctdt},
        hocPhan: {id: hocPhanDayHoc},
        hocKyThucHien: hocKyThucHien,
        namHoc: namHoc,
        trangThai: trangThai
    };
    
    fetch(`/kehoachdayhoc/sua/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(keHoachDayHocData)
    })
    .then(response => {
        if(!response.ok){
            throw new Error("Cập nhật kế hoạch dạy học không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cập nhật kế hoạch dạy học thành công!", data);
        alert("Cập nhật kế hoạch dạy học thành công!");
        
        var myModal = new bootstrap.Modal(document.getElementById('modalSuaKHDH'));
        myModal.hide();
        
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cập nhật kế hoạch dạy học:", error);
        alert("Lỗi khi cập nhật kế hoạch dạy học!");
    });
}

/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function suaKeHoachMoNhom(id){
    fetch(`/kehoachmonhom/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy kế hoạch mở nhóm!");
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            document.getElementById("suaIDKeHoachMoNhom").value = data.id;
            document.getElementById("suaMaNhom").value = data.maNhom;
            document.getElementById("suaHocPhanMoNhom").value = `${data.hocPhan.id} - ${data.hocPhan.tenHocPhan}`;
            document.getElementById("suaNamHoc").value = data.namHoc;
            document.getElementById("suaHocKy").value = data.hocKy;
            document.getElementById("suaSLSV").value = data.slSinhVien;
            document.getElementById("suaTGBD").value = data.thoiGianBatDau;
            document.getElementById("suaTGKT").value = data.thoiGianKetThuc;
            if(data.trangThai === 1 || data.trangThai === 0){
                document.getElementById("suaTrangThaiMoNhom").value = data.trangThai;
            }
            
            var myModal = new bootstrap.Modal(document.getElementById('modalSuaKHMN'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu kế hoạch mở nhóm:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatKeHoachMoNhom(event) {
    event.preventDefault();

    // Lấy dữ liệu từ form
    const id = document.getElementById("suaIDKeHoachMoNhom").value;
    const maNhom = document.getElementById("suaMaNhom").value;
    const hocPhanId = document.getElementById("suaHocPhanMoNhom").value.split(" - ")[0]; // Lấy id học phần
    const namHoc = document.getElementById("suaNamHoc").value;
    const hocKy = document.getElementById("suaHocKy").value;
    const slSinhVien = document.getElementById("suaSLSV").value;
    const thoiGianBatDau = document.getElementById("suaTGBD").value;
    const thoiGianKetThuc = document.getElementById("suaTGKT").value;
    const trangThai = document.getElementById("suaTrangThaiMoNhom").value;
    
    if(slSinhVien < 1){
        alert("Số lượng sinh viên phải lớn hơn hoặc bằng 1!");
        return;
    }

    const keHoachMoNhomData = {
        id: id,
        maNhom: maNhom,
        hocPhan: { id: hocPhanId },
        namHoc: namHoc,
        hocKy: hocKy,
        slSinhVien: slSinhVien,
        thoiGianBatDau: thoiGianBatDau,
        thoiGianKetThuc: thoiGianKetThuc,
        trangThai: trangThai
    };

    fetch(`/kehoachmonhom/sua/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(keHoachMoNhomData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Cập nhật kế hoạch mở nhóm không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cập nhật kế hoạch mở nhóm thành công:", data);
        alert("Cập nhật kế hoạch mở nhóm thành công!");
        // Đóng modal
        var myModal = new bootstrap.Modal(document.getElementById('modalSuaKHMN'));
        myModal.hide();
        
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cập nhật kế hoạch mở nhóm:", error);
        alert("Lỗi khi cập nhật kế hoạch mở nhóm!");
    });
}

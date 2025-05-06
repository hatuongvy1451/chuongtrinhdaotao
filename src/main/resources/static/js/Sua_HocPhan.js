/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function suaHocPhan(id){
    fetch(`/hocphan/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy học phần!");
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("suaIDHocPhan").value = data.id;
            document.getElementById("suaMaKhungCT").value = data.idKhungCT;
            document.getElementById("suaMaHocPhan").value = data.maHocPhan;
            document.getElementById("suaTenHocPhan").value = data.tenHocPhan;
            document.getElementById("suaTinChi").value = data.soTinChi;
            document.getElementById("suaLT").value = data.soTietLyThuyet;
            document.getElementById("suaTH").value = data.soTietThucHanh;
            document.getElementById("suaTT").value = data.soTietThucTap;
            document.getElementById("suaTongTiet").value = data.soTietCong;
            document.getElementById("suaHeSo").value = data.heSoHocPhan;
            document.getElementById("suaMaHPTruoc").value = data.maHPTruoc;
            if(data.trangThai === 1 || data.trangThai === 0){
                document.getElementById("suaTrangThaiHocPhan").value = data.trangThai;
            }
            
            var myModal = new bootstrap.Modal(document.getElementById('modalSuaHocPhan'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu học phần:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatHocPhan(event){
    event.preventDefault();
    
    const id = document.getElementById("suaIDHocPhan").value;
    const idKhungCT = document.getElementById("suaMaKhungCT").value;
    const maHocPhan = document.getElementById("suaMaHocPhan").value;
    const tenHocPhan = document.getElementById("suaTenHocPhan").value;
    const soTinChi = document.getElementById("suaTinChi").value;
    const soTietLyThuyet = document.getElementById("suaLT").value;
    const soTietThucHanh = document.getElementById("suaTH").value;
    const soTietThucTap = document.getElementById("suaTT").value;
    const soTietCong = document.getElementById("suaTongTiet").value;
    const heSoHocPhan = document.getElementById("suaHeSo").value;
    const maHPTruoc = document.getElementById("suaMaHPTruoc").value;
    const trangThai = document.getElementById("suaTrangThaiHocPhan").value;
    
    const hocPhanData = {
        id: id,
        idKhungCT: idKhungCT,
        maHocPhan: maHocPhan,
        tenHocPhan: tenHocPhan,
        soTinChi: soTinChi,
        soTietLyThuyet: soTietLyThuyet,
        soTietThucHanh: soTietThucHanh,
        soTietThucTap: soTietThucTap,
        soTietCong: soTietCong,
        heSoHocPhan: heSoHocPhan,
        maHPTruoc: maHPTruoc,
        trangThai: trangThai
    };
    
    fetch(`/hocphan/sua/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(hocPhanData)
    })
    .then(response => {
        if(!response.ok){
            throw new Error("Cập nhật học phần không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cập nhật học phần thành công!", data);
        alert("Cập nhật học phần thành công!");
        
        var myModal = new bootstrap.Modal(document.getElementById('modalSuaHocPhan'));
        myModal.hide();
        
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cập nhật học phần:", error);
        alert("Lỗi khi cập nhật học phần!");
    });
}

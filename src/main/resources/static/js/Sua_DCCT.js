/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function suaDeCuongChiTiet(id){
    fetch(`/decuongchitiet/xem/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy đề cương chi tiết!");
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("suaIdDeCuong").value = data.id;
            document.getElementById("suaMaHocPhan").value = data.hocPhan.id + ' - ' + data.hocPhan.tenHocPhan;
            document.getElementById("suaMoTa").value = data.moTa;
            document.getElementById("suaMucTieu").value = data.mucTieu;
            document.getElementById("suaChuongNoiDung").value = data.chuongNoiDung;
            document.getElementById("suaPhuongPhapGiangDay").value = data.phuongPhapGiangDay;
            document.getElementById("suaPhuongPhapDanhGia").value = data.phuongPhapDanhGia;
            document.getElementById("suaTaiLieu").value = data.taiLieuThamKhao;
            if(data.trangThai === 1 || data.trangThai === 0){
                document.getElementById("suaTrangThaiDCCT").value = data.trangThai;
            }
            
            var myModal = new bootstrap.Modal(document.getElementById('modalSuaDeCuong'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu đề cương chi tiết:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatDeCuongChiTiet(event){
    event.preventDefault();
    
    const id = document.getElementById("suaIdDeCuong").value;
    const hocPhan = document.getElementById("suaMaHocPhan").value.split(" - ")[0];
    const moTa = document.getElementById("suaMoTa").value;
    const mucTieu = document.getElementById("suaMucTieu").value;
    const chuongNoiDung = document.getElementById("suaChuongNoiDung").value;
    const phuongPhapGiangDay = document.getElementById("suaPhuongPhapGiangDay").value;
    const phuongPhapDanhGia = document.getElementById("suaPhuongPhapDanhGia").value;
    const taiLieuThamKhao = document.getElementById("suaTaiLieu").value;
    const trangThai = document.getElementById("suaTrangThaiDCCT").value;
    
    const dcctData = {
        id: id,
        hocPhan: { id: hocPhan },
        moTa: moTa,
        mucTieu: mucTieu,
        chuongNoiDung: chuongNoiDung,
        phuongPhapGiangDay: phuongPhapGiangDay,
        phuongPhapDanhGia: phuongPhapDanhGia,
        taiLieuThamKhao: taiLieuThamKhao,
        trangThai: trangThai
    };
    
    fetch(`/decuongchitiet/sua/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dcctData)
    })
    .then(response => {
        if(!response.ok){
            throw new Error("Cập nhật đề cương chi tiết không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cập nhật đề cương chi tiết thành công!", data);
        alert("Cập nhật đề cương chi tiết thành công!");
        
        var myModal = new bootstrap.Modal(document.getElementById('modalSuaDeCuong'));
        myModal.hide();
        
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cập nhật đề cương chi tiết:", error);
        alert("Lỗi khi cập nhật đề cương chi tiết!");
    });
}


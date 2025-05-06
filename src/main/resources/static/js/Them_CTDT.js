/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function themChuongTrinhDaoTao(event) {
    event.preventDefault();

    const ctdtData = {
        maCTDT: document.getElementById("addMaCTDT").value,
        tenCTDT: document.getElementById("addCTDT").value,
        bacDaoTao: document.getElementById("addBacDaoTao").value,
        loaiBang: document.getElementById("addLoaiBang").value,
        loaiHinhDaoTao: document.getElementById("addLoaiHinhDaoTao").value,
        thoiGianDaoTao: document.getElementById("addThoiGian").value,
        tinChiToiThieu: document.getElementById("soTinChi").value,
        khoaQuanLy: document.getElementById("addKhoaQuanLy").value,
        ngonNgu: document.getElementById("addNgonNgu").value,
        website: document.getElementById("addwebsite").value,
        trangThai: 1,
        banHanh: document.getElementById("addBanHanh").value
    };

    fetch("/thongtinchung/them", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(ctdtData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Thêm chương trình đào tạo thất bại!");
        }
        return response.json();
    })
    .then(data => {
        alert("Thêm chương trình đào tạo thành công!");
        var myModal = new bootstrap.Modal(document.getElementById('modalAdd'));
        myModal.hide();
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi thêm CTDT:", error);
        alert("Lỗi khi thêm chương trình đào tạo!");
    });
}

document.getElementById("formThemCTDT").addEventListener("submit", themChuongTrinhDaoTao);
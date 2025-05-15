/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function addDanhSachHocPhan(event) {
    event.preventDefault();

    const soTietLyThuyet = parseInt(document.getElementById('lt').value) || 0;
    const soTietThucHanh = parseInt(document.getElementById('th').value) || 0;
    const soTietThucTap = parseInt(document.getElementById('tt').value) || 0;

    const hocPhanData = {
        khungChuongTrinh: { id: document.getElementById('maKhungCT').value },
        maHocPhan: document.getElementById('maHocPhan').value,
        tenHocPhan: document.getElementById('tenHocPhan').value,
        soTinChi: parseInt(document.getElementById('tinChi').value) || 0,
        soTietLyThuyet: soTietLyThuyet,
        soTietThucHanh: soTietThucHanh,
        soTietThucTap: soTietThucTap,
        soTietCong: soTietLyThuyet + soTietThucHanh + soTietThucTap,
        heSoHocPhan: parseFloat(document.getElementById('heSo').value) || 0,
        maHPTruoc: document.getElementById('mahocPhanTruoc').value,
        trangThai: 1
    };

    fetch("/hocphan/them", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(hocPhanData)
    })
    .then(response => {
        if (!response.ok) {
            if (response.status === 409) { 
                return response.json().then(err => {
                    throw new Error(err.message || "Mã học phần đã tồn tại!");
                });
            } else {
                throw new Error("Thêm mới học phần thất bại!");
            }
        }
        return response.json();
    })
    .then(data => {
        alert("Thêm mới học phần thành công");
        var myModal = new bootstrap.Modal(document.getElementById("modalThemHocPhan"));
        myModal.hide();
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi thêm mới học phần", error);
        alert(error.message);
    });
}

document.getElementById('formThemHocPhan').addEventListener("submit", addDanhSachHocPhan);

function capNhatSoTietCong() {
    const lt = parseInt(document.getElementById('lt').value) || 0;
    const th = parseInt(document.getElementById('th').value) || 0;
    const tt = parseInt(document.getElementById('tt').value) || 0;

    const tong = lt + th + tt;
    document.getElementById('tongTiet').value = tong;
}

// Gắn sự kiện input
document.getElementById('lt').addEventListener('input', capNhatSoTietCong);
document.getElementById('th').addEventListener('input', capNhatSoTietCong);
document.getElementById('tt').addEventListener('input', capNhatSoTietCong);

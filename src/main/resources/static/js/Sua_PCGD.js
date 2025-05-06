/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

// Lấy dữ liệu phân công giảng dạy để sửa
function suaPhanCongGiangDay(id) {
    fetch(`/phanconggiangday/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Không tìm thấy phân công giảng dạy!");
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            // Gán dữ liệu vào form sửa
            document.getElementById("suaIDPhanCong").value = data.id;
            document.getElementById("suaGiangVien").value = `${data.giangVien.id} - ${data.giangVien.tenGiangVien}`;
            document.getElementById("suaNhom").value = `${data.moNhom.id} - ${data.moNhom.maNhom}`;
            document.getElementById("suaSoTietThucHien").value = data.soTietThucHien;
            document.getElementById("suaSoTietThucTe").value = data.soTietThucTe;
            if (data.trangThai === 1 || data.trangThai === 0) {
                document.getElementById("suaTrangThaiPhanCong").value = data.trangThai;
            }

            // Mở modal
            var myModal = new bootstrap.Modal(document.getElementById('modalSuaPCGD'));
            myModal.show();
        })
        .catch(error => {
            console.error("Lỗi khi lấy dữ liệu phân công:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatPhanCong(event) {
    event.preventDefault();

    // Lấy dữ liệu từ form
    const id = document.getElementById("suaIDPhanCong").value;
    const giangVienId = document.getElementById("suaGiangVien").value.split(" - ")[0]; // Lấy id giảng viên
    const moNhom = document.getElementById("suaNhom").value.split(" - ")[0]; // Lấy id học phần
    const soTietThucHien = document.getElementById("suaSoTietThucHien").value;
    const soTietThucTe = document.getElementById("suaSoTietThucTe").value;
    const trangThai = document.getElementById("suaTrangThaiPhanCong").value;

    const phanCongData = {
        id: id,
        giangVien: { id: giangVienId },
        moNhom: { id: moNhom },
        soTietThucHien: soTietThucHien,
        soTietThucTe: soTietThucTe,
        trangThai: trangThai
    };

    // Gửi yêu cầu PUT để cập nhật phân công giảng dạy
    fetch(`/phanconggiangday/sua/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(phanCongData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Cập nhật phân công giảng dạy không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cập nhật phân công giảng dạy thành công:", data);
        alert("Cập nhật phân công giảng dạy thành công!");
        // Đóng modal
        var myModal = new bootstrap.Modal(document.getElementById('modalSuaPCGD'));
        myModal.hide();
        
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cập nhật phân công giảng dạy:", error);
        alert("Lỗi khi cập nhật phân công giảng dạy!");
    });
}









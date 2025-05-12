/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function loadGiangVien() {
    fetch('/giangvien/trangthai')
        .then(response => response.json())
        .then(data => {
            const selectGiangVien = document.getElementById('suaGiangVien');
            selectGiangVien.innerHTML = '<option value="" disabled selected>--- Chọn giảng viên ---</option>';
            data.forEach(item => {
                let option = document.createElement('option');
                option.value = item.id; 
                option.text = `${item.maGiangVien} - ${item.tenGiangVien}`;
                selectGiangVien.appendChild(option);
            });
        })
        .catch(error => console.error('Lỗi khi load giảng viên:', error));
}

window.onload = loadGiangVien;

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
            document.getElementById("suaGiangVien").value = data.giangVien.id;
            document.getElementById("suaNhom").value = `${data.moNhom.id} - ${data.moNhom.maNhom}`;
            document.getElementById("suaHocPhanMoNhom").value = `${data.moNhom.hocPhan.id} - ${data.moNhom.hocPhan.tenHocPhan}`;
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
    
    if(soTietThucHien < 1){
        alert("Số tiết thực hiện phải lớn hơn hoặc bằng 1!");
        return;
    }
    
    if(soTietThucTe < 1){
        alert("Số tiết thực tế phải lớn hơn hoặc bằng 1");
        return;
    }

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









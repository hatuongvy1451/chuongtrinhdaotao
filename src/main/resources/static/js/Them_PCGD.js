/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function loadNhomActive() {
    fetch('/phanconggiangday/nhom-da-phancong')
        .then(res => res.json())
        .then(nhomDaPhanCong => {
            fetch('/kehoachmonhom/trangthai')
                .then(response => response.json())
                .then(data => {
                    const selectNhom = document.getElementById('nhomPhanCong');
                    selectNhom.innerHTML = '<option value="" disabled selected>--- Chọn nhóm ---</option>';

                    data.forEach(item => {
                        if (!nhomDaPhanCong.includes(item.id)) {
                            let option = document.createElement('option');
                            option.value = item.id;
                            option.text = `${item.id} - ${item.maNhom}`;
                            selectNhom.appendChild(option);
                        }
                    });

                    // Lắng nghe sự kiện thay đổi chọn nhóm
                    selectNhom.addEventListener('change', function() {
                        const nhomId = selectNhom.value;
                        if (nhomId) {
                            // Gửi yêu cầu để lấy học phần tương ứng với nhóm đã chọn
                            fetch(`/kehoachmonhom/hocphan/${nhomId}`)
                                .then(response => response.json())
                                .then(hocPhan => {
                                    if (hocPhan) {
                                        const hocPhanInput = document.getElementById('hocPhanMoNhom');
                                        const soTietInput = document.getElementById('soTietThucHien');
                                        hocPhanInput.value = `${hocPhan.id} - ${hocPhan.tenHocPhan}`;
                                        soTietInput.value = hocPhan.soTietCong;
                                    } else {
                                        alert('Không tìm thấy học phần cho nhóm này.');
                                    }
                                })
                                .catch(error => {
                                    console.error('Lỗi khi lấy học phần:', error);
                                    alert('Không thể lấy học phần cho nhóm này.');
                                });
                        }
                    });
                })
                .catch(error => console.error('Lỗi khi load nhóm học:', error));
        })
        .catch(error => console.error('Lỗi khi load nhóm đã phân công:', error));
}

function loadGiangVienActive() {
    fetch('/giangvien/trangthai')
        .then(response => response.json())
        .then(data => {
            const selectGiangVien = document.getElementById('giangVienPhanCong');
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

document.addEventListener('DOMContentLoaded', () => {
    loadNhomActive();
    loadGiangVienActive();
});

function themPhanCongGiangDay(event){
    event.preventDefault();
    
    // Lấy dữ liệu từ form
    const phanCongData = {
        giangVien: { id: document.getElementById('giangVienPhanCong').value },
        moNhom: { id: document.getElementById('nhomPhanCong').value },
        soTietThucHien: document.getElementById('soTietThucHien').value, 
        soTietThucTe: document.getElementById('soTietThucTe').value,
        trangThai: 1
    };
    
    const soTietThucHien = document.getElementById('soTietThucHien').value;
    if (isNaN(soTietThucHien) || soTietThucHien < 1) {
        alert("Số tiết thực hiện phải là số và lớn hơn hoặc bằng 1!");
        return;
    }

    const soTietThucTe = document.getElementById('soTietThucTe').value;
    if (isNaN(soTietThucTe) || soTietThucTe < 1) {
        alert("Số tiết thực tế phải là số và lớn hơn hoặc bằng 1!");
        return;
    }

    fetch("/phanconggiangday/them", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(phanCongData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Thêm mới phân công giảng dạy thất bại!");
        }
        return response.json();
    })
    .then(data => {
        alert("Thêm phân công giảng dạy thành công!");
        var myModal = new bootstrap.Modal(document.getElementById("modalPhanCongGiangDay"));
        myModal.hide();
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi thêm phân công giảng dạy!", error);
        alert("Lỗi khi thêm phân công giảng dạy!");
    });
}

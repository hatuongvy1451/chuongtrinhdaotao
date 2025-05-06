/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function loadCTDTActive() {
    fetch('/thongtinchung/trangthai')
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('ctdtKHDH');
            select.innerHTML = '<option value="" disabled selected>--- Chọn chương trình đào tạo ---</option>';
            data.forEach(item => {
                let option = document.createElement('option');
                option.value = item.id; 
                option.text = item.tenChuongTrinh || ("CTDT " + item.id); 
                select.appendChild(option);
            });
        })
        .catch(error => console.error('Lỗi khi load CTDT:', error));
}

window.onload = loadCTDTActive;

document.getElementById('ctdtKHDH').addEventListener('change', function () {
    const ctdtId = this.value;
    if (!ctdtId) return;

    fetch(`/hocphan/ctdt/${ctdtId}`)
        .then(response => response.json())
        .then(data => {
            const hocPhanSelect = document.getElementById('hocPhanSelect');
            hocPhanSelect.innerHTML = '<option value="" disabled selected>--- Chọn học phần ---</option>';
            data.forEach(item => {
                let option = document.createElement('option');
                option.value = item.id;
                option.text = `${item.maHocPhan} - ${item.tenHocPhan}`;
                hocPhanSelect.appendChild(option);
            });
        })
        .catch(error => console.error('Lỗi khi load học phần:', error));
});

function themKeHoachDayHoc(event){
    event.preventDefault();
    
    // Lấy dữ liệu từ form
    const keHoachData = {
        ctdt: { id: document.getElementById('ctdtKHDH').value },
        hocPhan: { id: document.getElementById('hocPhanSelect').value },
        hocKyThucHien: document.getElementById('hocKyThucHien').value, 
        namHoc: document.getElementById('namHoc').value,
        trangThai: 1
    };

    fetch("/kehoachdayhoc/them", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(keHoachData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Thêm mới kế hoạch dạy học thất bại");
        }
        return response.json();
    })
    .then(data => {
        alert("Thêm kế hoạch dạy học thành công!");
        var myModal = new bootstrap.Modal(document.getElementById("modalKeHoachDayHoc"));
        myModal.hide();
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi thêm kế hoạch dạy học!", error);
        alert("Lỗi khi thêm kế hoạch dạy học");
    });
}



/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function loadHocPhan() {
    fetch('/hocphan/trangthai')
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('hocPhanMoNhom');
            select.innerHTML = '<option value="" disabled selected>--- Chọn học phần ---</option>';
            data.forEach(item => {
                let option = document.createElement('option');
                option.value = item.id; 
                option.text = `${item.maHocPhan} - ${item.tenHocPhan}`;
                select.appendChild(option);
            });
        })
        .catch(error => console.error('Lỗi khi load học phần:', error));
}

window.onload = function() {
    loadHocPhan();

    document.getElementById('namHocKHMN').disabled = true;
    document.getElementById('hocKyKHMN').disabled = true;
};

document.getElementById('hocPhanMoNhom').addEventListener('change', function () {
    const hocPhanId = this.value;
    
    if (!hocPhanId) {
        alert("Vui lòng chọn học phần trước!");
        return;
    }

    // Bật dropdown sau khi chọn học phần
    document.getElementById('namHocKHMN').disabled = false;
    document.getElementById('hocKyKHMN').disabled = false;

    fetch(`/kehoachdayhoc/nam-hoc-hoc-ky?hocPhanId=${hocPhanId}`)
        .then(response => response.json())
        .then(data => {
            const namHocSelect = document.getElementById('namHocKHMN');
            const hocKySelect = document.getElementById('hocKyKHMN');

            // Reset dropdown
            namHocSelect.innerHTML = '<option value="" disabled selected>--- Chọn năm học ---</option>';
            hocKySelect.innerHTML = '<option value="" disabled selected>--- Chọn học kỳ ---</option>';

            // Dùng Set để không trùng
            const namHocSet = new Set();
            const hocKySet = new Set();

            data.forEach(item => {
                namHocSet.add(item[0]); // Năm học
                hocKySet.add(item[1]);  // Học kỳ
            });

            namHocSet.forEach(nh => {
                const option = document.createElement('option');
                option.value = nh;
                option.text = nh;
                namHocSelect.appendChild(option);
            });

            hocKySet.forEach(hk => {
                const option = document.createElement('option');
                option.value = hk;
                option.text = hk;
                hocKySelect.appendChild(option);
            });
        })
        .catch(error => console.error('Lỗi khi load năm học - học kỳ:', error));
});

function themKeHoachMoNhom(event){
    event.preventDefault();
    
    // Lấy dữ liệu từ form
    const khmnData = {
        maNhom: document.getElementById('maNhom').value,
        hocPhan: { id: document.getElementById('hocPhanMoNhom').value },
        namHoc: document.getElementById('namHocKHMN').value, 
        hocKy: document.getElementById('hocKyKHMN').value,
        slSinhVien: document.getElementById('slSinhVien').value,
        thoiGianBatDau: document.getElementById('thoiGianBatDau').value,
        thoiGianKetThuc: document.getElementById('thoiGianKetThuc').value,
        trangThai: 1
    };

    fetch("/kehoachmonhom/them", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(khmnData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Thêm mới kế hoạch mở nhóm thất bại");
        }
        return response.json();
    })
    .then(data => {
        alert("Thêm kế hoạch mở nhóm thành công!");
        var myModal = new bootstrap.Modal(document.getElementById("modalThemKHMN"));
        myModal.hide();
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi thêm kế hoạch mở nhóm!", error);
        alert("Lỗi khi thêm kế hoạch mở nhóm!");
    });
}


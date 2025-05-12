/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function addCotDiem(event) {
    event.preventDefault();

    const dcctId = document.getElementById('deCuongChiTiet').value;  
    const tyLeMoi = parseFloat(document.getElementById('tyLe').value);  
    const tenCotDiemMoi = document.getElementById('tenCotDiem').value; 

    // Kiểm tra nếu tên cột điểm đã tồn tại
    fetch(`/cotdiem/kiem-tra-ten?dcctId=${dcctId}&tenCotDiem=${tenCotDiemMoi}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Không thể kiểm tra tên cột điểm");
            }
            return response.json();  // Nhận kết quả kiểm tra tên cột điểm
        })
        .then(data => {
            if (data.exists) {
                alert("Tên cột điểm đã tồn tại! Vui lòng nhập tên khác.");
                return;  // Dừng lại nếu tên cột điểm đã tồn tại
            }

            // Gửi yêu cầu GET để kiểm tra tổng tỷ lệ phần trăm hiện tại của các cột điểm
            fetch(`/cotdiem/tong-ty-le?dcctId=${dcctId}`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Không thể kiểm tra tổng tỷ lệ phần trăm");
                    }
                    return response.json();  // Nhận tổng tỷ lệ phần trăm hiện tại từ server
                })
                .then(tongHienTai => {
                    if (tongHienTai + tyLeMoi > 100) {
                        alert("Không thể thêm! Tổng tỷ lệ phần trăm đã đủ hoặc vượt quá 100%.");
                        return;  // Dừng lại nếu tổng tỷ lệ vượt quá 100%
                    }

                    // Dữ liệu cột điểm cần thêm
                    const cotDiemData = {
                        dcct: { id: dcctId },
                        tenCotDiem: tenCotDiemMoi,
                        tyLePhanTram: tyLeMoi,
                        hinhThuc: document.getElementById('hinhThuc').value
                    };

                    // Gửi yêu cầu POST để thêm cột điểm
                    fetch("/cotdiem/them", {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify(cotDiemData)
                    })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error("Thêm mới cột điểm thất bại");
                        }
                        return response.json();  // Nhận phản hồi từ server
                    })
                    .then(data => {
                        alert("Thêm mới cột điểm thành công!");
                        var myModal = new bootstrap.Modal(document.getElementById("modalAddCotDiem"));
                        myModal.hide();
                        const filterDeCuongChiTiet = document.getElementById('filterDeCuongChiTiet');
                        if (filterDeCuongChiTiet.value) {
                            loadCotDiemTheoDeCuong();
                        } else {
                            location.reload();
                        }
                    })
                    .catch(error => {
                        console.error("Lỗi thêm mới cột điểm:", error);
                        alert("Lỗi thêm mới cột điểm!");
                    });
                })
                .catch(error => {
                    console.error("Lỗi kiểm tra tổng tỷ lệ:", error);
                    alert("Lỗi kiểm tra tổng tỷ lệ phần trăm!");
                });
        })
        .catch(error => {
            console.error("Lỗi kiểm tra tên cột điểm:", error);
            alert("Lỗi kiểm tra tên cột điểm!");
        });
}

document.getElementById('formThemCotDiem').addEventListener("submit", addCotDiem);

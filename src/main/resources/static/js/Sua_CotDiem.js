/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function suaCotDiem(id){
    fetch(`/cotdiem/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy cột điểm!");
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("editIdCotDiem").value = data.id;
            document.getElementById("editDeCuongChiTiet").value = data.dcct.id + " - " + data.dcct.hocPhan.tenHocPhan;
            document.getElementById("editTenCotDiem").value = data.tenCotDiem;
            document.getElementById("editTenCotDiem").setAttribute("data-old", data.tenCotDiem);
            document.getElementById("editTyLe").value = data.tyLePhanTram;
            document.getElementById("editTyLe").setAttribute("data-old", data.tyLePhanTram);
            document.getElementById("editHinhThuc").value = data.hinhThuc;
            
            var myModal = new bootstrap.Modal(document.getElementById('modalEditCotDiem'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu cột điểm:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatCotDiem(event) {
    event.preventDefault();

    const id = parseInt(document.getElementById("editIdCotDiem").value);
    const dcct = parseInt(document.getElementById("editDeCuongChiTiet").value.split(' - ')[0]);
    const tenCotDiem = document.getElementById("editTenCotDiem").value.trim();
    const tyLePhanTramMoi = parseFloat(document.getElementById("editTyLe").value);
    const hinhThuc = document.getElementById("editHinhThuc").value;

    // Kiểm tra tỷ lệ phần trăm hợp lệ
    if (tyLePhanTramMoi < 1 || tyLePhanTramMoi > 100) {
        alert("Tỷ lệ phần trăm phải nằm trong khoảng từ 1 đến 100!");
        return;
    }

    fetch(`/cotdiem/tong-ty-le?dcctId=${dcct}`)
        .then(response => response.json())
        .then(tongTyLeHienTai => {
            const tyLeCu = parseFloat(document.getElementById("editTyLe").getAttribute("data-old") || 0);
            const tongSauKhiSua = tongTyLeHienTai - tyLeCu + tyLePhanTramMoi;

            if (tongSauKhiSua > 100) {
                alert(`Tổng tỷ lệ phần trăm sau khi sửa vượt quá 100%!\nHiện tại: ${tongTyLeHienTai}%\nSau khi sửa: ${tongSauKhiSua}%`);
                return;
            }

            // 3. Kiểm tra tên cột điểm có bị trùng không (gọi đúng API hiện tại)
            fetch(`/cotdiem/kiem-tra-ten?dcctId=${dcct}&tenCotDiem=${encodeURIComponent(tenCotDiem)}`)
                .then(response => response.json())
                .then(data => {
                    const exists = data.exists;

                    // Nếu tên trùng nhưng không phải là chính mình, mới chặn
                    const tenCu = document.getElementById("editTenCotDiem").getAttribute("data-old");
                    if (exists && tenCotDiem !== tenCu) {
                        alert("Tên cột điểm này đã tồn tại!");
                        return;
                    }

                    // 4. Gửi yêu cầu cập nhật
                    const cotDiemData = {
                        id: id,
                        dcct: { id: dcct },
                        tenCotDiem: tenCotDiem,
                        tyLePhanTram: tyLePhanTramMoi,
                        hinhThuc: hinhThuc
                    };

                    fetch(`/cotdiem/sua/${id}`, {
                        method: "PUT",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify(cotDiemData)
                    })
                        .then(response => {
                            if (!response.ok) {
                                throw new Error("Cập nhật cột điểm không thành công!");
                            }
                            return response.json();
                        })
                        .then(data => {
                            alert("Cập nhật cột điểm thành công!");
                            var myModal = new bootstrap.Modal(document.getElementById('modalEditCotDiem'));
                            myModal.hide();
                            location.reload();
                        })
                        .catch(error => {
                            console.error("Lỗi khi cập nhật cột điểm:", error);
                            alert("Lỗi khi cập nhật cột điểm!");
                        });
                });
        })
        .catch(error => {
            console.error("Lỗi khi kiểm tra tổng tỷ lệ:", error);
            alert("Lỗi khi kiểm tra tổng tỷ lệ!");
        });
}

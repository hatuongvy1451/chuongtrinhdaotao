/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function loadHocPhanTheoHocKy() {
    var hocKyThucHien = document.getElementById("hocKySelect").value;

    $.ajax({
        url: '/xemhocphantunghocky/' + hocKyThucHien,
        type: 'GET',
        success: function(data) {
            // Nếu DataTable đã được khởi tạo thì hủy trước
            if ($.fn.DataTable.isDataTable('#tableHPTheoKy')) {
                $('#tableHPTheoKy').DataTable().clear().destroy();
            }

            // Đổ dữ liệu vào tbody
            var tbody = $('#hocPhanTableBody');
            tbody.empty();
            data.forEach((hp) => {
                tbody.append(`
                    <tr>
                        <td>${hp.id}</td>
                        <td>${hp.khungChuongTrinh.id}</td>
                        <td>${hp.maHocPhan}</td>
                        <td>${hp.tenHocPhan}</td>
                        <td>${hp.soTinChi}</td>
                        <td>${hp.soTietLyThuyet}</td>
                        <td>${hp.soTietThucHanh}</td>
                        <td>${hp.soTietThucTap}</td>
                        <td>${hp.soTietCong}</td>
                        <td>${hp.heSoHocPhan}</td>
                        <td>${hp.trangThai === 1 ? 'Đang hoạt động' : 'Đã hủy'}</td>
                    </tr>
                `);
            });

            // Khởi tạo lại DataTable
            $('#tableHPTheoKy').DataTable({
                paging: true,
                pageLength: 7,
                lengthChange: false,
                info: false,
                searching: true,
                ordering: false,
                language: {
                    search: "Tìm kiếm:",
                    paginate: {
                        previous: "Trước",
                        next: "Sau"
                    },
                    infoEmpty: "Không có dữ liệu",
                    zeroRecords: "Không tìm thấy kết quả phù hợp!"
                }
            });
        },
        error: function(xhr, status, error) {
            console.error("AJAX Error: " + error);
        }
    });
}

// Tải dữ liệu ban đầu khi trang được load
$(document).ready(function() {
    loadHocPhanTheoHocKy();

    // Thêm sự kiện khi người dùng chọn học kỳ
    $('#hocKySelect').change(function() {
        loadHocPhanTheoHocKy();
    });
});


/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function loadHocPhanTheoKhoiKienThuc() {
    var idKhoiKT = document.getElementById("khoiSelect").value;

    $.ajax({
        url: '/xemhocphantheokhoi/' + idKhoiKT,
        type: 'GET',
        success: function(data) {
            // Nếu DataTable đã được khởi tạo thì hủy trước
            if ($.fn.DataTable.isDataTable('#tableHPTheoKhoi')) {
                $('#tableHPTheoKhoi').DataTable().clear().destroy();
            }

            // Đổ dữ liệu vào tbody
            var tbody = $('#hocPhanBody');
            tbody.empty();
            data.forEach((hp) => {
                tbody.append(`
                    <tr>
                        <td>${hp.id}</td>
                        <td>${hp.idKhungCT}</td>
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
            $('#tableHPTheoKhoi').DataTable({
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
    loadHocPhanTheoKhoiKienThuc();

    // Thêm sự kiện khi người dùng chọn học kỳ
    $('#khoiSelect').change(function() {
        loadHocPhanTheoKhoiKienThuc();
    });
});

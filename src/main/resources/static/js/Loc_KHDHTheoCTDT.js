/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function loadKHDHTheoCTDT() {
    var ctdt = document.getElementById("filterCTDT").value;

    $.ajax({
        url: '/kehoachdayhoc/loc-theo-ctdt/' + ctdt,
        type: 'GET',
        success: function(data) {
            // Nếu DataTable đã được khởi tạo thì hủy trước
            if ($.fn.DataTable.isDataTable('#tableKeHoachDayHoc')) {
                $('#tableKeHoachDayHoc').DataTable().clear().destroy();
            }

            // Đổ dữ liệu vào tbody
            var tbody = $('#khdhBody');
            tbody.empty();
            data.forEach((kehoachdh) => {
                tbody.append(`
                    <tr>
                
                                <td>${kehoachdh.id}</td>
                                <td>${kehoachdh.ctdt.maCTDT}</td>
                                <td>${kehoachdh.hocPhan.maHocPhan}</td>
                                <td>${kehoachdh.hocPhan.tenHocPhan}</td>
                                <td>${kehoachdh.hocKyThucHien}</td>
                                <td>${kehoachdh.namHoc}</td>
                                <td>${kehoachdh.trangThai == 1 ? 'Đang mở' : 'Đã kết thúc'}</td>
                                <td>${`
                                    <button class="btn btn-warning btn-sm" id="btnSua" data-toggle="modal" data-target="#modalSuaKHDH"
                                            th:onclick="'suaKeHoachDayHoc(' + ${kehoachdh.id} + ')'">
                                        <i class="fas fa-edit"></i> Sửa
                                    </button>
                                    <button class="btn btn-danger btn-sm" id="btnXoa" th:onclick="'xoaKeHoachDayHoc(' + ${kehoachdh.id} + ')'">
                                        <i class="fas fa-trash"></i> Xóa
                                    </button>
                                ` }</td>
                    </tr>
                `);
            });

            // Khởi tạo lại DataTable
            $('#tableKeHoachDayHoc').DataTable({
                paging: true,
                pageLength: 7,
                lengthChange: false,
                info: false,
                searching: false,
                ordering: false,
                language: {
                    search: "Tìm kiếm:",
                    paginate: {
                        previous: "Trước",
                        next: "Sau"
                    },
                    infoEmpty: "Không có dữ liệu",
                    zeroRecords: "Không tìm thấy kết quả phù hợp!"
                },
                drawCallback: function () {
                    let api = this.api();
                    let pageInfo = api.page.info();
                    // Nếu chỉ có 1 trang thì ẩn phân trang
                    $(api.table().container()).find('.dataTables_paginate')
                        .css('display', pageInfo.pages <= 1 ? 'none' : 'block');
                }
            });
        },
        error: function(xhr, status, error) {
            console.error("AJAX Error: " + error);
        }
    });
}

$(document).ready(function() {
    loadKHDHTheoCTDT();

    $('#filterCTDT').change(function() {
        loadKHDHTheoCTDT();
    });
});




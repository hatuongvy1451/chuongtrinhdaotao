/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function loadCotDiemTheoDeCuong() {
    var idDeCuong = document.getElementById("filterDeCuongChiTiet").value;

    $.ajax({
        url: '/cotdiem/loc-theo-dcct/' + idDeCuong,
        type: 'GET',
        success: function(data) {
            // Nếu DataTable đã được khởi tạo thì hủy trước
            if ($.fn.DataTable.isDataTable('#tableCotDiem')) {
                $('#tableCotDiem').DataTable().clear().destroy();
            }

            // Đổ dữ liệu vào tbody
            var tbody = $('#cotDiemTableBody');
            tbody.empty();
            data.forEach((cot) => {
                tbody.append(`
                    <tr>
                        <td>${cot.id}</td>
                        <td  style="width: 250px;">${cot.dcct.id} - ${cot.dcct.hocPhan.tenHocPhan}</td>
                        <td>${cot.tenCotDiem}</td>
                        <td>${cot.tyLePhanTram}%</td>
                        <td>${cot.hinhThuc}</td>
                        <td>${`
                            <button class="btn btn-sm btn-warning" data-toggle="modal" data-target="#modalEditCotDiem"
                                    onclick="suaCotDiem(${cot.id})">
                                <i class="fas fa-edit"></i> Sửa
                            </button>
                            <button class="btn btn-sm btn-danger" onclick="xoaCotDiem(${cot.id})">
                                <i class="fas fa-trash-alt"></i> Xóa
                            </button>
                        ` }</td>
                    </tr>
                `);
            });

            // Khởi tạo lại DataTable
            $('#tableCotDiem').DataTable({
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
    loadCotDiemTheoDeCuong();

    $('#filterDeCuongChiTiet').change(function() {
        loadCotDiemTheoDeCuong();
    });
});



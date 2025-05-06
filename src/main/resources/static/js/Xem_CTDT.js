/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xemChiTietKeHoachDayHoc(id) {
        fetch('/thongtinchung/xem/' + id) 
            .then(response => response.json()) 
            .then(data => {
                // Cập nhật các giá trị trong modal
                document.getElementById('viewMaCTDT').value = data.maCTDT;
                document.getElementById('viewTenCTDT').value = data.tenCTDT;
                document.getElementById('viewBacDaoTao').value = data.bacDaoTao;
                document.getElementById('viewLoaiBang').value = data.loaiBang;
                document.getElementById('viewLoaiHinhDaoTao').value = data.loaiHinhDaoTao;
                document.getElementById('viewThoiGian').value = data.thoiGianDaoTao;
                document.getElementById('viewTinChiToiThieu').value = data.tinChiToiThieu;
                document.getElementById('viewKhoaQuanLy').value = data.khoaQuanLy;
                document.getElementById('viewNgonNgu').value = data.ngonNgu;
                document.getElementById('viewWebsite').value = data.website;
                document.getElementById('viewBanHanh').value = data.banHanh;
                if (data.trangThai === 1) {
                    document.getElementById('viewTrangThai').value = "Đang áp dụng";
                } else if (data.trangThai === 0) {
                    document.getElementById('viewTrangThai').value = "Ngưng áp dụng";
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
}

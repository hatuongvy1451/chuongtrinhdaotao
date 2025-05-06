/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xemDeCuongChiTiet(id) {
        fetch('/decuongchitiet/xem/' + id) 
            .then(response => response.json()) 
            .then(data => {
                // Cập nhật các giá trị trong modal
                document.getElementById('xemMaHocPhan').value = data.hocPhan.id + ' - ' + data.hocPhan.tenHocPhan;
                document.getElementById('xemMoTa').value = data.moTa;
                document.getElementById('xemMucTieu').value = data.mucTieu;
                document.getElementById('xemChuongNoiDung').value = data.chuongNoiDung;
                document.getElementById('xemPhuongPhapGiangDay').value = data.phuongPhapGiangDay;
                document.getElementById('xemPhuongPhapDanhGia').value = data.phuongPhapDanhGia;
                document.getElementById('xemTaiLieu').value = data.taiLieuThamKhao;
                if (data.trangThai === 1) {
                    document.getElementById('xemTrangThai').value = "Đã xét duyệt";
                } else if (data.trangThai === 0) {
                    document.getElementById('xemTrangThai').value = "Chờ xét duyệt";
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
}

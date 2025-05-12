/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xoaCotDiem(id){
    if(confirm(`Bạn có chắc chắn muốn xóa cột điểm ${id} không?`)){
        fetch(`/cotdiem/xoa/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if(!response.ok){
                throw new Error("Xóa cột điểm không thành công!");
            }
            return response.json();
        })
        .then(data => {
            alert(data.message);
            const filterDeCuongChiTiet = document.getElementById('filterDeCuongChiTiet');
            if (filterDeCuongChiTiet.value) {
                loadCotDiemTheoDeCuong();
            } else {
                location.reload();
            }
        })
        .catch(error => {
            console.error("Lỗi khi xóa cột điểm:", error);
            alert("Xóa cột điểm không thành công!");
        });
    }
}

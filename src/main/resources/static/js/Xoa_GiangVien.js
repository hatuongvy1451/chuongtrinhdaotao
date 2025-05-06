/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xoaGiangVien(id){
    if(confirm(`Bạn có chắc chắn muốn xóa giảng viên ${id} không?`)){
        fetch(`/giangvien/xoa/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if(!response.ok){
                throw new Error("Xóa giảng viên không thành công!");
            }
            return response.json();
        })
        .then(data => {
            alert(data.message);
            location.reload();
        })
        .catch(error => {
            console.error("Lỗi khi xóa giảng viên:", error);
            alert("Xóa giảng viên không thành công!");
        });
    }
}

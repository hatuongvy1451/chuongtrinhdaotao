/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xoaNguoiDung(id){
    if(confirm(`Bạn có chắc chắn muốn xóa người dùng ${id} không?`)){
        fetch(`/nguoidung/xoa/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if(!response.ok){
                throw new Error("Xóa người dùng không thành công!");
            }
            return response.json();
        })
        .then(data => {
            alert(data.message);
            location.reload();
        })
        .catch(error => {
            console.error("Lỗi khi xóa người dùng:", error);
            alert("Xóa người dùng không thành công!");
        });
    }
}

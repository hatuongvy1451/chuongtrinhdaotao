/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xoaKhoiKienThuc(id){
    if(confirm(`Bạn có chắc chắn muốn xóa khối kiến thức ${id} không?`)){
        fetch(`/khoikienthuc/xoa/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if(!response.ok){
                throw new Error("Xóa khối kiến thức không thành công!");
            }
            return response.json();
        })
        .then(data => {
            alert(data.message);
            location.reload();
        })
        .catch(error => {
            console.error("Lỗi khi xóa khối kiến thức:", error);
            alert("Xóa khối kiến thức không thành công!");
        });
    }
}

/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xoaKeHoachMoNhom(id){
    if(confirm(`Bạn có chắc chắn muốn xóa kế hoạch mở nhóm ${id} không?`)){
        fetch(`/kehoachmonhom/xoa/${id}`,{
            method: 'DELETE'
        })
        .then(response => {
            if(!response.ok){
                throw new Error("Xóa kế hoạch mở nhóm không thành công!");
            }
            return response.json();
        })
        .then(data => {
            alert(data.message);
            location.reload();
        })
        .catch(error => {
            console.error("Lỗi khi xóa kế hoạch mở nhóm:", error);
            alert("Xóa kế hoạch mở nhóm không thành công!");
        });
    }
}


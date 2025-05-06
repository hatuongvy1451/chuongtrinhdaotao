/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xoaHocPhan(id){
    if(confirm(`Bạn có chắc chắn muốn xóa học phần ${id} không?`)){
        fetch(`/hocphan/xoa/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if(!response.ok){
                throw new Error("Xóa học phần không thành công!");
            }
            return response.json();
        })
        .then(data => {
            alert(data.message);
            location.reload();
        })
        .catch(error => {
            console.error("Lỗi khi xóa học phần:", error);
            alert("Xóa học phần không thành công!");
        });
    }
}


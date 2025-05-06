/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xoaPhanCongGiangDay(id){
    if(confirm(`Bạn có chắc chắn muốn xóa phân công giảng dạy ${id} không?`)){
        fetch(`/phanconggiangday/xoa/${id}`,{
            method: 'DELETE'
        })
        .then(response => {
            if(!response.ok){
                throw new Error("Xóa phân công giảng dạy không thành công!");
            }
            return response.json();
        })
        .then(data => {
            alert(data.message);
            location.reload();
        })
        .catch(error => {
            console.error("Lỗi khi xóa phân công giảng dạy:", error);
            alert("Xóa phân công giảng dạy không thành công!");
        });
    }
}


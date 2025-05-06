/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xoaThongTinChung(id){
    if(confirm(`Bạn có chắc chắn muốn xóa thông tin CTĐT ${id} không?`)) {
        fetch(`/thongtinchung/xoa/${id}`, {
            method: "DELETE"
        })
        .then(response => {
            if(!response.ok){
                throw new Error("Xóa thông tin CTĐT không thành công!");
            }
            return response.json();
        })
        .then(data => {
            alert(data.message);
            location.reload();
        })
        .catch(error => {
            console.error("Lỗi khi xóa thông tin CTĐT:", error);
            alert("Xóa thông tin CTĐT không thành công!");
        });
    }
}

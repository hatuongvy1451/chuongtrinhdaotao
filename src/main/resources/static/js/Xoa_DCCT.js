/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xoaDeCuongChiTiet(id){
    if(confirm(`Bạn có chắc chắn muốn xóa đề cương chi tiết ${id} không?`)){
        fetch(`/decuongchitiet/xoa/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if(!response.ok){
                throw new Error("Xóa đề cương chi tiết không thành công!");
            }
            return response.json();
        })
        .then(data => {
            alert(data.message);
            location.reload();
        })
        .catch(error => {
            console.error("Lỗi khi xóa đề cương chi tiết:", error);
            alert("Xóa đề cương chi tiết không thành công!");
        });
    }
}

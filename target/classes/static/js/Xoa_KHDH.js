/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function xoaKeHoachDayHoc(id) {
    if (confirm(`Bạn có chắc chắn muốn xóa kế hoạch dạy học ${id} không?`)) {
        fetch(`/kehoachdayhoc/xoa/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error("Xóa kế hoạch dạy học không thành công!");
            }
            return response.json();
        })
        .then(data => {
            alert(data.message);
            location.reload();
        })
        .catch(error => {
            console.error("Lỗi khi xóa kế hoạch dạy học:", error);
            alert("Xóa kế hoạch dạy học không thành công!");
        });
    }
}



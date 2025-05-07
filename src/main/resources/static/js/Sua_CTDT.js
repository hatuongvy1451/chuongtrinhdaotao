/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function suaThongTinChung(id){
    fetch(`/thongtinchung/xem/${id}`)
        .then(response => {
            if(!response.ok){
                throw new Error("Không tìm thấy thông tin đào tạo!");
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("suaIDCtDT").value = data.id;
            document.getElementById("editMaCTDT").value = data.maCTDT;
            document.getElementById("editTenCTDT").value = data.tenCTDT;
            document.getElementById("editBacDaoTao").value = data.bacDaoTao;
            document.getElementById("editLoaiBang").value = data.loaiBang;
            document.getElementById("editLoaiHinhDaoTao").value = data.loaiHinhDaoTao;
            document.getElementById("editThoiGian").value = data.thoiGianDaoTao;
            document.getElementById("editTinChiToiThieu").value = data.tinChiToiThieu;
            document.getElementById("editKhoaQuanLy").value = data.khoaQuanLy;
            document.getElementById("editNgonNgu").value = data.ngonNgu;
            document.getElementById("editWebsite").value = data.website;
            if(data.trangThai === 1 || data.trangThai === 0){
                document.getElementById("editTrangThaiTT").value = data.trangThai;
            }
            document.getElementById("editBanHanh").value = data.banHanh;
            
            var myModal = new bootstrap.Modal(document.getElementById('modalSuaTT'));
            myModal.show();
        })
        .catch(error => {
            console.log("Lỗi khi lấy dữ liệu thông tin đào tạo:", error);
            alert("Không thể tải dữ liệu để sửa!");
        });
}

function capNhatThongTinChung(event){
    event.preventDefault();
    
    const id = document.getElementById("suaIDCtDT").value;
    const maCTDT = document.getElementById("editMaCTDT").value;
    const tenCTDT = document.getElementById("editTenCTDT").value;
    const bacDaoTao = document.getElementById("editBacDaoTao").value;
    const loaiBang = document.getElementById("editLoaiBang").value;
    const loaiHinhDaoTao = document.getElementById("editLoaiHinhDaoTao").value;
    const thoiGianDaoTao = document.getElementById("editThoiGian").value;
    const tinChiToiThieu = document.getElementById("editTinChiToiThieu").value;
    const khoaQuanLy = document.getElementById("editKhoaQuanLy").value;
    const ngonNgu = document.getElementById("editNgonNgu").value;
    const website = document.getElementById("editWebsite").value;
    const trangThai = document.getElementById("editTrangThaiTT").value;
    const banHanh = document.getElementById("editBanHanh").value;
    
    if (thoiGianDaoTao < 1) {
        alert("Thời gian đào tạo phải lớn hơn hoặc bằng 1!");
        return;
    }

    if (tinChiToiThieu < 1) {
        alert("Số tín chỉ phải lớn hơn hoặc bằng 1!");
        return;
    }
    
    const ctdtData = {
        id: id,
        maCTDT: maCTDT,
        tenCTDT: tenCTDT,
        bacDaoTao: bacDaoTao,
        loaiBang: loaiBang,
        loaiHinhDaoTao: loaiHinhDaoTao,
        thoiGianDaoTao: thoiGianDaoTao,
        tinChiToiThieu: tinChiToiThieu,
        khoaQuanLy: khoaQuanLy,
        ngonNgu: ngonNgu,
        website: website,
        trangThai: trangThai,
        banHanh: banHanh
    };
    
    fetch(`/thongtinchung/sua/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(ctdtData)
    })
    .then(response => {
        if(!response.ok){
            throw new Error("Cập nhật thông tin đào tạo không thành công!");
        }
        return response.json();
    })
    .then(data => {
        console.log("Cập nhật thông tin đào tạo thành công!", data);
        alert("Cập nhật thông tin đào tạo thành công!");
        
        var myModal = new bootstrap.Modal(document.getElementById('modalSuaTT'));
        myModal.hide();
        
        location.reload();
    })
    .catch(error => {
        console.error("Lỗi khi cập nhật thông tin đào tạo:", error);
        alert("Lỗi khi cập nhật thông tin đào tạo!");
    });
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Tuong Vy Ha
 */
@Controller
public class index {

//    @GetMapping("/dangnhap")
//    public String dangNhap() {
//        return "dang_nhap";
//    }
    
//    @GetMapping("/dangky")
//    public String dangKy() {
//        return "dang_ky";
//    }
    
    @GetMapping("/home")
    public String home() {
        return "index"; // templates/index.html
    }
    
//    @GetMapping("/thongtinchung")
//    public String thongTinChung() {
//        return "ctdt_thongtinchung";
//    }
    
//    @GetMapping("/khungchuongtrinh")
//    public String khungChuongTrinh() {
//        return "ctdt_khungchuongtrinh";
//    }
    
//    @GetMapping("/khoikienthuc")
//    public String khoiKienThuc() {
//        return "ctdt_khoikienthuc";
//    }
    
//    @GetMapping("/hocphan")
//    public String hocPhan() {
//        return "ctdt_hocphan";
//    }
    
//    @GetMapping("/decuongchitiet")
//    public String deCuongChiTiet() {
//        return "ctdt_decuongchitiet";
//    }
    
//    @GetMapping("/cotdiem")
//    public String quanLyCotDiem() {
//        return "ctdt_cotdiem";
//    }
    
//    @GetMapping("/kehoachdayhoc")
//    public String keHoachDayHoc() {
//        return "ctdt_kehoachdayhoc";
//    }
    
//    @GetMapping("/kehoachmonhom")
//    public String keHoachMoNhom() {
//        return "ctdt_kehoachmonhom";
//    }
    
//    @GetMapping("/phanconggiangday")
//    public String phanCongGiangDay() {
//        return "ctdt_phanconggiangday";
//    }
    
//    @GetMapping("/nguoidung")
//    public String quanLyNguoiDung() {
//        return "ctdt_user";
//    }
    
//    @GetMapping("/giangvien")
//    public String giangVien() {
//        return "ctdt_giangvien";
//    }
}


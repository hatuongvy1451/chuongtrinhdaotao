/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

/**
 *
 * @author Tuong Vy Ha
 */
import com.mycompany.chuongtrinhdaotao.model.user;
import com.mycompany.chuongtrinhdaotao.service.dang_nhap_Service;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class dang_nhap_Controller {

    @Autowired
    private dang_nhap_Service dangNhapService;

    // Trang đăng nhập
    @GetMapping("/dangnhap")
    public String hienThiTrangDangNhap() {
        return "dang_nhap"; 
    }

    @PostMapping("/dangnhap")
    public String xuLyDangNhap(@RequestParam("tenDangNhap") String tenDangNhap,
                               @RequestParam("matKhau") String matKhau,
                               HttpSession session,
                               Model model) {
        user nd = dangNhapService.kiemTraDangNhap(tenDangNhap, matKhau);

        if (nd == null) {
            model.addAttribute("thongBaoLoi", "Tên đăng nhập hoặc mật khẩu không đúng!");
            model.addAttribute("tenDangNhap", tenDangNhap);
            model.addAttribute("matKhau", matKhau);
            return "dang_nhap";
        }

        if (nd.getTrangThai() == 0) {
            model.addAttribute("thongBaoLoi", "Tài khoản đã bị khóa! Vui lòng liên hệ quản trị viên.");
            model.addAttribute("tenDangNhap", tenDangNhap);
            model.addAttribute("matKhau", matKhau);
            return "dang_nhap";
        }

        // Nếu hợp lệ
        session.setAttribute("nguoiDungDangNhap", nd);

        if (nd.getVaiTro() == 0) {
            return "redirect:/home";
        } else {
            return "redirect:/home";
        }
    }
}


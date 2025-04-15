/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

/**
 *
 * @author Tuong Vy Ha
 */

import com.mycompany.chuongtrinhdaotao.model.cot_diem;
import com.mycompany.chuongtrinhdaotao.service.cot_diem_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class cot_diem_Controller {

    @Autowired
    private cot_diem_Service cotDiemService;

    // Phương thức để hiển thị dữ liệu cột điểm lên giao diện
    @GetMapping("/cotdiem")
    public String getCotDiemList(Model model) {
        List<cot_diem> cotDiems = cotDiemService.getAllCotDiem();
        // Đưa dữ liệu vào model để hiển thị trên giao diện
        model.addAttribute("cotDiems", cotDiems);
        return "ctdt_cotdiem"; // Trả về tên view (html) để hiển thị
    }
}


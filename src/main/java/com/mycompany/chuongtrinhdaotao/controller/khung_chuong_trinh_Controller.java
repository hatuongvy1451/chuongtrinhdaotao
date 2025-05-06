/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.khung_chuong_trinh;
import com.mycompany.chuongtrinhdaotao.service.khung_chuong_trinh_Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Thu Huyen
 */
@Controller
public class khung_chuong_trinh_Controller {
    
    @Autowired
    private khung_chuong_trinh_Service khungChuongTrinhService;
    
    //hiển thị danh sách khung chương trình
    @GetMapping("/khungchuongtrinh")
    public String getAllKhungChuongTrinh(Model model){
        List<khung_chuong_trinh> khungChuongTrinh = khungChuongTrinhService.getAllKhungChuongTrinh();
        model.addAttribute("khungChuongTrinhs", khungChuongTrinh);
        return "ctdt_khungchuongtrinh";
    } 
}
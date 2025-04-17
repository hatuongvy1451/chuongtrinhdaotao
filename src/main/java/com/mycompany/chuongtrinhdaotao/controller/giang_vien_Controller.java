/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.giang_vien;
import com.mycompany.chuongtrinhdaotao.service.giang_vien_Service;
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
public class giang_vien_Controller {
    
    @Autowired
    private giang_vien_Service gvService;
    
    //Hiển thị danh sách giảng viên
    @GetMapping("/giangvien")
    public String getAllGiangVien(Model model){
        List<giang_vien> giangvien = gvService.getAllGiangVien();
        //hiển thị lên giao diện
        model.addAttribute("giangvien", giangvien);
        //trả về tên view
        return "ctdt_giangvien";
    }
    
}

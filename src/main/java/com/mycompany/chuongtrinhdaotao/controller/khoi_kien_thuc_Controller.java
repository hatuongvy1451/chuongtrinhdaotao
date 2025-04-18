/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.khoi_kien_thuc;
import com.mycompany.chuongtrinhdaotao.service.khoi_kien_thuc_Service;
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
public class khoi_kien_thuc_Controller {
    
    @Autowired
    private khoi_kien_thuc_Service khoiKienThucService;
    
    @GetMapping("/khoikienthuc")
    public String getAllKhoiKienThuc(Model model){
        List<khoi_kien_thuc> khoiKienThucList = khoiKienThucService.getAllKhoiKienThuc();
        model.addAttribute("khoiKienThucList", khoiKienThucList);
        return "ctdt_khoikienthuc";
    }
    
    
}

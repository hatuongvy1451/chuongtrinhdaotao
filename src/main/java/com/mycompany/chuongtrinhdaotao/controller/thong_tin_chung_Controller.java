/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.thong_tin_chung;
import com.mycompany.chuongtrinhdaotao.service.thong_tin_chung_Service;
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
public class thong_tin_chung_Controller {
    @Autowired
    private thong_tin_chung_Service thongTinChungService;
    
    @GetMapping("/thongtinchung")
    public String getAllThongTinChung(Model model){
        List<thong_tin_chung> thongTinChungList = thongTinChungService.getAllThongTinChung();
        model.addAttribute("thongTinChungList", thongTinChungList);
        return "ctdt_thongtinchung";
    }
    
    
}

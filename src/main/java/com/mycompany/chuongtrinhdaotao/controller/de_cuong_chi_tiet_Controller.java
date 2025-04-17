/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.de_cuong_chi_tiet;
import com.mycompany.chuongtrinhdaotao.service.de_cuong_chi_tiet_Service;
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
public class de_cuong_chi_tiet_Controller {
    @Autowired
    private de_cuong_chi_tiet_Service deCuongChiTietService;
    
    //hiển thị cột đề cương chi tiết lên giao diện 
    @GetMapping("/decuongchitiet")
    public String getAllDeCuongChiTiet(Model model){
        List<de_cuong_chi_tiet> decuongList = deCuongChiTietService.getAllDeCuongChiTiet();
        //đưa dữ liện lên giao diện
        model.addAttribute("decuongList", decuongList);
        return "ctdt_decuongchitiet";   
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import com.mycompany.chuongtrinhdaotao.service.hoc_phan_Service;
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
public class hoc_phan_Controller {
    
    @Autowired
    private hoc_phan_Service hocPhanService;
    
    @GetMapping("/hocphan")
    public String getAllHocPhan(Model model){
        List<hoc_phan> hocPhanList = hocPhanService.getAllHocPhan();
        model.addAttribute("hocPhanList", hocPhanList);
        return "ctdt_hocphan";
    }
    
    
}

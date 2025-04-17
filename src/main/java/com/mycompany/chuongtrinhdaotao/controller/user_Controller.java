/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.user;
import com.mycompany.chuongtrinhdaotao.service.user_Service;
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
public class user_Controller {
    @Autowired
    private user_Service userService;
    
    //    hiển thị dữ liệu cột user để hiển thị lên giao diện
    @GetMapping("/nguoidung")
    public String getAllUser(Model model){
        List<user> users = userService.getAllUser();
        //đưa dữ liệu vào model để hiển thị lên giao diện 
        model.addAttribute("users", users);
        return "ctdt_user";
    }
    
    
}

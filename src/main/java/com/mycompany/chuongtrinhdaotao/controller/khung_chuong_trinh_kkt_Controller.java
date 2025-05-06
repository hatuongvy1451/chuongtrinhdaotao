/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.service.khung_chuong_trinh_kkt_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Thu Huyen
 */
@Controller
public class khung_chuong_trinh_kkt_Controller {
    @Autowired
    private khung_chuong_trinh_kkt_Service khungChuongTrinhKKTService;
}

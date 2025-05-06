/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.phan_cong_giang_day;
import com.mycompany.chuongtrinhdaotao.service.phan_cong_giang_day_Service;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Tuong Vy Ha
 */

@Controller
public class phan_cong_giang_day_Controller {
    
    @Autowired
    private phan_cong_giang_day_Service pngdService;
    
    @GetMapping("/phanconggiangday")
    public String getPhanCongGiangDayList(Model model){
        List<phan_cong_giang_day> phanCongGiangDay = pngdService.getAllPhanCongGiangDay();
        model.addAttribute("phanCongGiangDay", phanCongGiangDay);
        return "ctdt_phanconggiangday";
    }
    
    @GetMapping("/phanconggiangday/{id}")
    public ResponseEntity<phan_cong_giang_day> getPhanCongGiangDayById(@PathVariable int id) {
        phan_cong_giang_day pcgd = pngdService.findById(id); 
        if (pcgd != null) {
            return ResponseEntity.ok(pcgd); 
        }
        return ResponseEntity.notFound().build();  
    }
    
    @DeleteMapping("/phanconggiangday/xoa/{id}")
    public ResponseEntity<Map<String, String>> deletePhanCongGiangDayById(@PathVariable int id){
        boolean isDeleted = pngdService.deletePhanCongGiangDayById(id);
        
        if(!isDeleted){
            return new ResponseEntity<>(Map.of("message", "Phân công giảng dạy không tồn tại!"), HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(Map.of("message", "Xóa phân công giảng dạy thành công!"), HttpStatus.OK);
    }
    
    @PutMapping("/phanconggiangday/sua/{id}")
    public ResponseEntity<phan_cong_giang_day> updatePhanCongGiangDayById(@PathVariable int id, @RequestBody phan_cong_giang_day updated) {
        phan_cong_giang_day pcgd = pngdService.updatePhanCongGiangDayById(id, updated);
        if (pcgd != null) {
            return ResponseEntity.ok(pcgd);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/phanconggiangday/nhom-da-phancong")
    public ResponseEntity<List<Long>> layDanhSachIdNhomDaPhanCong() {
        List<Long> idNhomDaPhanCong = pngdService.layTatCaIdNhomDaPhanCong();
        return ResponseEntity.ok(idNhomDaPhanCong);
    }
    
    @PostMapping("/phanconggiangday/them")
    public ResponseEntity<phan_cong_giang_day> themPhanCongGiangDay(@RequestBody phan_cong_giang_day pcgd){
        phan_cong_giang_day saved = pngdService.themPhanCongGiangDay(pcgd);
        return ResponseEntity.ok(saved);
    }
}
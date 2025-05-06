/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.khoi_kien_thuc;
import com.mycompany.chuongtrinhdaotao.service.khoi_kien_thuc_Service;
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
    
    @GetMapping("/xemhocphantheokhoi")
    public String getKhoiKienThuc(Model model) {
        List<khoi_kien_thuc> danhSachKhoiKienThuc = khoiKienThucService.getAllKhoiKienThuc();
        model.addAttribute("khoiKienThuc", danhSachKhoiKienThuc);
        return "ctdt_XemHPTheoKhoi";
    }
    
    @GetMapping("/khoikienthuc/{id}")
    public ResponseEntity<khoi_kien_thuc> getKhoiKienThucById(@PathVariable int id) {
        khoi_kien_thuc khoiKienThuc = khoiKienThucService.findById(id); 
        if (khoiKienThuc != null) {
            return ResponseEntity.ok(khoiKienThuc); 
        }
        return ResponseEntity.notFound().build();  
    }
    
    @DeleteMapping("/khoikienthuc/xoa/{id}")
    public ResponseEntity<Map<String, String>> deleteKhoiKienThucById(@PathVariable int id){
        boolean isDeleted = khoiKienThucService.deleteKhoiKienThucById(id);
        
        if(!isDeleted){
            return new ResponseEntity<>(Map.of("message", "Khối kiến thức không tồn tại!"), HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(Map.of("message", "Xóa khối kiến thức thành công!"), HttpStatus.OK);
    }
    
    @PutMapping("/khoikienthuc/sua/{id}")
    public ResponseEntity<khoi_kien_thuc> updateKhoiKienThucById(@PathVariable int id, @RequestBody khoi_kien_thuc updated) {
        khoi_kien_thuc khoiKienThuc = khoiKienThucService.updateKhoiKienThucById(id, updated);
        if (khoiKienThuc != null) {
            return ResponseEntity.ok(khoiKienThuc);
        }
        return ResponseEntity.notFound().build();
    }
    
    //Thêm
    @PostMapping("/khoikienthuc/them")
    public ResponseEntity<khoi_kien_thuc> addKhoiKienThuc(@RequestBody khoi_kien_thuc khoiKienThuc){
        khoi_kien_thuc saved = khoiKienThucService.addKhoiKiênThuc(khoiKienThuc);
        return ResponseEntity.ok(saved);  
    }
}
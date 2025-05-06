/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.thong_tin_chung;
import com.mycompany.chuongtrinhdaotao.service.thong_tin_chung_Service;
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
public class thong_tin_chung_Controller {
    @Autowired
    private thong_tin_chung_Service thongTinChungService;
    
    @GetMapping("/thongtinchung")
    public String getAllThongTinChung(Model model){
        List<thong_tin_chung> thongTinChungList = thongTinChungService.getAllThongTinChung();
        model.addAttribute("thongTinChungList", thongTinChungList);
        return "ctdt_thongtinchung";
    }
    
    @GetMapping("/thongtinchung/trangthai")
    public ResponseEntity<List<thong_tin_chung>> getActiveCTDT() {
        List<thong_tin_chung> list = thongTinChungService.getAllActive(); 
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/thongtinchung/xoa/{id}")
    public ResponseEntity<Map<String, String>> deleteThongTinChungById(@PathVariable int id){
        boolean isDeleted = thongTinChungService.deleteThongTinChungById(id);
        
        if(!isDeleted){
            return new ResponseEntity<>(Map.of("message", "Thông tin CTĐT không tồn tại!"), HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(Map.of("message", "Xóa thông tin CTĐT thành công!"), HttpStatus.OK);
    }
    
    // Xem chi tiết
    @GetMapping("/thongtinchung/xem/{id}")
    public ResponseEntity<thong_tin_chung> getThongTinChungById(@PathVariable int id) {
        thong_tin_chung ctdt = thongTinChungService.getThongTinChungById(id); 
        if (ctdt != null) {
            return ResponseEntity.ok(ctdt); 
        }
        return ResponseEntity.notFound().build();  
    }
    
    @PutMapping("/thongtinchung/sua/{id}")
    public ResponseEntity<thong_tin_chung> updateThongTinChungById(@PathVariable int id, @RequestBody thong_tin_chung updated) {
        thong_tin_chung ctdt = thongTinChungService.updateHocPhanById(id, updated);
        if (ctdt != null) {
            return ResponseEntity.ok(ctdt);
        }
        return ResponseEntity.notFound().build();
    }
    
     //Thêm
    @PostMapping("/thongtinchung/them")
    public ResponseEntity<thong_tin_chung> addChuongTrinhDaoTao(@RequestBody thong_tin_chung thongTinChung){
        thong_tin_chung saved = thongTinChungService.addChuongTrinhDaoTao(thongTinChung);
        return ResponseEntity.ok(saved);
    }
}
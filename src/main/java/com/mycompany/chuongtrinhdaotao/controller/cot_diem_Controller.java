/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

/**
 *
 * @author Tuong Vy Ha
 */

import com.mycompany.chuongtrinhdaotao.model.cot_diem;
import com.mycompany.chuongtrinhdaotao.model.de_cuong_chi_tiet;
import com.mycompany.chuongtrinhdaotao.service.cot_diem_Service;
import com.mycompany.chuongtrinhdaotao.service.de_cuong_chi_tiet_Service;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class cot_diem_Controller {

    @Autowired
    private cot_diem_Service cotDiemService;
    
    @Autowired 
    private de_cuong_chi_tiet_Service deCuongChiTietService;

    // Phương thức để hiển thị dữ liệu cột điểm lên giao diện
    @GetMapping("/cotdiem")
    public String getCotDiemList(Model model) {
        List<cot_diem> cotDiems = cotDiemService.getAllCotDiem();
        List<de_cuong_chi_tiet> deCuongChiTiets = deCuongChiTietService.getAllDeCuongChiTiet();
        // Đưa dữ liệu vào model để hiển thị trên giao diện
        model.addAttribute("cotDiems", cotDiems);
        model.addAttribute("deCuongChiTiets", deCuongChiTiets);
        return "ctdt_cotdiem"; // Trả về tên view (html) để hiển thị
    }
    
    @GetMapping("/cotdiem/{id}")
    public ResponseEntity<cot_diem> getCotDiemById(@PathVariable int id) {
        cot_diem cotDiem = cotDiemService.findById(id); 
        if (cotDiem != null) {
            return ResponseEntity.ok(cotDiem); 
        }
        return ResponseEntity.notFound().build();  
    }
    
    @GetMapping("/cotdiem/tong-ty-le")
    public ResponseEntity<Double> getTongTyLe(@RequestParam int dcctId) {
        double tong = cotDiemService.tongTyLeIDDCCT(dcctId);
        return ResponseEntity.ok(tong);
    }
    
    @GetMapping("/cotdiem/kiem-tra-ten")
    public ResponseEntity<Map<String, Boolean>> checkTenCotDiem(@RequestParam int dcctId, @RequestParam String tenCotDiem) {
        boolean exists = cotDiemService.checkTenCotDiem(dcctId, tenCotDiem);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/cotdiem/loc-theo-dcct/{dcctId}")
    public ResponseEntity<List<cot_diem>> getCotDiemTheoDeCuong(@PathVariable int dcctId) {
        List<cot_diem> dsCotDiem = cotDiemService.findByDeCuongChiTietId(dcctId);
        return ResponseEntity.ok(dsCotDiem);
    }
    
    @DeleteMapping("/cotdiem/xoa/{id}")
    public ResponseEntity<Map<String, String>> deleteCotDiemById(@PathVariable int id){
        boolean isDeleted = cotDiemService.deleteCotDiemById(id);
        
        if(!isDeleted){
            return new ResponseEntity<>(Map.of("message", "Cột điểm không tồn tại!"), HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(Map.of("message", "Xóa cột điểm thành công!"), HttpStatus.OK);
    }
    
    @PutMapping("/cotdiem/sua/{id}")
    public ResponseEntity<cot_diem> updateCotDiemById(@PathVariable int id, @RequestBody cot_diem updated) {
        cot_diem cotDiem = cotDiemService.updateCotDiemById(id, updated);
        if (cotDiem != null) {
            return ResponseEntity.ok(cotDiem);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("cotdiem/them")
    public ResponseEntity<cot_diem> addCotDiem(@RequestBody cot_diem cotDiem){
        cot_diem saved = cotDiemService.addCotDiem(cotDiem);
        return ResponseEntity.ok(saved);
    }
}

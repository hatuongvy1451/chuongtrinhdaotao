/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import com.mycompany.chuongtrinhdaotao.model.ke_hoach_day_hoc;
import com.mycompany.chuongtrinhdaotao.service.ke_hoach_day_hoc_Service;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tuong Vy Ha
 */

@Controller
public class ke_hoach_day_hoc_Controller {
    
    @Autowired
    private ke_hoach_day_hoc_Service khdhService;
    
    @GetMapping("/kehoachdayhoc")
    public String getKeHoachDayHocList(Model model){
        List<ke_hoach_day_hoc> keHoachDayHoc = khdhService.getAllKeHoachDayHoc();
        model.addAttribute("keHoachDayHoc", keHoachDayHoc);
        return "ctdt_kehoachdayhoc";
    }
    
    @GetMapping("/kehoachdayhoc/{id}")
    public ResponseEntity<ke_hoach_day_hoc> getKeHoachDayHocById(@PathVariable int id) {
        ke_hoach_day_hoc khdh = khdhService.findById(id); 
        if (khdh != null) {
            return ResponseEntity.ok(khdh); 
        }
        return ResponseEntity.notFound().build();  
    }
    
    @GetMapping("/kehoachdayhoc/by-hocphan")
    public ResponseEntity<List<ke_hoach_day_hoc>> getKHDHByHocPhan(@RequestParam int hocPhanId) {
        return ResponseEntity.ok(khdhService.getKeHoachByHocPhan(hocPhanId));
    }
    
    @GetMapping("/kehoachdayhoc/nam-hoc-hoc-ky")
    public ResponseEntity<List<Object[]>> getNamHocHocKy(@RequestParam("hocPhanId") int hocPhanId) {
        List<Object[]> result = khdhService.findNamHocHocKyByHocPhanId(hocPhanId);
        return ResponseEntity.ok(result);
    }
 
    // Xóa kế hoạch dạy học theo ID
    @DeleteMapping("/kehoachdayhoc/xoa/{id}")
    public ResponseEntity<Map<String, String>> deleteKeHoachDayHocById(@PathVariable int id) {
        // Gọi service để xóa kế hoạch dạy học
        boolean isDeleted = khdhService.deleteKeHoachDayHocById(id);

        if (!isDeleted) {
            return new ResponseEntity<>(Map.of("message", "Kế hoạch dạy học không tồn tại!"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(Map.of("message", "Xóa kế hoạch dạy học thành công!"), HttpStatus.OK);
    }
    
    @PutMapping("/kehoachdayhoc/sua/{id}")
    public ResponseEntity<ke_hoach_day_hoc> updateKeHoachDayHocById(@PathVariable int id, @RequestBody ke_hoach_day_hoc updated) {
        ke_hoach_day_hoc khdh = khdhService.updateKeHoachDayHocById(id, updated);
        if (khdh != null) {
            return ResponseEntity.ok(khdh);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/xemhocphantunghocky")
    public String xemHPTungHocKy(Model model) {
        List<Integer> danhSachHocKy = khdhService.getHocKyKhongTrung();
        model.addAttribute("hocKyList", danhSachHocKy);
        return "ctdt_XemHPTungHocKy";
    }
    
    @PostMapping("/kehoachdayhoc/them")
    public ResponseEntity<ke_hoach_day_hoc> themKeHoachDayHoc(@RequestBody ke_hoach_day_hoc khdh){
        ke_hoach_day_hoc saved = khdhService.themKeHoachDayHoc(khdh);
        return ResponseEntity.ok(saved);
    }
    
    @GetMapping("/kehoachdayhoc/hocphan")
    public ResponseEntity<List<hoc_phan>> getHocPhanTheoKeHoach() {
        List<hoc_phan> hocPhanList = khdhService.findHocPhanDuocMo();
        return ResponseEntity.ok(hocPhanList);
    }
}

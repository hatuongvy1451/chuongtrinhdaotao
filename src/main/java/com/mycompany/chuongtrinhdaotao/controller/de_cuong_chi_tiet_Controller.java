/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.de_cuong_chi_tiet;
import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import com.mycompany.chuongtrinhdaotao.service.de_cuong_chi_tiet_Service;
import com.mycompany.chuongtrinhdaotao.service.hoc_phan_Service;
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
public class de_cuong_chi_tiet_Controller {
    @Autowired
    private de_cuong_chi_tiet_Service deCuongChiTietService;
    
    @Autowired
    private hoc_phan_Service hocPhanService;
    
    //hiển thị cột đề cương chi tiết lên giao diện 
    @GetMapping("/decuongchitiet")
    public String getAllDeCuongChiTiet(Model model){
        List<de_cuong_chi_tiet> decuongList = deCuongChiTietService.getAllDeCuongChiTiet();
        //đưa dữ liện lên giao diện
        model.addAttribute("decuongList", decuongList);
        List<hoc_phan> hocPhanList = hocPhanService.getAllHocPhan();
        model.addAttribute("hocPhanList", hocPhanList);
        return "ctdt_decuongchitiet";   
    }
    
    // Xem chi tiết
    @GetMapping("/decuongchitiet/xem/{id}")
    public ResponseEntity<de_cuong_chi_tiet> getDeCuongChiTietById(@PathVariable int id) {
        de_cuong_chi_tiet ctdt = deCuongChiTietService.getDeCuongChiTietById(id); 
        if (ctdt != null) {
            return ResponseEntity.ok(ctdt); 
        }
        return ResponseEntity.notFound().build();  
    }
    
    @DeleteMapping("/decuongchitiet/xoa/{id}")
    public ResponseEntity<Map<String, String>> deleteDeCuongChiTietById(@PathVariable int id){
        boolean isDeleted = deCuongChiTietService.deleteDeCuongChiTietById(id);
        
        if(!isDeleted){
            return new ResponseEntity<>(Map.of("message", "Đề cương chi tiết không tồn tại!"), HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(Map.of("message", "Xóa đề cương chi tiết thành công!"), HttpStatus.OK);
    }
    
    @PutMapping("/decuongchitiet/sua/{id}")
    public ResponseEntity<de_cuong_chi_tiet> updateDeCuongChiTietById(@PathVariable int id, @RequestBody de_cuong_chi_tiet updated) {
        de_cuong_chi_tiet dcct = deCuongChiTietService.updateDeCuongChiTietById(id, updated);
        if (dcct != null) {
            return ResponseEntity.ok(dcct);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/decuongchitiet/them")
    public ResponseEntity<de_cuong_chi_tiet> addDeCuongChiTiet(@RequestBody de_cuong_chi_tiet deCuongChiTiet){
        de_cuong_chi_tiet saved = deCuongChiTietService.addDeCuongChiTiet(deCuongChiTiet);
        return ResponseEntity.ok(saved);
    }
    
    
}
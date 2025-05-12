/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import com.mycompany.chuongtrinhdaotao.model.ke_hoach_mo_nhom;
import com.mycompany.chuongtrinhdaotao.service.ke_hoach_mo_nhom_Service;
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
public class ke_hoach_mo_nhom_Controller {
    
    @Autowired
    private ke_hoach_mo_nhom_Service keHoachMoNhomService;
    
    @GetMapping("/kehoachmonhom")
    public String getKeHoachMoNhomList(Model model){
        List<ke_hoach_mo_nhom> keHoachMoNhom = keHoachMoNhomService.getAllKeHoachMoNhom();
        model.addAttribute("keHoachMoNhom", keHoachMoNhom);
        return "ctdt_kehoachmonhom";
    }
    
    @GetMapping("/kehoachmonhom/{id}")
    public ResponseEntity<ke_hoach_mo_nhom> getKeHoachMoNhomById(@PathVariable int id){
        ke_hoach_mo_nhom khmn = keHoachMoNhomService.findById(id);
        if(khmn != null){
            return ResponseEntity.ok(khmn);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/kehoachmonhom/hocphan/{id}")
    public ResponseEntity<hoc_phan> getHocPhanByIdNhom(@PathVariable int id) {
        ke_hoach_mo_nhom khmn = keHoachMoNhomService.findById(id);
        if (khmn != null && khmn.getHocPhan() != null) {
            return ResponseEntity.ok(khmn.getHocPhan());
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/kehoachmonhom/trangthai")
    public ResponseEntity<List<ke_hoach_mo_nhom>> getActiveNhom() {
        List<ke_hoach_mo_nhom> list = keHoachMoNhomService.getAllActive(); 
        return ResponseEntity.ok(list);
    }
    
    @DeleteMapping("/kehoachmonhom/xoa/{id}")
    public ResponseEntity<Map<String, String>> deleteKeHoachMoNhomById(@PathVariable int id){
        boolean isDeleted = keHoachMoNhomService.deleteKeHoachMoNhomById(id);
        
        if(!isDeleted){
            return new ResponseEntity<>(Map.of("message", "Kế hoạch mở nhóm không tồn tại!"), HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(Map.of("message", "Xóa kế hoạch mở nhóm thành công!"), HttpStatus.OK);
    }
    
    @PutMapping("/kehoachmonhom/sua/{id}")
    public ResponseEntity<ke_hoach_mo_nhom> updateKeHoachMoNhomById(@PathVariable int id, @RequestBody ke_hoach_mo_nhom updated){
        ke_hoach_mo_nhom khmn = keHoachMoNhomService.updateKeHoachMoNhomById(id, updated);
        if(khmn != null){
            return ResponseEntity.ok(khmn);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/kehoachmonhom/them")
    public ResponseEntity<ke_hoach_mo_nhom> themKeHoachMoNhom(@RequestBody ke_hoach_mo_nhom khmn){
        ke_hoach_mo_nhom saved = keHoachMoNhomService.themKeHoachMoNhom(khmn);
        return ResponseEntity.ok(saved);
    }
}

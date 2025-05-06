/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import com.mycompany.chuongtrinhdaotao.model.khung_chuong_trinh;
import com.mycompany.chuongtrinhdaotao.service.hoc_phan_Service;
import com.mycompany.chuongtrinhdaotao.service.khung_chuong_trinh_Service;
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
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Thu Huyen
 */
@Controller
public class hoc_phan_Controller {
    
    @Autowired
    private hoc_phan_Service hocPhanService;
    
    @Autowired
    private khung_chuong_trinh_Service khungChuongTrinhService;
    
    @GetMapping("/hocphan")
    public String getAllHocPhan(Model model){
        List<hoc_phan> hocPhanList = hocPhanService.getAllHocPhan();
        model.addAttribute("hocPhanList", hocPhanList);
        List<khung_chuong_trinh> khungChuongTrinh = khungChuongTrinhService.getAllKhungChuongTrinh();
        model.addAttribute("khungChuongTrinhs", khungChuongTrinh);
        return "ctdt_hocphan";
    }
    
    @GetMapping("/hocphan/ctdt/{id}")
    public ResponseEntity<List<hoc_phan>> getHocPhanByCtdt(@PathVariable("id") int idCtdt) {
        List<hoc_phan> list = hocPhanService.layHocPhanTheoCtdt(idCtdt);
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/hocphan/trangthai")
    public ResponseEntity<List<hoc_phan>> getHocPhanByTrangThai() {
        List<hoc_phan> list = hocPhanService.getHocPhanByTrangThai(); 
        return ResponseEntity.ok(list);
    }
    
    @DeleteMapping("/hocphan/xoa/{id}")
    public ResponseEntity<Map<String, String>> deleteHocPhanById(@PathVariable int id){
        boolean isDeleted = hocPhanService.deleteHocPhanById(id);
        
        if(!isDeleted){
            return new ResponseEntity<>(Map.of("message", "Học phần không tồn tại!"), HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(Map.of("message", "Xóa học phần thành công!"), HttpStatus.OK);
    }
    
    @GetMapping("/xemhocphantunghocky/{hocKyThucHien}")
    @ResponseBody
    public List<hoc_phan> getHocPhanByHocKy(@PathVariable int hocKyThucHien) {
        List<hoc_phan> hocPhanList = hocPhanService.findHocPhanByHocKy(hocKyThucHien);
        return hocPhanList;
    }
    
    @GetMapping("/hocphan/{id}")
    public ResponseEntity<hoc_phan> getHocPhanById(@PathVariable int id) {
        hoc_phan hocPhan = hocPhanService.getHocPhanById(id); 
        if (hocPhan != null) {
            return ResponseEntity.ok(hocPhan); 
        }
        return ResponseEntity.notFound().build();  
    }
    
    @PutMapping("/hocphan/sua/{id}")
    public ResponseEntity<hoc_phan> updateHocPhanById(@PathVariable int id, @RequestBody hoc_phan updated) {
        hoc_phan hocPhan = hocPhanService.updateHocPhanById(id, updated);
        if (hocPhan != null) {
            return ResponseEntity.ok(hocPhan);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/hocphan/them")
    public ResponseEntity<hoc_phan> addHocPhan(@RequestBody hoc_phan hocPhan){
        hoc_phan saved = hocPhanService.addHocPhan(hocPhan);
        return ResponseEntity.ok(saved);
    }
    
    @GetMapping("/xemhocphantheokhoi/{idKhoiKT}")
    @ResponseBody
    public List<hoc_phan> getHocPhanByIdKhoiKienThuc(@PathVariable int idKhoiKT) {
        return hocPhanService.getHocPhanByIdKhoiKienThuc(idKhoiKT);
    }
}
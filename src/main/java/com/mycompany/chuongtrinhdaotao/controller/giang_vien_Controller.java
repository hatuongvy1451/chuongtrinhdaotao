/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.excel.Export_GiangVien;
import com.mycompany.chuongtrinhdaotao.model.giang_vien;
import com.mycompany.chuongtrinhdaotao.model.user;
import com.mycompany.chuongtrinhdaotao.service.giang_vien_Service;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Thu Huyen
 */
@Controller
public class giang_vien_Controller {
    
    @Autowired
    private giang_vien_Service gvService;
    
    //Hiển thị danh sách giảng viên
    @GetMapping("/giangvien")
    public String getAllGiangVien(Model model){
        List<giang_vien> giangvien = gvService.getAllGiangVien();
        //hiển thị lên giao diện
        model.addAttribute("giangvien", giangvien);
        //trả về tên view
        return "ctdt_giangvien";
    }
    
    @GetMapping("/giangvien/{id}")
    public ResponseEntity<giang_vien> getGiangVienById(@PathVariable int id) {
        giang_vien giangVien = gvService.findById(id); 
        if (giangVien != null) {
            return ResponseEntity.ok(giangVien); 
        }
        return ResponseEntity.notFound().build();  
    }
    
    @GetMapping("/giangvien/trangthai")
    public ResponseEntity<List<giang_vien>> getActiveGiangVien() {
        List<giang_vien> list = gvService.getAllActive(); 
        return ResponseEntity.ok(list);
    }
    
    @DeleteMapping("/giangvien/xoa/{id}")
    public ResponseEntity<Map<String, String>> deleteGiangVienById(@PathVariable int id){
        boolean isDeleted = gvService.deleteGiangVienById(id);
        
        if(!isDeleted){
            return new ResponseEntity<>(Map.of("message", "Giảng viên không tồn tại!"), HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(Map.of("message", "Xóa giảng viên thành công!"), HttpStatus.OK);
    }
    
    @PutMapping("/giangvien/sua/{id}")
    public ResponseEntity<?> updateGiangVienById(@PathVariable int id, @RequestBody giang_vien updated) {
        try {
            giang_vien giangVien = gvService.updateGiangVienById(id, updated);
            if (giangVien != null) {
                return ResponseEntity.ok(giangVien);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy giảng viên!");
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi!");
        }
    }
    
    @PostMapping("/giangvien/captaikhoan/{id}")
    public ResponseEntity<?> capTaiKhoanGiangVien(@PathVariable int id, @RequestBody user updated){
        try {
            user createdUser = gvService.capTaiKhoanGiangVien(id, updated);

            if (createdUser != null) {
                return ResponseEntity.ok(createdUser);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy giảng viên!");
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage()); 
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi!");
        }
    }
    
    @GetMapping("/giangvien/export")
    public ResponseEntity<InputStreamResource> exportGiangVienToExcel() throws IOException {
        List<giang_vien> list = gvService.getAllGiangVien();

        ByteArrayInputStream in = Export_GiangVien.exportToExcel(list);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=giangvien.xlsx");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(in));
    }
    
    @PostMapping("/giangvien/import")
    public String saveFileData(@RequestParam("file") MultipartFile file,
                           RedirectAttributes redirectAttributes) throws IOException{
         gvService.saveFileData(file.getInputStream());
         redirectAttributes.addFlashAttribute("message", "Nhập giảng viên thành công!");
        return "redirect:/giangvien";
    }
    
    @PostMapping("/giangvien/them")
    public ResponseEntity<giang_vien> themGiangVien(@RequestBody giang_vien giangVien ){
        giang_vien saved = gvService.themGiangVien(giangVien);
        return ResponseEntity.ok(saved);
    }
}
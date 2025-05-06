/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.user;
import com.mycompany.chuongtrinhdaotao.service.user_Service;
import jakarta.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Thu Huyen
 */
@Controller
public class user_Controller {
    @Autowired
    private user_Service userService;
    
    //    hiển thị dữ liệu cột user để hiển thị lên giao diện
    @GetMapping("/nguoidung")
    public String getAllUser(Model model){
        List<user> users = userService.getAllUser();
        //đưa dữ liệu vào model để hiển thị lên giao diện 
        model.addAttribute("users", users);
        return "ctdt_user";
    }
    
    @GetMapping("/nguoidung/{id}")
    public ResponseEntity<user> getNguoiDungById(@PathVariable int id) {
        user nguoiDung = userService.findById(id); 
        if (nguoiDung != null) {
            return ResponseEntity.ok(nguoiDung); 
        }
        return ResponseEntity.notFound().build();  
    }
    
    @PostMapping("/capnhat-thongtin")
    public String capNhatThongTinCaNhan(@RequestParam("tenDN") String tenDangNhap,
                                         @RequestParam("hoTen") String hoTen,
                                         @RequestParam("emailTT") String email,
                                         HttpSession session,
                                         @RequestHeader(value = "Referer", required = false) String referer) {

        user nd = (user) session.getAttribute("nguoiDungDangNhap");

        if (nd != null && nd.getTenDangNhap().equals(tenDangNhap)) {
            nd.setHoTen(hoTen);
            nd.setEmail(email);

            userService.capNhatThongTin(nd);
            session.setAttribute("nguoiDungDangNhap", nd);
        }

        // Quay lại trang trước hoặc fallback về /home nếu không có Referer
        return "redirect:" + (referer != null ? referer : "/home");
    }
    
    @DeleteMapping("/nguoidung/xoa/{id}")
    public ResponseEntity<Map<String, String>> deleteNguoiDungById(@PathVariable int id){
        boolean isDeleted = userService.deleteNguoiDungById(id);
        
        if(!isDeleted){
            return new ResponseEntity<>(Map.of("message", "Người dùng không tồn tại!"), HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(Map.of("message", "Xóa người dùng thành công!"), HttpStatus.OK);
    }
    
    @PutMapping("/nguoidung/sua/{id}")
    public ResponseEntity<?> updateNguoiDungById(@PathVariable int id, @RequestBody user updated) {
        try {
            user updatedUser = userService.updateNguoiDungById(id, updated);
            if (updatedUser != null) {
                return ResponseEntity.ok(updatedUser);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy người dùng!");
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage()); // "Email đã tồn tại!"
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi!");
        }
    }
    
    @PostMapping("/nguoidung/them")
    public ResponseEntity<user> addNguoiDung(@RequestBody user User){
        user saved = userService.addUser(User);
        return ResponseEntity.ok(saved);
    }
}
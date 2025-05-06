/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.giang_vien;
import com.mycompany.chuongtrinhdaotao.model.user;
import com.mycompany.chuongtrinhdaotao.repository.giang_vien_Repository;
import com.mycompany.chuongtrinhdaotao.repository.user_Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thu Huyen
 */
@Service
public class user_Service {
    
    @Autowired
    private user_Repository userRepository;
    
    @Autowired
    private giang_vien_Repository giangVienRepository;
    
    //get all Data
    public List<user> getAllUser(){
        return userRepository.findAll();
    }
    
    public void capNhatThongTin(user nd) {
        userRepository.save(nd); 
    }

    public boolean deleteNguoiDungById(int id) {
        Optional<user> optional = userRepository.findById(id);

        if (optional.isPresent()) {
            user nguoiDung = optional.get();

            // Tìm giảng viên liên kết với tài khoản này
            giang_vien giangVien = giangVienRepository.findByIdTaiKhoan(id);

            if (nguoiDung.getTrangThai() == 1) {
                nguoiDung.setTrangThai(0);
                userRepository.save(nguoiDung);
            } else {
                if (giangVien != null) {
                    giangVien.setIdTaiKhoan(null);
                    giangVienRepository.save(giangVien);
                }
                
                userRepository.deleteById(id);
            }

            return true;
        }

        return false;
    }
    
    public user findById(int id){
        return userRepository.findById(id).orElse(null);
    }
    
   public user updateNguoiDungById(int id, user updated) {
        Optional<user> existingUser = userRepository.findByEmail(updated.getEmail());
        if (existingUser.isPresent() && existingUser.get().getId() != id) {
            throw new IllegalArgumentException("Email đã tồn tại!");
        }

        Optional<user> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            user current = optional.get();
            // Cập nhật các thuộc tính
            current.setHoTen(updated.getHoTen());
            current.setEmail(updated.getEmail());
            current.setMatKhau(updated.getMatKhau());
            current.setVaiTro(updated.getVaiTro());
            current.setTrangThai(updated.getTrangThai());
            return userRepository.save(current);
        }
        return null;
    }
   
    public user addUser(user us){
        return userRepository.save(us);
    }
}
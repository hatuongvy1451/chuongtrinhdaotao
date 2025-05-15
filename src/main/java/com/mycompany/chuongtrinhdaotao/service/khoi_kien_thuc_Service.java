/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.khoi_kien_thuc;
import com.mycompany.chuongtrinhdaotao.repository.khoi_kien_thuc_Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Thu Huyen
 */
@Service
public class khoi_kien_thuc_Service {
    @Autowired
    private khoi_kien_thuc_Repository khoiKienKhucRepository;
    
    //get All data
    public List<khoi_kien_thuc> getAllKhoiKienThuc(){
        return khoiKienKhucRepository.findAll();
    }
    
    public khoi_kien_thuc findById(int id) {
        return khoiKienKhucRepository.findById(id).orElse(null);
    }
    
    public boolean deleteKhoiKienThucById(int id){
        Optional<khoi_kien_thuc> optional = khoiKienKhucRepository.findById(id);
        
        if(optional.isPresent()){
            khoi_kien_thuc khoiKienThuc = optional.get();
            
            if(khoiKienThuc.getTrangThai() == 1){
                khoiKienThuc.setTrangThai(0);
                khoiKienKhucRepository.save(khoiKienThuc);
            } else {
                khoiKienKhucRepository.deleteById(id);
            }
            
            return true;
        }
        return false;
    }
    
    public khoi_kien_thuc updateKhoiKienThucById(int id, khoi_kien_thuc updated) {
        Optional<khoi_kien_thuc> optional = khoiKienKhucRepository.findById(id);
        if (optional.isPresent()) {
            khoi_kien_thuc current = optional.get();
            // Cập nhật các thuộc tính
            current.setMaKhoi(updated.getMaKhoi());
            current.setTenKhoi(updated.getTenKhoi());
            current.setTrangThai(updated.getTrangThai());
            return khoiKienKhucRepository.save(current);
        }
        return null;
    }
    
    //Thêm
    public khoi_kien_thuc addKhoiKienThuc(khoi_kien_thuc khoiKienThuc) {
        if (khoiKienKhucRepository.existsByMaKhoi(khoiKienThuc.getMaKhoi())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mã khối kiến thức đã tồn tại!");
        }
        return khoiKienKhucRepository.save(khoiKienThuc);
    }
    
    public boolean existsByMaKhoi(String maKhoi) {
        return khoiKienKhucRepository.existsByMaKhoi(maKhoi);
    }
}

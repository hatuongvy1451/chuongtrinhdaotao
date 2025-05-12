/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

/**
 *
 * @author Tuong Vy Ha
 */

import com.mycompany.chuongtrinhdaotao.model.cot_diem;
import com.mycompany.chuongtrinhdaotao.repository.cot_diem_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cot_diem_Service {

    @Autowired
    private cot_diem_Repository cotDiemRepository;

    public List<cot_diem> getAllCotDiem() {
        return cotDiemRepository.findAll(); // Lấy tất cả cột điểm từ cơ sở dữ liệu
    }
    
    public boolean deleteCotDiemById(int id){
        Optional<cot_diem> optional = cotDiemRepository.findById(id);
        
        if(optional.isPresent()){
            cotDiemRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public cot_diem findById(int id) {
        return cotDiemRepository.findById(id).orElse(null);
    }
    
    public cot_diem updateCotDiemById(int id, cot_diem updated) {
        Optional<cot_diem> optional = cotDiemRepository.findById(id);
        if (optional.isPresent()) {
            cot_diem current = optional.get();
            // Cập nhật các thuộc tính
            current.setTenCotDiem(updated.getTenCotDiem());
            current.setTyLePhanTram(updated.getTyLePhanTram());
            current.setHinhThuc(updated.getHinhThuc());
            return cotDiemRepository.save(current);
        }
        return null;
    }
    
    public cot_diem addCotDiem(cot_diem cotDiem){
        return cotDiemRepository.save(cotDiem);
    }
    
    public double tongTyLeIDDCCT(int dcctId) {
        return cotDiemRepository.tongTyLeByDcctId(dcctId);
    }
    
    public boolean checkTenCotDiem(int dcctId, String tenCotDiem) {
        return cotDiemRepository.existsByDcct_IdAndTenCotDiem(dcctId, tenCotDiem);
    }
    
    public List<cot_diem> findByDeCuongChiTietId(int dcctId) {
        return cotDiemRepository.findByDcct_Id(dcctId);
    }
}

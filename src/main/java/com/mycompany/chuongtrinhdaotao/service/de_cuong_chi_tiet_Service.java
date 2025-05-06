/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.de_cuong_chi_tiet;
import com.mycompany.chuongtrinhdaotao.repository.de_cuong_chi_tiet_Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thu Huyen
 */
@Service
public class de_cuong_chi_tiet_Service {
    
    @Autowired
    private de_cuong_chi_tiet_Repository deCuongChiTietRepository;
    
    public List<de_cuong_chi_tiet> getAllDeCuongChiTiet(){
        return deCuongChiTietRepository.findAll();
    } 
    
    public de_cuong_chi_tiet getDeCuongChiTietById(int id){
        return deCuongChiTietRepository.findById(id).orElse(null);
    }
    
    public boolean deleteDeCuongChiTietById(int id){
        Optional<de_cuong_chi_tiet> optional = deCuongChiTietRepository.findById(id);
        
        if(optional.isPresent()){
            de_cuong_chi_tiet dcct = optional.get();
            
            if(dcct.getTrangThai() == 1){
                dcct.setTrangThai(0);
                deCuongChiTietRepository.save(dcct);
            } else {
                deCuongChiTietRepository.deleteById(id);
            }
            
            return true;
        }
        return false;
    }
    
    public de_cuong_chi_tiet updateDeCuongChiTietById(int id, de_cuong_chi_tiet updated) {
        Optional<de_cuong_chi_tiet> optional = deCuongChiTietRepository.findById(id);
        if (optional.isPresent()) {
            de_cuong_chi_tiet current = optional.get();
            // Cập nhật các thuộc tính
            current.setMoTa(updated.getMoTa());
            current.setMucTieu(updated.getMucTieu());
            current.setChuongNoiDung(updated.getChuongNoiDung());
            current.setPhuongPhapDanhGia(updated.getPhuongPhapDanhGia());
            current.setPhuongPhapGiangDay(updated.getPhuongPhapGiangDay());
            current.setTaiLieuThamKhao(updated.getTaiLieuThamKhao());
            current.setTrangThai(updated.getTrangThai());
            return deCuongChiTietRepository.save(current);
        }
        return null;
    }
    
    public de_cuong_chi_tiet addDeCuongChiTiet(de_cuong_chi_tiet deCuongChiTiet){
        return deCuongChiTietRepository.save(deCuongChiTiet);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.phan_cong_giang_day;
import com.mycompany.chuongtrinhdaotao.repository.phan_cong_giang_day_Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tuong Vy Ha
 */

@Service
public class phan_cong_giang_day_Service {
    
    @Autowired 
    private phan_cong_giang_day_Repository pcgdRepository;
    
    public List<phan_cong_giang_day> getAllPhanCongGiangDay(){
        return pcgdRepository.findAll();
    }
    
    public phan_cong_giang_day findById(int id) {
        return pcgdRepository.findById(id).orElse(null);
    }
    
    public boolean deletePhanCongGiangDayById(int id){
        Optional<phan_cong_giang_day> optional = pcgdRepository.findById(id);
        
        if(optional.isPresent()){
            phan_cong_giang_day phanCong = optional.get();
            
            if(phanCong.getTrangThai()==1){
                phanCong.setTrangThai(0);
                pcgdRepository.save(phanCong);
            } else {
                pcgdRepository.deleteById(id);
            }
            
            return true;
        }
        
        return false;
    }
    
    public phan_cong_giang_day updatePhanCongGiangDayById(int id, phan_cong_giang_day updated) {
        Optional<phan_cong_giang_day> optional = pcgdRepository.findById(id);
        if (optional.isPresent()) {
            phan_cong_giang_day current = optional.get();
            // Cập nhật các thuộc tính
            current.setSoTietThucHien(updated.getSoTietThucHien());
            current.setSoTietThucTe(updated.getSoTietThucTe());
            current.setTrangThai(updated.getTrangThai());
            return pcgdRepository.save(current);
        }
        return null;
    }
    
    public phan_cong_giang_day themPhanCongGiangDay(phan_cong_giang_day pcgd){
        return pcgdRepository.save(pcgd);
    }
    
    public List<Long> layTatCaIdNhomDaPhanCong() {
        return pcgdRepository.findAllIdNhomDaPhanCong();
    }
}

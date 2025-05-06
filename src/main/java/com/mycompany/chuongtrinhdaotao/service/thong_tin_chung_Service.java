/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.ke_hoach_day_hoc;
import com.mycompany.chuongtrinhdaotao.model.thong_tin_chung;
import com.mycompany.chuongtrinhdaotao.repository.ke_hoach_day_hoc_Repository;
import com.mycompany.chuongtrinhdaotao.repository.thong_tin_chung_Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thu Huyen
 */
@Service
public class thong_tin_chung_Service {
    
    @Autowired
    private thong_tin_chung_Repository thongTinChungRepository;
    
    @Autowired
    private ke_hoach_day_hoc_Repository khdhRepository;
    
    //load all data
    public List<thong_tin_chung> getAllThongTinChung(){
        return thongTinChungRepository.findAll();
    }
    
    public List<thong_tin_chung> getAllActive() {
        return thongTinChungRepository.findByTrangThai(1);
    }
    
    public boolean deleteThongTinChungById(int id){
        Optional<thong_tin_chung> optional = thongTinChungRepository.findById(id);
        
        if(optional.isPresent()){
            thong_tin_chung thongTin = optional.get();
            
            List<ke_hoach_day_hoc> khdhList = khdhRepository.findByCtdt(thongTin);
            
            if(thongTin.getTrangThai() == 1){
                thongTin.setTrangThai(0);
                thongTinChungRepository.save(thongTin);
                
                if(khdhList != null){
                    for (ke_hoach_day_hoc khdh : khdhList) {
                        khdh.setTrangThai(0);
                        khdhRepository.save(khdh);
                    }   
                }
            } else {
                thongTinChungRepository.deleteById(id);
            }
            
            return true;
        }
        
        return false;
    }
    
    public thong_tin_chung getThongTinChungById(int id) {
        return thongTinChungRepository.findById(id).orElse(null);
    }
    
    public thong_tin_chung updateHocPhanById(int id, thong_tin_chung updated) {
        Optional<thong_tin_chung> optional = thongTinChungRepository.findById(id);
        if (optional.isPresent()) {
            thong_tin_chung current = optional.get();
            
            int oldTrangThai = current.getTrangThai();
            
            // Cập nhật các thuộc tính
            current.setBacDaoTao(updated.getBacDaoTao());
            current.setBanHanh(updated.getBanHanh());
            current.setKhoaQuanLy(updated.getKhoaQuanLy());
            current.setLoaiBang(updated.getLoaiBang());
            current.setLoaiHinhDaoTao(updated.getLoaiHinhDaoTao());
            current.setNgonNgu(updated.getNgonNgu());
            current.setTenCTDT(updated.getTenCTDT());
            current.setThoiGianDaoTao(updated.getThoiGianDaoTao());
            current.setTinChiToiThieu(updated.getTinChiToiThieu());
            current.setWebsite(updated.getWebsite());
            current.setTrangThai(updated.getTrangThai());
            
            thong_tin_chung updatedCTDT = thongTinChungRepository.save(current);
            
            if(oldTrangThai != updated.getTrangThai()){
                List<ke_hoach_day_hoc> khdhList = khdhRepository.findByCtdt(current);
                
                for(ke_hoach_day_hoc khdh : khdhList){
                    if(khdh != null){
                        khdh.setTrangThai(updated.getTrangThai());
                        khdhRepository.save(khdh);
                    }
                }
            }
            
            return updatedCTDT;
        }
        return null;
    }
    
    public thong_tin_chung addChuongTrinhDaoTao(thong_tin_chung thongTinChung){
        return thongTinChungRepository.save(thongTinChung);
    }
}
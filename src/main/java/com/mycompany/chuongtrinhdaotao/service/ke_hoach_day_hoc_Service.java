/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import com.mycompany.chuongtrinhdaotao.model.ke_hoach_day_hoc;
import com.mycompany.chuongtrinhdaotao.repository.ke_hoach_day_hoc_Repository;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tuong Vy Ha
 */

@Service
public class ke_hoach_day_hoc_Service {
    
    @Autowired
    private ke_hoach_day_hoc_Repository keHoachDayHocRepository;
    
    public List<ke_hoach_day_hoc> getAllKeHoachDayHoc(){
        return keHoachDayHocRepository.findAll();
    }
    
    public ke_hoach_day_hoc findById(int id) {
        return keHoachDayHocRepository.findById(id).orElse(null);
    }
    
    public List<ke_hoach_day_hoc> getKeHoachByHocPhan(int hocPhanId) {
        return keHoachDayHocRepository.findKeHoachByHocPhanId(hocPhanId);
    }
    
    public List<Object[]> findNamHocHocKyByHocPhanId(int hocPhanId) {
        return keHoachDayHocRepository.findNamHocHocKyByHocPhanId(hocPhanId);
    }
  
    public boolean deleteKeHoachDayHocById(int id) {
        Optional<ke_hoach_day_hoc> optional = keHoachDayHocRepository.findById(id);

        if (optional.isPresent()) {
            ke_hoach_day_hoc keHoach = optional.get();

            if (keHoach.getTrangThai() == 1) {
                keHoach.setTrangThai(0); // đánh dấu đã xóa
                keHoachDayHocRepository.save(keHoach);
            } else {
                keHoachDayHocRepository.deleteById(id); // xóa vĩnh viễn
            }

            return true;
        }

        return false;
    }
    
    public ke_hoach_day_hoc updateKeHoachDayHocById(int id, ke_hoach_day_hoc updated) {
        Optional<ke_hoach_day_hoc> optional = keHoachDayHocRepository.findById(id);
        if (optional.isPresent()) {
            ke_hoach_day_hoc current = optional.get();
            // Cập nhật các thuộc tính
            current.setHocKyThucHien(updated.getHocKyThucHien());
            current.setNamHoc(updated.getNamHoc());
            current.setTrangThai(updated.getTrangThai());
            return keHoachDayHocRepository.save(current);
        }
        return null;
    }
    
   public List<Integer> getHocKyKhongTrung(){
       List<ke_hoach_day_hoc> keHoachList = keHoachDayHocRepository.findAll();
       Set<Integer> hocKySet = new LinkedHashSet<>();
       
       for(ke_hoach_day_hoc keHoach : keHoachList){
           int hocKy = keHoach.getHocKyThucHien(); 
           hocKySet.add(hocKy); 
       }
       
       return new ArrayList<>(hocKySet);
   }
   
    public ke_hoach_day_hoc themKeHoachDayHoc(ke_hoach_day_hoc khdh){
        return keHoachDayHocRepository.save(khdh);
    }
    
    public List<hoc_phan> findHocPhanDuocMo() {
        return keHoachDayHocRepository.findHocPhanDuocMo();
    }
}

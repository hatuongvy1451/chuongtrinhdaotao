/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.ke_hoach_mo_nhom;
import com.mycompany.chuongtrinhdaotao.model.phan_cong_giang_day;
import com.mycompany.chuongtrinhdaotao.repository.ke_hoach_mo_nhom_Repository;
import com.mycompany.chuongtrinhdaotao.repository.phan_cong_giang_day_Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Tuong Vy Ha
 */

@Service
public class ke_hoach_mo_nhom_Service {
    
    @Autowired
    private ke_hoach_mo_nhom_Repository keHoachMoNhomRepository;
    
    @Autowired
    private phan_cong_giang_day_Repository pcgdRepository;
    
    public List<ke_hoach_mo_nhom> getAllKeHoachMoNhom(){
        return keHoachMoNhomRepository.findAll();
    }
    
    public List<ke_hoach_mo_nhom> getAllActive() {
        return keHoachMoNhomRepository.findByTrangThai(1);
    }
    
    public ke_hoach_mo_nhom findById(int id){
        return keHoachMoNhomRepository.findById(id).orElse(null);
    }
    
    public boolean deleteKeHoachMoNhomById(int id) {
        Optional<ke_hoach_mo_nhom> optional = keHoachMoNhomRepository.findById(id);

        if (optional.isPresent()) {
            ke_hoach_mo_nhom keHoach = optional.get();

            phan_cong_giang_day pcgd = pcgdRepository.findByMoNhom_Id(id);

            if (keHoach.getTrangThai() == 1) {
                keHoach.setTrangThai(0);
                keHoachMoNhomRepository.save(keHoach);

                if(pcgd != null){
                    pcgd.setTrangThai(0);
                    pcgdRepository.save(pcgd);
                }

            } else {
                keHoachMoNhomRepository.deleteById(id); 
            }

            return true;
        }

        return false;
    }
    
    public ke_hoach_mo_nhom updateKeHoachMoNhomById(int id, ke_hoach_mo_nhom updated) {
        Optional<ke_hoach_mo_nhom> optional = keHoachMoNhomRepository.findById(id);

        if (optional.isPresent()) {
            ke_hoach_mo_nhom khmn = optional.get();

            // Lưu lại trạng thái cũ trước khi cập nhật
            int oldTrangThai = khmn.getTrangThai();

            khmn.setHocKy(updated.getHocKy());
            khmn.setSlSinhVien(updated.getSlSinhVien());
            khmn.setNamHoc(updated.getNamHoc());
            khmn.setThoiGianBatDau(updated.getThoiGianBatDau());
            khmn.setThoiGianKetThuc(updated.getThoiGianKetThuc());
            khmn.setTrangThai(updated.getTrangThai());

            ke_hoach_mo_nhom updatedKHMN = keHoachMoNhomRepository.save(khmn);

            if (oldTrangThai != updated.getTrangThai()) {
                phan_cong_giang_day pcgd = pcgdRepository.findByMoNhom_Id(id);

                if (pcgd != null) {
                    pcgd.setTrangThai(updated.getTrangThai());
                    pcgdRepository.save(pcgd);  
                }
            }

            return updatedKHMN;
        }
        return null;
    }
    
    public ke_hoach_mo_nhom addNhom(ke_hoach_mo_nhom moNhom) {
        if (keHoachMoNhomRepository.existsByMaNhom(moNhom.getMaNhom())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mã nhóm đã tồn tại!");
        }
        return keHoachMoNhomRepository.save(moNhom);
    }
    
    public boolean existsByMaNhom(String maNhom) {
        return keHoachMoNhomRepository.existsByMaNhom(maNhom);
    }
}

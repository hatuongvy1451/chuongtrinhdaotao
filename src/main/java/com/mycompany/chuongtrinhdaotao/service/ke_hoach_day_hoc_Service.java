/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import com.mycompany.chuongtrinhdaotao.model.ke_hoach_day_hoc;
import com.mycompany.chuongtrinhdaotao.model.ke_hoach_mo_nhom;
import com.mycompany.chuongtrinhdaotao.model.phan_cong_giang_day;
import com.mycompany.chuongtrinhdaotao.repository.ke_hoach_day_hoc_Repository;
import com.mycompany.chuongtrinhdaotao.repository.ke_hoach_mo_nhom_Repository;
import com.mycompany.chuongtrinhdaotao.repository.phan_cong_giang_day_Repository;
import com.mycompany.chuongtrinhdaotao.repository.thong_tin_chung_Repository;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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
    
    @Autowired
    private ke_hoach_mo_nhom_Repository keHoachMoNhomRepository;
    
    @Autowired
    private phan_cong_giang_day_Repository phanCongGiangDayRepository;
    
    @Autowired
    private thong_tin_chung_Repository ttchungRepo;
    
    
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
            hoc_phan hocPhan = keHoach.getHocPhan();

            // Tìm kế hoạch mở nhóm dựa vào học phần
            List<ke_hoach_mo_nhom> danhSachMoNhom = keHoachMoNhomRepository.findByHocPhan(hocPhan);

            if (keHoach.getTrangThai() == 1) {
                keHoach.setTrangThai(0);
                keHoachDayHocRepository.save(keHoach);

                for (ke_hoach_mo_nhom moNhom : danhSachMoNhom) {
                    moNhom.setTrangThai(0);
                    keHoachMoNhomRepository.save(moNhom);

                    // Cập nhật trạng thái phân công giảng dạy theo idNhom
                    phan_cong_giang_day pcgd = phanCongGiangDayRepository.findByMoNhom_Id(moNhom.getId());
                    if (pcgd != null) {
                        pcgd.setTrangThai(0);
                        phanCongGiangDayRepository.save(pcgd);
                    }
                }

            } else {
                keHoachDayHocRepository.deleteById(id);

                for (ke_hoach_mo_nhom moNhom : danhSachMoNhom) {
                    keHoachMoNhomRepository.delete(moNhom);

                    // Xóa luôn phân công giảng dạy tương ứng nếu cần
                    phan_cong_giang_day pcgd = phanCongGiangDayRepository.findByMoNhom_Id(moNhom.getId());
                    if (pcgd != null) {
                        pcgd.setTrangThai(0);
                        phanCongGiangDayRepository.delete(pcgd);
                    }
                }
            }

            return true;
        }

        return false;
    }
    
    public ke_hoach_day_hoc updateKeHoachDayHocById(int id, ke_hoach_day_hoc updated) {
        Optional<ke_hoach_day_hoc> optional = keHoachDayHocRepository.findById(id);
        if (optional.isPresent()) {
            ke_hoach_day_hoc current = optional.get();

            // Cập nhật thông tin kế hoạch dạy học
            current.setHocKyThucHien(updated.getHocKyThucHien());
            current.setNamHoc(updated.getNamHoc());
            current.setTrangThai(updated.getTrangThai());

            ke_hoach_day_hoc saved = keHoachDayHocRepository.save(current);

            // Cập nhật trạng thái các kế hoạch mở nhóm tương ứng (dựa theo học phần)
            hoc_phan hocPhan = current.getHocPhan();
            List<ke_hoach_mo_nhom> danhSachMoNhom = keHoachMoNhomRepository.findByHocPhan(hocPhan);
            for (ke_hoach_mo_nhom moNhom : danhSachMoNhom) {
                moNhom.setTrangThai(current.getTrangThai());
                keHoachMoNhomRepository.save(moNhom);
                phan_cong_giang_day pcgd = phanCongGiangDayRepository.findByMoNhom_Id(moNhom.getId());
                if (pcgd != null) {
                    pcgd.setTrangThai(current.getTrangThai());
                    phanCongGiangDayRepository.save(pcgd);
                }
            }

            return saved;
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
    
    public Map<Integer, String> getAllCurriculumNames() {

        List<Object[]> rawData = ttchungRepo.findAllIdAndTenCTDT();
        Map<Integer, String> result = new LinkedHashMap<>();
        for (Object[] row : rawData) {
            Integer id = (Integer) row[0];
            String name = (String) row[1];
            result.put(id, name);
        }
        return result;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.HocPhanDTO;
import com.mycompany.chuongtrinhdaotao.model.de_cuong_chi_tiet;
import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import com.mycompany.chuongtrinhdaotao.model.ke_hoach_day_hoc;
import com.mycompany.chuongtrinhdaotao.model.ke_hoach_mo_nhom;
import com.mycompany.chuongtrinhdaotao.repository.de_cuong_chi_tiet_Repository;
import com.mycompany.chuongtrinhdaotao.repository.hoc_phan_Repository;
import com.mycompany.chuongtrinhdaotao.repository.ke_hoach_day_hoc_Repository;
import com.mycompany.chuongtrinhdaotao.repository.ke_hoach_mo_nhom_Repository;
import com.mycompany.chuongtrinhdaotao.repository.thong_tin_chung_Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
public class hoc_phan_Service {
    
    @Autowired
    private hoc_phan_Repository hocPhanRepository;
    
    @Autowired
    private de_cuong_chi_tiet_Repository dcctRepository;
    
    @Autowired
    private ke_hoach_day_hoc_Repository khdhRepository;
    
    @Autowired
    private ke_hoach_mo_nhom_Repository khmnRepository;
    
    @Autowired
    private thong_tin_chung_Repository ttchungRepo;
    
    //get all data
    public List<hoc_phan> getAllHocPhan(){
        return hocPhanRepository.findAll();
    }
    
    public List<hoc_phan> getHocPhanByTrangThai(){
        return hocPhanRepository.findByTrangThai(1);
    }
    
    public boolean deleteHocPhanById(int id){
        Optional<hoc_phan> optional = hocPhanRepository.findById(id);
        
        if(optional.isPresent()){
            hoc_phan hocPhan = optional.get();
            
            List<de_cuong_chi_tiet> dcctList = dcctRepository.findByHocPhan(hocPhan);
            List<ke_hoach_day_hoc> khdhList = khdhRepository.findByHocPhan(hocPhan);
            List<ke_hoach_mo_nhom> khmnList = khmnRepository.findByHocPhan(hocPhan);
            
            if(hocPhan.getTrangThai() == 1){
                hocPhan.setTrangThai(0);
                hocPhanRepository.save(hocPhan);
                
                updateTrangThaiKhmn(khmnList);
                updateTrangThaiKhdh(khdhList);
                updateTrangThaiDcct(dcctList);
            } else {
                hocPhanRepository.deleteById(id);
            }
            
            return true;
        }
        return false;
    }
    
    private void updateTrangThaiKhmn(List<ke_hoach_mo_nhom> khmnList) {
        for (ke_hoach_mo_nhom khmn : khmnList) {
            if (khmn != null) {
                khmn.setTrangThai(0);
                khmnRepository.save(khmn);
            }
        }
    }

    private void updateTrangThaiKhdh(List<ke_hoach_day_hoc> khdhList) {
        for (ke_hoach_day_hoc khdh : khdhList) {
            if (khdh != null) {
                khdh.setTrangThai(0);
                khdhRepository.save(khdh);
            }
        }
    }

    private void updateTrangThaiDcct(List<de_cuong_chi_tiet> dcctList) {
        for (de_cuong_chi_tiet dcct : dcctList) {
            if (dcct != null) {
                dcct.setTrangThai(0);
                dcctRepository.save(dcct);
            }
        }
    }
    
    public List<hoc_phan> findHocPhanByHocKy(int hocKyThucHien) {
        return hocPhanRepository.findHocPhanByHocKy(hocKyThucHien);
    }
    
    public hoc_phan getHocPhanById(int id){
        return hocPhanRepository.findById(id).orElse(null);
    }
    
    public hoc_phan updateHocPhanById(int id, hoc_phan updated) {
        Optional<hoc_phan> optional = hocPhanRepository.findById(id);
        if (optional.isPresent()) {
            hoc_phan current = optional.get();
            
            int oldTrangThai = current.getTrangThai();
            
            // Cập nhật các thuộc tính
            current.setTenHocPhan(updated.getTenHocPhan());
            current.setHeSoHocPhan(updated.getHeSoHocPhan());
            current.setSoTietCong(updated.getSoTietCong());
            current.setSoTietLyThuyet(updated.getSoTietLyThuyet());
            current.setSoTietThucHanh(updated.getSoTietThucHanh());
            current.setSoTietThucTap(updated.getSoTietThucTap());
            current.setSoTinChi(updated.getSoTinChi());
            current.setTrangThai(updated.getTrangThai());
            
            hoc_phan updatedHocPhan = hocPhanRepository.save(current);
            
            if(oldTrangThai != updated.getTrangThai()){
                List<ke_hoach_day_hoc> khdhList = khdhRepository.findByHocPhan(current);
                for (ke_hoach_day_hoc khdh : khdhList) {
                    if(khdh != null){
                        khdh.setTrangThai(updated.getTrangThai());
                        khdhRepository.save(khdh);
                    }
                }
                
                List<ke_hoach_mo_nhom> khmnList = khmnRepository.findByHocPhan(current);
                for (ke_hoach_mo_nhom khmn : khmnList) {
                    if(khmn != null){
                        khmn.setTrangThai(updated.getTrangThai());
                        khmnRepository.save(khmn);
                    }
                }
                
                List<de_cuong_chi_tiet> dcctList = dcctRepository.findByHocPhan(current);
                for (de_cuong_chi_tiet dcct : dcctList) {
                    if(dcct != null){
                        dcct.setTrangThai(updated.getTrangThai());
                        dcctRepository.save(dcct);
                    }
                }
            }
            
            return updatedHocPhan;
        }
        return null;
    }
    
    public List<hoc_phan> layHocPhanTheoCtdt(int idThongTin) {
        return hocPhanRepository.findHocPhanByCtdtViaKhungCT(idThongTin);
    }
    
    public hoc_phan themHocPhan(hoc_phan hocPhan) {
        if (hocPhanRepository.existsByMaHocPhan(hocPhan.getMaHocPhan())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mã học phần đã tồn tại!");
        }
        return hocPhanRepository.save(hocPhan);
    }
    
    public boolean existsByMaHocPhan(String maHocPhan) {
        return hocPhanRepository.existsByMaHocPhan(maHocPhan);
    }
    
    public List<hoc_phan> getHocPhanByIdKhoiKienThuc(int idKhoiKT) {
        return hocPhanRepository.getHocPhanByIdKhoiKienThuc(idKhoiKT);
    }
    
    public List<HocPhanDTO> getHocPhanByCTDT(int ctdtId) {
        return hocPhanRepository.findHocPhanByCTDTGroupedByKhoi(ctdtId);
    }
    public Map<Integer, Map<String, List<Map<String, Object>>>> getAllHocPhanTheoKhoiVoiHocKy() {
        // Get all curriculum IDs
        List<String> idCTDTList = getAllIdCTDT();

        // Result map: key = idCTDT, value = hocPhanTheoKhoi structure
        Map<Integer, Map<String, List<Map<String, Object>>>> result = new LinkedHashMap<>();

        for (String idCTDTStr : idCTDTList) {
            try {
                int idCTDT = Integer.parseInt(idCTDTStr);
                // Get data for each curriculum
                Map<String, List<Map<String, Object>>> hocPhanData = getHocPhanTheoKhoiVoiHocKy(idCTDT);
                result.put(idCTDT, hocPhanData);
            } catch (NumberFormatException e) {
                // Handle case where idCTDT is not a valid integer
                System.err.println("Invalid idCTDT format: " + idCTDTStr);
            }
        }

        return result;
    }

    public Map<String, List<Map<String, Object>>> getHocPhanTheoKhoiVoiHocKy(int idCTDT) {
        List<Object[]> results = hocPhanRepository.findHocPhanTheoKhoiVoiHocKy(idCTDT);

        Map<String, List<Map<String, Object>>> hocPhanTheoKhoi = new LinkedHashMap<>();

        for (Object[] row : results) {
            hoc_phan hp = (hoc_phan) row[0];
            String tenKhoi = (String) row[1];
            Integer hocKy = (Integer) row[2];

            Map<String, Object> hocPhanMap = hocPhanTheoKhoi.computeIfAbsent(tenKhoi, k -> new ArrayList<>())
                    .stream()
                    .filter(m -> m.get("maHocPhan").equals(hp.getMaHocPhan()))
                    .findFirst()
                    .orElseGet(() -> {
                        Map<String, Object> newMap = new HashMap<>();
                        // Include ALL required fields
                        newMap.put("id", hp.getId());
                        newMap.put("maHocPhan", hp.getMaHocPhan());
                        newMap.put("tenHocPhan", hp.getTenHocPhan());
                        newMap.put("soTinChi", hp.getSoTinChi());
                        newMap.put("soTietLyThuyet", hp.getSoTietLyThuyet());
                        newMap.put("soTietCong", hp.getSoTietCong());
                        newMap.put("soTietThucHanh", hp.getSoTietThucHanh());
                        newMap.put("soTietThucTap", hp.getSoTietThucTap());
                        newMap.put("heSoHocPhan", hp.getHeSoHocPhan());
                        newMap.put("maHPTruoc", hp.getMaHPTruoc());

                        // Initialize học kỳ
                        for (int i = 1; i <= 12; i++) {
                            newMap.put("hocKy" + i, false);
                        }
                        hocPhanTheoKhoi.get(tenKhoi).add(newMap);
                        return newMap;
                    });

            if (hocKy != null && hocKy >= 1 && hocKy <= 12) {
                hocPhanMap.put("hocKy" + hocKy, true);
            }
        }
        return hocPhanTheoKhoi;
    }
    
    public List<String> getAllIdCTDT() {
        return ttchungRepo.findAllId();
    }
}

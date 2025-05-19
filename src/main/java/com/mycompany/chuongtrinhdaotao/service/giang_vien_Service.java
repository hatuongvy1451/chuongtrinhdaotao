/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.giang_vien;
import com.mycompany.chuongtrinhdaotao.model.phan_cong_giang_day;
import com.mycompany.chuongtrinhdaotao.model.user;
import com.mycompany.chuongtrinhdaotao.repository.giang_vien_Repository;
import com.mycompany.chuongtrinhdaotao.repository.phan_cong_giang_day_Repository;
import com.mycompany.chuongtrinhdaotao.repository.user_Repository;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Thu Huyen
 */
@Service
public class giang_vien_Service {
    
    @Autowired
    private giang_vien_Repository gvRepository;
    
    @Autowired
    private user_Repository userRepository;
    
    @Autowired
    private phan_cong_giang_day_Repository pcgdRepository;
    
    //load hết danh sách 
    public List<giang_vien> getAllGiangVien(){
        return gvRepository.findAll();
    } 
    
    public List<giang_vien> getAllActive(){
        return gvRepository.findByTrangThai(1);
    }
    
    public giang_vien findById(int id){
        return gvRepository.findById(id).orElse(null);
    }
    
    public boolean deleteGiangVienById(int id){
        Optional<giang_vien> optional = gvRepository.findById(id);
        
        if(optional.isPresent()){
            giang_vien giangVien = optional.get();
            
            List<phan_cong_giang_day> pcgdList =  pcgdRepository.findByGiangVien(giangVien);
            
            if(giangVien.getTrangThai() == 1){
                giangVien.setTrangThai(0);
                gvRepository.save(giangVien);
                
                for(phan_cong_giang_day pcgd : pcgdList){
                    if(pcgd != null){
                        pcgd.setTrangThai(0);
                        pcgdRepository.save(pcgd);
                    }
                }
            } else {
                gvRepository.deleteById(id);
            }
            
            return true;
        }
        return false;
    }
    
    public giang_vien updateGiangVienById(int id, giang_vien updated) {
        Optional<giang_vien> optional = gvRepository.findById(id);
        if (optional.isPresent()) {
            giang_vien current = optional.get();
            
            giang_vien other = gvRepository.findByEmailGiangVien(updated.getEmailGiangVien());
            if (other != null && other.getId() != id) {
                throw new IllegalArgumentException("Email đã tồn tại!");
            }
            
            int oldTrangThai = current.getTrangThai();
            
            // Cập nhật các thuộc tính
            current.setTenGiangVien(updated.getTenGiangVien());
            current.setEmailGiangVien(updated.getEmailGiangVien());
            current.setChuyenMon(updated.getChuyenMon());
            current.setLoaiGiangVien(updated.getLoaiGiangVien());
            current.setTrangThai(updated.getTrangThai());
            
            giang_vien updatedGiangVien = gvRepository.save(current);
            
            if(oldTrangThai != updated.getTrangThai()){
                List<phan_cong_giang_day> phanCongList = pcgdRepository.findByGiangVien(current);
                for(phan_cong_giang_day phanCong : phanCongList){
                    phanCong.setTrangThai(updated.getTrangThai());
                    pcgdRepository.save(phanCong);
                }
            }
            
            return updatedGiangVien;
        }
        return null;
    }
    
    public user capTaiKhoanGiangVien(int id, user updatedUser) {
        Optional<giang_vien> giangVienOptional = gvRepository.findById(id);

        if (giangVienOptional.isPresent()) {
            Optional<user> existingUser = userRepository.findByTenDangNhap(updatedUser.getTenDangNhap());
            if (existingUser.isPresent()) {
                throw new IllegalArgumentException("Tên đăng nhập đã tồn tại!");
            }

            giang_vien giangVien = giangVienOptional.get();

            user newUser = new user();
            newUser.setTenDangNhap(updatedUser.getTenDangNhap());
            newUser.setMatKhau(updatedUser.getMatKhau());
            newUser.setHoTen(giangVien.getTenGiangVien());
            newUser.setEmail(giangVien.getEmailGiangVien());
            newUser.setVaiTro(1);
            newUser.setTrangThai(1);

            newUser = userRepository.save(newUser);
            giangVien.setIdTaiKhoan(newUser.getId());
            gvRepository.save(giangVien);

            return newUser;
        }

        return null;
    }
    
    public void saveFileData(InputStream file) throws IOException {
        List<giang_vien> giangVienList = new LinkedList<>();
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);

        sheet.forEach(row -> {
            if (row.getRowNum() != 0) {
                giang_vien GV = new giang_vien();

                Cell cellIdTaiKhoan = row.getCell(0);
                if (cellIdTaiKhoan != null && cellIdTaiKhoan.getCellType() == CellType.NUMERIC) {
                    GV.setIdTaiKhoan((int) cellIdTaiKhoan.getNumericCellValue());
                } else {
                    GV.setIdTaiKhoan(null);
                }

                GV.setMaGiangVien(getCellStringValue(row.getCell(1)));
                GV.setTenGiangVien(getCellStringValue(row.getCell(2)));
                GV.setEmailGiangVien(getCellStringValue(row.getCell(3)));
                GV.setChuyenMon(getCellStringValue(row.getCell(4)));

                String loai = getCellStringValue(row.getCell(5)).trim();
                GV.setLoaiGiangVien(loai.equalsIgnoreCase("Cơ hữu") ? 1 : 0);

                String trangThaiStr = getCellStringValue(row.getCell(6)).trim();
                GV.setTrangThai(trangThaiStr.equalsIgnoreCase("Đang làm việc") ? 1 : 0);

                if (!gvRepository.existsByMaGiangVien(GV.getMaGiangVien())) {
                    giangVienList.add(GV); // chỉ thêm nếu chưa tồn tại
                }
            }
        });

        gvRepository.saveAll(giangVienList);
    }

    // Hàm phụ trợ để lấy giá trị String an toàn
    private String getCellStringValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf((int) cell.getNumericCellValue()); // nếu là số nguyên
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            default -> "";
        };
    }
    
    public giang_vien addGiangVien(giang_vien giangVien) {
        if (gvRepository.existsByMaGiangVien(giangVien.getMaGiangVien())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Mã giảng viên đã tồn tại!");
        }
        return gvRepository.save(giangVien);
    }
    
    public boolean existsByMaGiangVien(String maGiangVien) {
        return gvRepository.existsByMaGiangVien(maGiangVien);
    }
}

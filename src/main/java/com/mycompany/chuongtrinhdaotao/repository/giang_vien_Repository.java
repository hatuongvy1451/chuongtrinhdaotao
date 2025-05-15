/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.repository;

import com.mycompany.chuongtrinhdaotao.model.giang_vien;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thu Huyen
 */
@Repository
public interface giang_vien_Repository extends JpaRepository<giang_vien, Integer>{
    giang_vien findByIdTaiKhoan(Integer idTaiKhoan);
    
    giang_vien findByEmailGiangVien(String email);
    
    List<giang_vien> findByTrangThai(int trangThai);
    
    boolean existsByMaGiangVien(String maGiangVien);
}

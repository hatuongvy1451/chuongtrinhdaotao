/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.repository;

import com.mycompany.chuongtrinhdaotao.model.giang_vien;
import com.mycompany.chuongtrinhdaotao.model.phan_cong_giang_day;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tuong Vy Ha
 */

@Repository
public interface phan_cong_giang_day_Repository extends JpaRepository<phan_cong_giang_day, Integer> {
    phan_cong_giang_day findByMoNhom_Id(int idNhom);
    
    List<phan_cong_giang_day> findByGiangVien(giang_vien giangVien);
    
    @Query("SELECT DISTINCT p.moNhom.id FROM phan_cong_giang_day p WHERE p.trangThai = 1")
    List<Long> findAllIdNhomDaPhanCong();
}

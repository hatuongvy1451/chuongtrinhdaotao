/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.repository;

import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mycompany.chuongtrinhdaotao.model.ke_hoach_day_hoc;
import com.mycompany.chuongtrinhdaotao.model.thong_tin_chung;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Tuong Vy Ha
 */

@Repository
public interface ke_hoach_day_hoc_Repository extends JpaRepository<ke_hoach_day_hoc, Integer> {
    List<ke_hoach_day_hoc> findByCtdt(thong_tin_chung ctdt);
    
    List<ke_hoach_day_hoc> findByHocPhan(hoc_phan hocPhan);
    
    @Query("SELECT khdh FROM ke_hoach_day_hoc khdh WHERE khdh.hocPhan.id = :hocPhanId")
    List<ke_hoach_day_hoc> findKeHoachByHocPhanId(@Param("hocPhanId") int hocPhanId);
    
    @Query("SELECT DISTINCT k.namHoc, k.hocKyThucHien FROM ke_hoach_day_hoc k WHERE k.hocPhan.id = :hocPhanId")
    List<Object[]> findNamHocHocKyByHocPhanId(@Param("hocPhanId") int hocPhanId);
    
    @Query("SELECT DISTINCT k.hocPhan FROM ke_hoach_day_hoc k WHERE k.trangThai = 1")
    List<hoc_phan> findHocPhanDuocMo();
}

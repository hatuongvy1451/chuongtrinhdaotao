/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.repository;

import com.mycompany.chuongtrinhdaotao.model.HocPhanDTO;
import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thu Huyen
 */
@Repository
public interface hoc_phan_Repository extends JpaRepository<hoc_phan, Integer>{
   @Query("SELECT k.hocPhan FROM ke_hoach_day_hoc k WHERE k.hocKyThucHien = :hocKyThucHien")
    List<hoc_phan> findHocPhanByHocKy(@Param("hocKyThucHien") int hocKyThucHien);
    
    @Query("""
        SELECT hp FROM hoc_phan hp 
        WHERE hp.khungChuongTrinh.id IN (
            SELECT kct.id FROM khung_chuong_trinh kct 
            WHERE kct.ctdt.id = :ctdtId
        )
        AND hp.trangThai = 1
    """)
    List<hoc_phan> findHocPhanByCtdtViaKhungCT(@Param("ctdtId") int ctdtId);
    
    List<hoc_phan> findByTrangThai(int trangThai);
    
    @Query("SELECT hp FROM hoc_phan hp " +
       "JOIN khung_chuong_trinh kct ON hp.khungChuongTrinh.id = kct.id " +
       "JOIN khung_chuong_trinh_kkt kkt ON kkt.idKhungCT.id = kct.id " +
       "WHERE kkt.idKhoiKT.id = :idKhoiKT")
    List<hoc_phan> getHocPhanByIdKhoiKienThuc(@Param("idKhoiKT") int idKhoiKT);
    
    @Query("""
    SELECT new com.mycompany.chuongtrinhdaotao.model.HocPhanDTO(
        hp.maHocPhan,
        hp.tenHocPhan,
        hp.soTinChi,
        hp.soTietLyThuyet,
        hp.soTietThucHanh,
        hp.soTietThucTap,
        hp.heSoHocPhan,
        kct.maKhoi,
        kct.tenKhoi
    )
    FROM hoc_phan hp
    JOIN hp.khungChuongTrinh kct
    JOIN kct.ctdt ctdt
    WHERE ctdt.id = :ctdtId
    ORDER BY kct.maKhoi ASC, hp.tenHocPhan ASC
    """)
     List<HocPhanDTO> findHocPhanByCTDTGroupedByKhoi(@Param("ctdtId") int ctdtId);


     @Query("SELECT hp, kct.tenKhoi, khdh.hocKyThucHien " +
             "FROM hoc_phan hp " +
             "JOIN hp.khungChuongTrinh kct " +
             "LEFT JOIN ke_hoach_day_hoc khdh ON khdh.hocPhan.id = hp.id " +
             "WHERE kct.ctdt.id = :idCTDT " +
             "ORDER BY kct.tenKhoi, hp.maHocPhan")
     List<Object[]> findHocPhanTheoKhoiVoiHocKy(@Param("idCTDT") int idCTDT);
}

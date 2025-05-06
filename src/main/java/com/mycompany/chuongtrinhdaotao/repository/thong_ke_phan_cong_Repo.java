package com.mycompany.chuongtrinhdaotao.repository;

import com.mycompany.chuongtrinhdaotao.model.thong_ke_phan_cong;
import com.mycompany.chuongtrinhdaotao.model.phan_cong_giang_day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface thong_ke_phan_cong_Repo extends JpaRepository<phan_cong_giang_day, Integer> {

    @Query("""
        SELECT new com.mycompany.chuongtrinhdaotao.model.thong_ke_phan_cong(
            gv.id, gv.maGiangVien, gv.tenGiangVien, gv.chuyenMon, gv.loaiGiangVien, gv.trangThai,
            hp.tenHocPhan, hp.maHocPhan, hp.soTinChi, hp.soTietCong,
            SUM(CASE WHEN nhom.hocKy = 1 THEN 1 ELSE 0 END),
            SUM(CASE WHEN nhom.hocKy = 2 THEN 1 ELSE 0 END),
            SUM(CASE WHEN nhom.hocKy = 3 THEN 1 ELSE 0 END),
            COUNT(DISTINCT nhom.id),
            SUM(pcg.soTietThucTe),
            SUM(hp.soTietCong) * COUNT(DISTINCT nhom.id)
        )
        FROM phan_cong_giang_day pcg
        JOIN pcg.giangVien gv
        JOIN pcg.moNhom nhom
        JOIN nhom.hocPhan hp
        WHERE gv.trangThai = 1 AND nhom.trangThai = 1 AND pcg.trangThai = 1
        GROUP BY gv.id, gv.maGiangVien, gv.tenGiangVien, gv.chuyenMon, gv.loaiGiangVien, gv.trangThai,
                 hp.id, hp.maHocPhan, hp.tenHocPhan, hp.soTinChi, hp.soTietCong
        ORDER BY gv.tenGiangVien, hp.tenHocPhan
    """)
    List<thong_ke_phan_cong> getThongKePhanCongChiTiet();
}
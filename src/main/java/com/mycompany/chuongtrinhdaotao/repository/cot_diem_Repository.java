/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.repository;

/**
 *
 * @author Tuong Vy Ha
 */

import com.mycompany.chuongtrinhdaotao.model.cot_diem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface cot_diem_Repository extends JpaRepository<cot_diem, Integer> {
    @Query("SELECT COALESCE(SUM(c.tyLePhanTram), 0) FROM cot_diem c WHERE c.dcct.id = :dcctId")
    double tongTyLeByDcctId(@Param("dcctId") int dcctId);
    
    boolean existsByDcct_IdAndTenCotDiem(int dcctId, String tenCotDiem);
    
    List<cot_diem> findByDcct_Id(int dcctId);
}


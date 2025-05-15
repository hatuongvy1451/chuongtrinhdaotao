/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.repository;

import com.mycompany.chuongtrinhdaotao.model.thong_tin_chung;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thu Huyen
 */
@Repository
public interface thong_tin_chung_Repository extends JpaRepository<thong_tin_chung, Integer> {
   List<thong_tin_chung> findByTrangThai(int trangThai);
   
   @Query("SELECT t.id FROM thong_tin_chung t")
   List<String> findAllId();

   @Query("SELECT t.tenCTDT FROM thong_tin_chung t")
   List<String> findAllTenCTDT();
   
   @Query("SELECT tt.id, tt.tenCTDT FROM thong_tin_chung tt")
   List<Object[]> findAllIdAndTenCTDT();
}

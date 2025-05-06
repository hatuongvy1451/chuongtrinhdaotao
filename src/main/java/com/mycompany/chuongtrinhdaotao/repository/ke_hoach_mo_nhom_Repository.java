/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.repository;

import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import com.mycompany.chuongtrinhdaotao.model.ke_hoach_mo_nhom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tuong Vy Ha
 */

@Repository
public interface ke_hoach_mo_nhom_Repository extends JpaRepository<ke_hoach_mo_nhom, Integer> {
    List<ke_hoach_mo_nhom> findByHocPhan(hoc_phan hocPhan);
    
    List<ke_hoach_mo_nhom> findByTrangThai(int trangThai);
}

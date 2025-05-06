/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.repository;

import com.mycompany.chuongtrinhdaotao.model.de_cuong_chi_tiet;
import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thu Huyen
 */
@Repository
public interface de_cuong_chi_tiet_Repository extends JpaRepository<de_cuong_chi_tiet, Integer>{
    List<de_cuong_chi_tiet> findByHocPhan(hoc_phan hocPhan);
}
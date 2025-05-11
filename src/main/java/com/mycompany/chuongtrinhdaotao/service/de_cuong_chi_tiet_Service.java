/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.de_cuong_chi_tiet;
import com.mycompany.chuongtrinhdaotao.repository.de_cuong_chi_tiet_Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thu Huyen
 */
@Service
public class de_cuong_chi_tiet_Service {
    
    @Autowired
    private de_cuong_chi_tiet_Repository deCuongChiTietRepository;
    
    public List<de_cuong_chi_tiet> getAllDeCuongChiTiet(){
        return deCuongChiTietRepository.findAll();
    } 
    
    public de_cuong_chi_tiet getDeCuongChiTietById(int id){
        return deCuongChiTietRepository.findById(id).orElse(null);
    }
}

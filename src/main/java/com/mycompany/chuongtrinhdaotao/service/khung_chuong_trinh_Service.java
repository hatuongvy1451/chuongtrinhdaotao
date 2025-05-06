/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.khung_chuong_trinh;
import com.mycompany.chuongtrinhdaotao.repository.khung_chuong_trinh_Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thu Huyen
 */
@Service
public class khung_chuong_trinh_Service {
    @Autowired
    private khung_chuong_trinh_Repository khungChuongTringRepository;
    
    //getAll
    public List<khung_chuong_trinh> getAllKhungChuongTrinh(){
        return khungChuongTringRepository.findAll();
    }
}
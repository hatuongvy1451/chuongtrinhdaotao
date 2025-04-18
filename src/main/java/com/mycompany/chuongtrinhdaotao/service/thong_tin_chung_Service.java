/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.thong_tin_chung;
import com.mycompany.chuongtrinhdaotao.repository.thong_tin_chung_Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thu Huyen
 */
@Service
public class thong_tin_chung_Service {
    
    @Autowired
    private thong_tin_chung_Repository thongTinChungRepository;
    
    //load all data
    public List<thong_tin_chung> getAllThongTinChung(){
        return thongTinChungRepository.findAll();
    }
    
    
}

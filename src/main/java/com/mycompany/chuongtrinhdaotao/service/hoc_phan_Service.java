/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.hoc_phan;
import com.mycompany.chuongtrinhdaotao.repository.hoc_phan_Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thu Huyen
 */
@Service
public class hoc_phan_Service {
    
    @Autowired
    private hoc_phan_Repository hocPhanRepository;
    
    //get all data
    public List<hoc_phan> getAllHocPhan(){
        return hocPhanRepository.findAll();
    }
    
    
}

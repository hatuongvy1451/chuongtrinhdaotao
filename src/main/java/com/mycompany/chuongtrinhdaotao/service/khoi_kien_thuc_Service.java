/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.khoi_kien_thuc;
import com.mycompany.chuongtrinhdaotao.repository.khoi_kien_thuc_Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thu Huyen
 */
@Service
public class khoi_kien_thuc_Service {
    @Autowired
    private khoi_kien_thuc_Repository khoiKienKhucRepository;
    
    //get All data
    public List<khoi_kien_thuc> getAllKhoiKienThuc(){
        return khoiKienKhucRepository.findAll();
    }
}

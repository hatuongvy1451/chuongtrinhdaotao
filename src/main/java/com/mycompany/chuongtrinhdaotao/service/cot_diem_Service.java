/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

/**
 *
 * @author Tuong Vy Ha
 */

import com.mycompany.chuongtrinhdaotao.model.cot_diem;
import com.mycompany.chuongtrinhdaotao.repository.cot_diem_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cot_diem_Service {

    @Autowired
    private cot_diem_Repository cotDiemRepository;

    public List<cot_diem> getAllCotDiem() {
        return cotDiemRepository.findAll(); // Lấy tất cả cột điểm từ cơ sở dữ liệu
    }
}


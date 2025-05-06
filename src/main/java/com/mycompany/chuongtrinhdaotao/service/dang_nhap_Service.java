/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.user;
import com.mycompany.chuongtrinhdaotao.repository.user_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tuong Vy Ha
 */
@Service
public class dang_nhap_Service {

    @Autowired
    private user_Repository userRepository;

    public user kiemTraDangNhap(String tenDangNhap, String matKhau) {
        return userRepository.findByTenDangNhapAndMatKhau(tenDangNhap, matKhau);
    }
}

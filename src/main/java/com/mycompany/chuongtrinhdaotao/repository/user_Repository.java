/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.repository;

import com.mycompany.chuongtrinhdaotao.model.user;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thu Huyen
 */
@Repository
public interface user_Repository  extends JpaRepository<user, Integer>{
    user findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
    
    Optional<user> findByTenDangNhap(String tenDangNhap);
    
    Optional<user> findByEmail(String email);
}
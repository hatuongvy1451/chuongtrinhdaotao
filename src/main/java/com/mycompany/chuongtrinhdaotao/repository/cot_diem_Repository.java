/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.repository;

/**
 *
 * @author Tuong Vy Ha
 */

import com.mycompany.chuongtrinhdaotao.model.cot_diem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cot_diem_Repository extends JpaRepository<cot_diem, Integer> {
    // Phương thức này được tự động tạo sẵn bởi JpaRepository
    // Không cần phải khai báo gì thêm
}


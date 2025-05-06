/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.model;

import jakarta.persistence.*;
/**
 *
 * @author Tuong Vy Ha
 */

@Entity
@Table(name = "ctdt_phanconggiangday")
public class phan_cong_giang_day {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_giangvien", referencedColumnName = "id", nullable = false)
    private giang_vien giangVien;
    
    @ManyToOne
    @JoinColumn(name = "id_nhom", referencedColumnName = "id", nullable = false)
    private ke_hoach_mo_nhom moNhom;
    
    @Column(name = "so_tiet_thuc_hien", nullable = false)
    private int soTietThucHien;
    
    @Column(name = "so_tiet_thuc_te", nullable = false)
    private int soTietThucTe;
    
    @Column(name = "trang_thai", nullable = false)
    private int trangThai;

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public giang_vien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(giang_vien giangVien) {
        this.giangVien = giangVien;
    }

    public ke_hoach_mo_nhom getMoNhom() {
        return moNhom;
    }

    public void setMoNhom(ke_hoach_mo_nhom moNhom) {
        this.moNhom = moNhom;
    }

    public int getSoTietThucHien() {
        return soTietThucHien;
    }

    public void setSoTietThucHien(int soTietThucHien) {
        this.soTietThucHien = soTietThucHien;
    }

    public int getSoTietThucTe() {
        return soTietThucTe;
    }

    public void setSoTietThucTe(int soTietThucTe) {
        this.soTietThucTe = soTietThucTe;
    }
    
    
}

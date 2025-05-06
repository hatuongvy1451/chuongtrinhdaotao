/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.model;

import jakarta.persistence.*;

/**
 *
 * @author Thu Huyen
 */

@Entity
@Table(name = "ctdt_giangvien")
public class giang_vien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "id_taikhoan", nullable = true)
    private Integer idTaiKhoan;
    
    @Column(name = "ma_giang_vien", nullable = false)
    private String maGiangVien;
    
    @Column(name = "ten_giang_vien", nullable = false)
    private String tenGiangVien;
    
    @Column(name = "email_giang_vien", nullable = false)
    private String emailGiangVien;
    
    @Column(name = "chuyen_mon", nullable = false)
    private String chuyenMon;
    
    @Column(name = "loai_giang_vien", nullable = false)
    private int loaiGiangVien;
    
    @Column(name = "trang_thai", nullable = false)
    private int trangThai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaGiangVien() {
        return maGiangVien;
    }

    public void setMaGiangVien(String maGiangVien) {
        this.maGiangVien = maGiangVien;
    }

    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        this.tenGiangVien = tenGiangVien;
    }

    public String getEmailGiangVien() {
        return emailGiangVien;
    }

    public void setEmailGiangVien(String emailGiangVien) {
        this.emailGiangVien = emailGiangVien;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public int getLoaiGiangVien() {
        return loaiGiangVien;
    }

    public void setLoaiGiangVien(int loaiGiangVien) {
        this.loaiGiangVien = loaiGiangVien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(Integer idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Thu Huyen
 */
@Entity
@Table(name = "ctdt_hocphan")

public class hoc_phan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_khungct", referencedColumnName = "id", nullable = false)
    private khung_chuong_trinh khungChuongTrinh;
    
    @Column(name = "ma_hoc_phan", nullable = false)
    private String maHocPhan;
    
    @Column(name = "ten_hoc_phan", nullable = false)
    private String tenHocPhan;
    
    @Column(name = "so_tin_chi", nullable = false)
    private int soTinChi;
    
    @Column(name = "so_tiet_ly_thuyet", nullable = false)
    private int soTietLyThuyet;
    
    @Column(name = "so_tiet_thuc_hanh", nullable = false)
    private int soTietThucHanh;
    
    @Column(name = "so_tiet_thuc_tap", nullable = false)
    private int soTietThucTap;
    
    @Column(name = "so_tiet_cong", nullable = false)
    private int soTietCong;
    
    @Column(name = "he_so_hocphan", nullable = false)
    private int heSoHocPhan;
    
    @Column(name = "ma_hocphan_truoc", nullable = true)
    private String maHPTruoc;
    
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

    public khung_chuong_trinh getKhungChuongTrinh() {
        return khungChuongTrinh;
    }

    public void setKhungChuongTrinh(khung_chuong_trinh khungChuongTrinh) {
        this.khungChuongTrinh = khungChuongTrinh;
    }

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public int getSoTietThucHanh() {
        return soTietThucHanh;
    }

    public void setSoTietThucHanh(int soTietThucHanh) {
        this.soTietThucHanh = soTietThucHanh;
    }

    public int getSoTietThucTap() {
        return soTietThucTap;
    }

    public void setSoTietThucTap(int soTietThucTap) {
        this.soTietThucTap = soTietThucTap;
    }

    public int getSoTietCong() {
        return soTietCong;
    }

    public void setSoTietCong(int soTietCong) {
        this.soTietCong = soTietCong;
    }

    public int getHeSoHocPhan() {
        return heSoHocPhan;
    }

    public void setHeSoHocPhan(int heSoHocPhan) {
        this.heSoHocPhan = heSoHocPhan;
    } 

    public String getMaHPTruoc() {
        return maHPTruoc;
    }

    public void setMaHPTruoc(String maHPTruoc) {
        this.maHPTruoc = maHPTruoc;
    }
}

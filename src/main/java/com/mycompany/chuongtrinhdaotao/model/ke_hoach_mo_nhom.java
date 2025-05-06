/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.model;

/**
 *
 * @author Tuong Vy Ha
 */

import jakarta.persistence.*;

@Entity
@Table (name = "ctdt_kehoachmonhom")
public class ke_hoach_mo_nhom {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "ma_nhom", nullable = false)
    private String maNhom;
    
    @ManyToOne
    @JoinColumn(name = "id_hocphan", referencedColumnName = "id", nullable = false)
    private hoc_phan hocPhan;
    
    @Column(name = "nam_hoc", nullable = false)
    private String namHoc;
    
    @Column(name = "hoc_ky", nullable = false)
    private int hocKy;
    
    @Column(name = "sl_sinhvien", nullable = false)
    private int slSinhVien;
    
    @Column(name = "thoigian_batdau", nullable = false)
    private String thoiGianBatDau;
    
    @Column(name = "thoigian_ketthuc", nullable = false)
    private String thoiGianKetThuc;
    
    @Column(name = "trang_thai", nullable = false)
    private int trangThai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public hoc_phan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(hoc_phan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public int getSlSinhVien() {
        return slSinhVien;
    }

    public void setSlSinhVien(int slSinhVien) {
        this.slSinhVien = slSinhVien;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }
}

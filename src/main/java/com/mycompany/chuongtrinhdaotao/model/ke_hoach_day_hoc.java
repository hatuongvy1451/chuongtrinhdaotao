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
@Table(name = "ctdt_kehoachdayhoc")
public class ke_hoach_day_hoc {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_hocphan", referencedColumnName = "id", nullable = false)
    private hoc_phan hocPhan;
    
    @ManyToOne
    @JoinColumn(name = "id_thongtin", referencedColumnName = "id", nullable = false)
    private thong_tin_chung ctdt;
    
    @Column(name = "hoc_ky_thuc_hien", nullable = false)
    private int hocKyThucHien;
    
    @Column(name = "nam_hoc", nullable = false)
    private String namHoc;
    
    @Column(name = "trang_thai", nullable = false)
    private int trangThai;

    public thong_tin_chung getCtdt() {
        return ctdt;
    }

    public void setCtdt(thong_tin_chung ctdt) {
        this.ctdt = ctdt;
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

    public int getHocKyThucHien() {
        return hocKyThucHien;
    }

    public void setHocKyThucHien(int hocKyThucHien) {
        this.hocKyThucHien = hocKyThucHien;
    }
}

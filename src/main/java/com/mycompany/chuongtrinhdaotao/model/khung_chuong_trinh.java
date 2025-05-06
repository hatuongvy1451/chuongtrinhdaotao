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
@Table(name="ctdt_khungchuongtrinh")
public class khung_chuong_trinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_thongtin", referencedColumnName = "id")
    private thong_tin_chung ctdt;

    @Column(name = "ma_khoi", nullable = false)
    private String maKhoi;
    @Column(name = "ten_khoi", nullable = false)
    private String tenKhoi;
    @Column(name = "so_tin_chi_toi_thieu", nullable = false)
    private int soTinChiToiThieu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKhoi() {
        return maKhoi;
    }

    public void setMaKhoi(String maKhoi) {
        this.maKhoi = maKhoi;
    }

    public String getTenKhoi() {
        return tenKhoi;
    }

    
    public void setTenKhoi(String tenKhoi) {
        this.tenKhoi = tenKhoi;
    }

    public int getSoTinChiToiThieu() {
        return soTinChiToiThieu;
    }

    public void setSoTinChiToiThieu(int soTinChiToiThieu) {
        this.soTinChiToiThieu = soTinChiToiThieu;
    }

    public thong_tin_chung getCtdt() {
        return ctdt;
    }

    public void setCtdt(thong_tin_chung ctdt) {
        this.ctdt = ctdt;
    }
}
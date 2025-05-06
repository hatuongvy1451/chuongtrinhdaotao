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
import jakarta.persistence.Table;

/**
 *
 * @author Thu Huyen
 */
@Entity
@Table(name="ctdt_khungchuongtrinh_khoikienthuc")
public class khung_chuong_trinh_kkt{
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "id_khungct", nullable = false)
    private int idKhungCT;
    @Column(name = "id_khoikienthuc", nullable = false)
    private int idKhoiKT;
    @Column(name = "so_tin_chi_bat_buoc", nullable = false)
    private int soTinChiBatBuoc;
    @Column(name = "so_tin_chi_tu_chon", nullable = false)
    private int soTinChiTuChon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKhungCT() {
        return idKhungCT;
    }

    public void setIdKhungCT(int idKhungCT) {
        this.idKhungCT = idKhungCT;
    }

    public int getIdKhoiKT() {
        return idKhoiKT;
    }

    public void setIdKhoiKT(int idKhoiKT) {
        this.idKhoiKT = idKhoiKT;
    }

    public int getSoTinChiBatBuoc() {
        return soTinChiBatBuoc;
    }

    public void setSoTinChiBatBuoc(int soTinChiBatBuoc) {
        this.soTinChiBatBuoc = soTinChiBatBuoc;
    }

    public int getSoTinChiTuChon() {
        return soTinChiTuChon;
    }

    public void setSoTinChiTuChon(int soTinChiTuChon) {
        this.soTinChiTuChon = soTinChiTuChon;
    }
}
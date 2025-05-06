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
@Table(name="ctdt_khungchuongtrinh_khoikienthuc")
public class khung_chuong_trinh_kkt{
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
   @ManyToOne
    @JoinColumn(name = "id_khungct", referencedColumnName = "id", nullable = false)
    private khung_chuong_trinh idKhungCT;
   
   @ManyToOne
    @JoinColumn(name = "id_khoikienthuc", referencedColumnName = "id", nullable = false)
    private khoi_kien_thuc idKhoiKT;
   
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

    public khung_chuong_trinh getIdKhungCT() {
        return idKhungCT;
    }

    public void setIdKhungCT(khung_chuong_trinh idKhungCT) {
        this.idKhungCT = idKhungCT;
    }

    public khoi_kien_thuc getIdKhoiKT() {
        return idKhoiKT;
    }

    public void setIdKhoiKT(khoi_kien_thuc idKhoiKT) {
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




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chuongtrinhdaotao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

/**
 *
 * @author Thu Huyen
 */
@Entity
@Table(name = "ctdt_decuongchitiet")
public class de_cuong_chi_tiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "id_hocphan", nullable = false)
    private int idHocPhan;
    
    @Column(name = "mo_ta", nullable = false)
    private String moTa;
    
    @Column(name = "muc_tieu", nullable = false)
    private String mucTieu;
    
    @Column(name = "chuong_noi_dung", nullable = false)
    private String chuongNoiDung;
    
    @Column(name = "phuong_phap_giang_day", nullable = false)
    private String phuongPhapGiangDay;
    
    @Column(name = "phuong_phap_danh_gia", nullable = false)
    private String phuongPhapDanhGia;
    
    @Column(name = "tai_lieu_tham_khao", nullable = false)
    private String taiLieuThamKhao;
    
    @Column(name = "trang_thai", nullable = false)
    private String trangThai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHocPhan() {
        return idHocPhan;
    }

    public void setIdHocPhan(int idHocPhan) {
        this.idHocPhan = idHocPhan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMucTieu() {
        return mucTieu;
    }

    public void setMucTieu(String mucTieu) {
        this.mucTieu = mucTieu;
    }

    public String getChuongNoiDung() {
        return chuongNoiDung;
    }

    public void setChuongNoiDung(String chuongNoiDung) {
        this.chuongNoiDung = chuongNoiDung;
    }

    public String getPhuongPhapGiangDay() {
        return phuongPhapGiangDay;
    }

    public void setPhuongPhapGiangDay(String phuongPhapGiangDay) {
        this.phuongPhapGiangDay = phuongPhapGiangDay;
    }

    public String getPhuongPhapDanhGia() {
        return phuongPhapDanhGia;
    }

    public void setPhuongPhapDanhGia(String phuongPhapDanhGia) {
        this.phuongPhapDanhGia = phuongPhapDanhGia;
    }

    public String getTaiLieuThamKhao() {
        return taiLieuThamKhao;
    }

    public void setTaiLieuThamKhao(String taiLieuThamKhao) {
        this.taiLieuThamKhao = taiLieuThamKhao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}

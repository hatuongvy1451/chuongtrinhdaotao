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
@Table(name = "ctdt_thongtinchung")
public class thong_tin_chung {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "ma_ctdt", nullable= false)
    private String maCTDT;
    
    @Column(name = "ten_ctdt", nullable = false)
    private String tenCTDT;
    
    @Column(name = "bac_dao_tao", nullable = false)
    private String bacDaoTao;
    
    @Column(name = "loai_bang", nullable = false)
    private String loaiBang;
    
    @Column(name = "loai_hinh_dao_tao", nullable=false)
    private String loaiHinhDaoTao;
    
    @Column(name = "thoi_gian_dao_tao", nullable = false)
    private Float thoiGianDaoTao;
    
    @Column(name = "tin_chi_toi_thieu", nullable = false)
    private int tinChiToiThieu;
    
    @Column(name = "khoa_quan_ly", nullable = false)
    private String khoaQuanLy;
    
    @Column(name = "ngon_ngu", nullable= false)
    private String ngonNgu;
    
    @Column(name = "website", nullable= false)
    private String website;
    
    @Column(name = "ban_hanh", nullable= false)
    private String banHanh;
    
    @Column(name ="trang_thai", nullable = false)
    private int trangThai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaCTDT() {
        return maCTDT;
    }

    public void setMaCTDT(String maCTDT) {
        this.maCTDT = maCTDT;
    }

    public String getTenCTDT() {
        return tenCTDT;
    }

    public void setTenCTDT(String tenCTDT) {
        this.tenCTDT = tenCTDT;
    }

    public String getBacDaoTao() {
        return bacDaoTao;
    }

    public void setBacDaoTao(String bacDaoTao) {
        this.bacDaoTao = bacDaoTao;
    }

    public String getLoaiBang() {
        return loaiBang;
    }

    public void setLoaiBang(String loaiBang) {
        this.loaiBang = loaiBang;
    }

    public String getLoaiHinhDaoTao() {
        return loaiHinhDaoTao;
    }

    public void setLoaiHinhDaoTao(String loaiHinhDaoTao) {
        this.loaiHinhDaoTao = loaiHinhDaoTao;
    }

    public Float getThoiGianDaoTao() {
        return thoiGianDaoTao;
    }

    public void setThoiGianDaoTao(Float thoiGianDaoTao) {
        this.thoiGianDaoTao = thoiGianDaoTao;
    }

    public int getTinChiToiThieu() {
        return tinChiToiThieu;
    }

    public void setTinChiToiThieu(int tinChiToiThieu) {
        this.tinChiToiThieu = tinChiToiThieu;
    }

    public String getKhoaQuanLy() {
        return khoaQuanLy;
    }

    public void setKhoaQuanLy(String khoaQuanLy) {
        this.khoaQuanLy = khoaQuanLy;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBanHanh() {
        return banHanh;
    }

    public void setBanHanh(String banHanh) {
        this.banHanh = banHanh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
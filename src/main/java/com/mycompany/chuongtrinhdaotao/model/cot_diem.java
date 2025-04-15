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
@Table(name = "ctdt_cotdiem")
public class cot_diem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    @Column(name = "id_decuongct", nullable = false)
    private int idDeCuongCT; 

    @Column(name = "ten_cot_diem", nullable = false)
    private String tenCotDiem; 

    @Column(name = "ty_le_phan_tram", nullable = false)
    private float tyLePhanTram; 

    @Column(name = "hinh_thuc", nullable = false)
    private String hinhThuc; 

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDeCuongCT() {
        return idDeCuongCT;
    }

    public void setIdDeCuongCT(int idDeCuongCT) {
        this.idDeCuongCT = idDeCuongCT;
    }

    public String getTenCotDiem() {
        return tenCotDiem;
    }

    public void setTenCotDiem(String tenCotDiem) {
        this.tenCotDiem = tenCotDiem;
    }

    public float getTyLePhanTram() {
        return tyLePhanTram;
    }

    public void setTyLePhanTram(float tyLePhanTram) {
        this.tyLePhanTram = tyLePhanTram;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }
}

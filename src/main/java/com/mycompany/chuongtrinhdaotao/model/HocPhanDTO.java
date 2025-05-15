package com.mycompany.chuongtrinhdaotao.model;
public class HocPhanDTO {
    private String maHocPhan;
    private String tenHocPhan;
    private int soTinChi;
    private int soTietLyThuyet;
    private int soTietThucHanh;
    private int soTietThucTap;
    private int heSoHocPhan;
    private String maKhoi;
    private String tenKhoi;

    // Constructor
    public HocPhanDTO(String maHocPhan, String tenHocPhan, int soTinChi,
                      int soTietLyThuyet, int soTietThucHanh, int soTietThucTap,
                      int heSoHocPhan, String maKhoi, String tenKhoi) {
        this.maHocPhan = maHocPhan;
        this.tenHocPhan = tenHocPhan;
        this.soTinChi = soTinChi;
        this.soTietLyThuyet = soTietLyThuyet;
        this.soTietThucHanh = soTietThucHanh;
        this.soTietThucTap = soTietThucTap;
        this.heSoHocPhan = heSoHocPhan;
        this.maKhoi = maKhoi;
        this.tenKhoi = tenKhoi;
    }

    public String getMaHocPhan() {
        return maHocPhan;
    }

    public void setMaHocPhan(String maHocPhan) {
        this.maHocPhan = maHocPhan;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getTenHocPhan() {
        return tenHocPhan;
    }

    public void setTenHocPhan(String tenHocPhan) {
        this.tenHocPhan = tenHocPhan;
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

    public int getHeSoHocPhan() {
        return heSoHocPhan;
    }

    public void setHeSoHocPhan(int heSoHocPhan) {
        this.heSoHocPhan = heSoHocPhan;
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

// Getters & setters (tùy chọn nếu bạn dùng template engine như Thymeleaf)
}

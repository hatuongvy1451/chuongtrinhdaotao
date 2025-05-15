package com.mycompany.chuongtrinhdaotao.model;

public class thong_ke_phan_cong {
    private Integer idGiangVien;
    private String maGiangVien;
    private String tenGiangVien;
    private String chuyenMon;
    private Integer loaiGiangVien;
    private Integer trangThai;

    private String tenHocPhan;
    private String maHocPhan;
    private Integer soTinChi;
    private Integer soTietHP;

    // Semester-specific class counts
    private Long soLopHK1;
    private Long soLopHK2;
    private Long soLopHK3;
    private Long tongSoLop;

    private Long tongTiet;
    private boolean isTotalRow = false;
    private Long tongTietMon; // Total hours for this subject (soTietCong × total classes)
    
    public thong_ke_phan_cong(){
        
    }
    // Constructor matching repository query
    public thong_ke_phan_cong(Integer idGiangVien, String maGiangVien, String tenGiangVien,
                              String chuyenMon, Integer loaiGiangVien, Integer trangThai,
                              String tenHocPhan, String maHocPhan, Integer soTinChi, Integer soTietHP,
                              Long soLopHK1, Long soLopHK2, Long soLopHK3, Long tongSoLop,
                              Long tongTiet,Long tongTietMon) {
        this.idGiangVien = idGiangVien;
        this.maGiangVien = maGiangVien;
        this.tenGiangVien = tenGiangVien;
        this.chuyenMon = chuyenMon;
        this.loaiGiangVien = loaiGiangVien;
        this.trangThai = trangThai;
        this.tenHocPhan = tenHocPhan;
        this.maHocPhan = maHocPhan;
        this.soTinChi = soTinChi;
        this.soTietHP = soTietHP;
        this.soLopHK1 = soLopHK1;
        this.soLopHK2 = soLopHK2;
        this.soLopHK3 = soLopHK3;
        this.tongSoLop = tongSoLop;
        this.tongTiet = tongTiet;
        this.tongTietMon = tongTietMon;
    }

    // Constructor for total rows
    public thong_ke_phan_cong(String maGiangVien, String tenGiangVien, Long tongTiet) {
        this.maGiangVien = maGiangVien;
        this.tenGiangVien = tenGiangVien;
        this.tongTiet = tongTiet;
        this.isTotalRow = true;

        // Initialize other fields with defaults
        this.idGiangVien = null;
        this.chuyenMon = "";
        this.loaiGiangVien = null;
        this.trangThai = null;
        this.tenHocPhan = "";
        this.maHocPhan = "";
        this.soTinChi = null;
        this.soTietHP = null;
        this.soLopHK1 = null;
        this.soLopHK2 = null;
        this.soLopHK3 = null;
        this.tongSoLop = null;
    }
    private Integer teacherSequenceNumber;

    // Add getter and setter
    public Integer getTeacherSequenceNumber() {
        return teacherSequenceNumber;
    }

    public void setTeacherSequenceNumber(Integer teacherSequenceNumber) {
        this.teacherSequenceNumber = teacherSequenceNumber;
    }
    // Getters and setters for all fields
    public Integer getIdGiangVien() { return idGiangVien; }
    public void setIdGiangVien(Integer idGiangVien) { this.idGiangVien = idGiangVien; }

    public String getMaGiangVien() { return maGiangVien; }
    public void setMaGiangVien(String maGiangVien) { this.maGiangVien = maGiangVien; }

    public String getTenGiangVien() { return tenGiangVien; }
    public void setTenGiangVien(String tenGiangVien) { this.tenGiangVien = tenGiangVien; }

    public String getChuyenMon() { return chuyenMon; }
    public void setChuyenMon(String chuyenMon) { this.chuyenMon = chuyenMon; }

    public Integer getLoaiGiangVien() { return loaiGiangVien; }
    public void setLoaiGiangVien(Integer loaiGiangVien) { this.loaiGiangVien = loaiGiangVien; }

    public Integer getTrangThai() { return trangThai; }
    public void setTrangThai(Integer trangThai) { this.trangThai = trangThai; }

    public String getTenHocPhan() { return tenHocPhan; }
    public void setTenHocPhan(String tenHocPhan) { this.tenHocPhan = tenHocPhan; }

    public String getMaHocPhan() { return maHocPhan; }
    public void setMaHocPhan(String maHocPhan) { this.maHocPhan = maHocPhan; }

    public Integer getSoTinChi() { return soTinChi; }
    public void setSoTinChi(Integer soTinChi) { this.soTinChi = soTinChi; }

    public Integer getSoTietHP() { return soTietHP; }
    public void setSoTietHP(Integer soTietHP) { this.soTietHP = soTietHP; }

    public Long getSoLopHK1() { return soLopHK1; }
    public void setSoLopHK1(Long soLopHK1) { this.soLopHK1 = soLopHK1; }

    public Long getSoLopHK2() { return soLopHK2; }
    public void setSoLopHK2(Long soLopHK2) { this.soLopHK2 = soLopHK2; }

    public Long getSoLopHK3() { return soLopHK3; }
    public void setSoLopHK3(Long soLopHK3) { this.soLopHK3 = soLopHK3; }

    public Long getTongSoLop() { return tongSoLop; }
    public void setTongSoLop(Long tongSoLop) { this.tongSoLop = tongSoLop; }

    public Long getTongTiet() { return tongTiet; }
    public void setTongTiet(Long tongTiet) { this.tongTiet = tongTiet; }

    public boolean isTotalRow() { return isTotalRow; }
    public void setTotalRow(boolean totalRow) { isTotalRow = totalRow; }  public Long getTongTietMon() { return tongTietMon; }
    public void setTongTietMon(Long tongTietMon) { this.tongTietMon = tongTietMon; }
}

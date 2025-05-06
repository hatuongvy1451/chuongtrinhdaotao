package com.mycompany.chuongtrinhdaotao.excel;

import com.mycompany.chuongtrinhdaotao.model.giang_vien;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nhu
 */
public class Export_GiangVien {
    public static ByteArrayInputStream exportToExcel(List<giang_vien> listGiangVien) throws IOException {
        String[] COLUMNs = {"ID", "Mã TK","Mã GV", "Tên GV", "Email", "Chuyên môn", "Loại GV", "Trạng thái"};
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet("GiangVien");

          
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
            }

   
            int rowIdx = 1;
            for (giang_vien gv : listGiangVien) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(gv.getId());
                if (gv.getIdTaiKhoan() != null) {
                    row.createCell(1).setCellValue(gv.getIdTaiKhoan());
                } else {
                    row.createCell(1).setCellValue("Chưa có tài khoản");
                }
                row.createCell(2).setCellValue(gv.getMaGiangVien());
                row.createCell(3).setCellValue(gv.getTenGiangVien());
                row.createCell(4).setCellValue(gv.getEmailGiangVien());
                row.createCell(5).setCellValue(gv.getChuyenMon());
                row.createCell(6).setCellValue(gv.getLoaiGiangVien()== 1 ? "Cơ hữu" : "Thỉnh giảng");
                row.createCell(7).setCellValue(gv.getTrangThai()== 1 ? "Đang làm việc" : "Ngưng làm việc");
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}

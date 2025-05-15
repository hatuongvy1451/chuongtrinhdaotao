package com.mycompany.chuongtrinhdaotao.controller;

import com.mycompany.chuongtrinhdaotao.model.thong_ke_phan_cong;
import com.mycompany.chuongtrinhdaotao.service.thong_ke_phan_cong_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class thong_ke_phan_cong_Controller {

    @Autowired
    private thong_ke_phan_cong_Service thongKeService;

    @GetMapping("/thong-ke-phan-cong")
    public String hienThiBangThongKe(Model model) {
        List<thong_ke_phan_cong> danhSach = thongKeService.layDanhSachThongKe();

        // Filter out total rows if they exist
        List<thong_ke_phan_cong> filteredList = danhSach.stream()
                .filter(item -> !item.isTotalRow())
                .collect(Collectors.toList());

        // Group by teacher code
        Map<String, List<thong_ke_phan_cong>> gvMap = filteredList.stream()
                .collect(Collectors.groupingBy(thong_ke_phan_cong::getMaGiangVien));

        // Prepare flattened list with subjects followed by total row
        List<thong_ke_phan_cong> ketQua = new ArrayList<>();

        int teacherCounter = 0;
        for (Map.Entry<String, List<thong_ke_phan_cong>> entry : gvMap.entrySet()) {
            teacherCounter++;
            List<thong_ke_phan_cong> items = entry.getValue();

            // Add sequence number to the first row of each teacher
            // Add sequence number to the first row of each teacher
            if (!items.isEmpty()) {
                items.get(0).setTeacherSequenceNumber(teacherCounter);
            }

// Add all subjects for this teacher
            ketQua.addAll(items);

// Calculate total periods (tongTiet) for the teacher
            long tongTiet = items.stream()
                    .mapToLong(item -> item.getSoTietHP() * item.getTongSoLop())
                    .sum();

// Create and add the total row
            thong_ke_phan_cong totalRow = new thong_ke_phan_cong();
            totalRow.setMaGiangVien(entry.getKey());
            totalRow.setTenGiangVien(items.get(0).getTenGiangVien());
            totalRow.setTongTiet(tongTiet);
            totalRow.setTotalRow(true);

            ketQua.add(totalRow);

        }

        model.addAttribute("danhSach", ketQua);
        return "ctdt_thongkephancong";
    }
}

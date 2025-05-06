package com.mycompany.chuongtrinhdaotao.service;

import com.mycompany.chuongtrinhdaotao.model.thong_ke_phan_cong;
import com.mycompany.chuongtrinhdaotao.repository.thong_ke_phan_cong_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class thong_ke_phan_cong_Service {

    private final thong_ke_phan_cong_Repo thongKeRepo;

    @Autowired
    public thong_ke_phan_cong_Service(thong_ke_phan_cong_Repo thongKeRepo) {
        this.thongKeRepo = thongKeRepo;
    }

    public List<thong_ke_phan_cong> layDanhSachThongKe() {
        return thongKeRepo.getThongKePhanCongChiTiet();
    }
}

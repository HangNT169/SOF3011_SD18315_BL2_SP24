package com.sof3011.hangnt169.B4_CRUDListFixCung.service;

import com.sof3011.hangnt169.B4_CRUDListFixCung.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    // Chua logic
    private List<SinhVien> listSinhVien = new ArrayList<>();

    public SinhVienService() {
        // fake 5 ban ghi
        listSinhVien.add(new SinhVien("ph211", "giap dan", 19, "hoai duc", true));
        listSinhVien.add(new SinhVien("ph111", "giapd", 18, "ha noi", false));
        listSinhVien.add(new SinhVien("ph212", "giap dan", 19, "hoai duc", true));
        listSinhVien.add(new SinhVien("ph113", "giapd", 18, "ha noi", true));
        listSinhVien.add(new SinhVien("ph214", "giap dan", 19, "hoai duc", true));
        listSinhVien.add(new SinhVien("ph115", "giapd", 18, "ha noi", false));
    }

    public List<SinhVien> getAll() {
        return listSinhVien;
    }

    // validate => HashMap
    public void addSinhVien(SinhVien sv){
        listSinhVien.add(sv);
    }

}

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
    public void addSinhVien(SinhVien sv) {
        listSinhVien.add(sv);
    }

    // 5 6 -1 3
    // 0 1 2 3  : a[100]
    // i => a[i]: gia tri cua phan tu trong mang
    // Mang dong : lists
    // SV1 SV2 SV5 SV8
    // 0    1   2   3
    // i => lists[i] : Khong viet ntn => list.get(i)
    public void xoaSinhVien(String mssv) {
        for (int i = 0; i < listSinhVien.size(); i++) {
            if (listSinhVien.get(i).getMssv().equalsIgnoreCase(mssv)) {
                listSinhVien.remove(i);
            }
        }
    }

    // filter
    public SinhVien detailSinhVien(String mssv) {
        for (SinhVien sv : listSinhVien) {
            if (sv.getMssv().equalsIgnoreCase(mssv)) {
                return sv;
            }
        }
        return null;
    }
}

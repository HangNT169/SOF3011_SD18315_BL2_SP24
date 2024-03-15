package com.sof3011.hangnt169.B4_CRUDListFixCung.controller;

import com.sof3011.hangnt169.B4_CRUDListFixCung.entity.SinhVien;
import com.sof3011.hangnt169.B4_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/search",  // GET
        "/sinh-vien/remove",  // GET
        "/sinh-vien/detail",  // GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/update",    // POST
        "/sinh-vien/view-add",  // GET
        "/sinh-vien/add",    // POST
})
public class SinhVienServlet extends HttpServlet {

    private SinhVienService sinhVienService = new SinhVienService();
    private List<SinhVien> sinhViens = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri tren duong dan
        String uri = request.getRequestURI();
        // B2: Kiem tra xem la uri tuong ung vs hanh dong nao
        if (uri.contains("hien-thi")) {
            // Hien thi danh sach sinh vien
            this.hienThiDanhSachSinhVien(request, response);
        } else if (uri.contains("search")) {
            // tim kiem
            this.searchSinhVien(request, response);
        } else if (uri.contains("remove")) {
            //remove
            this.remove(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detail(request, response);
        } else if (uri.contains("view-update")) {
            //view-update
            this.viewUpdate(request, response);
        } else if (uri.contains("view-add")) {
            //view-update
            this.viewAdd(request, response);
        } else {
            // Sua URL linh tinh => return hien thi
            this.hienThiDanhSachSinhVien(request, response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri tren duong dan
        String uri = request.getRequestURI();
        // B2: Kiem tra xem la uri tuong ung vs hanh dong nao
        if (uri.contains("add")) {
            // Hien thi danh sach sinh vien
            this.addSinhVien(request, response);
        } else {
            this.updateSinhVien(request, response);
        }
    }

    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        // C1: Lam o muc co ban
        // B1: Lay du lieu view => servlet
        String ma = request.getParameter("mssv");
        String ten = request.getParameter("ten");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String diaChi = request.getParameter("diaChi");
        // B2: Khoi tao doi tuong
        SinhVien sv = SinhVien.builder()
                .gioiTinh(Boolean.valueOf(gioiTinh))
                .diaChi(diaChi)
                .tuoi(Integer.valueOf(tuoi))
                .ten(ten)
                .mssv(ma)
                .build(); // contructor k tham so
        // B3: Goi service
        sinhVienService.addSinhVien(sv);
        // B4: Chuyen trang
        response.sendRedirect("/sinh-vien/hien-thi");
//        sinhViens = sinhVienService.getAll();
//        request.setAttribute("lists",sinhViens);
//        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request,response);
        // B4: Chuyen trang
//        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request,response);
        // C2: Su dung Beanutils
//        SinhVien sv = new SinhVien();
//        BeanUtils.populate(sv,request.getParameterMap());
//        sinhVienService.addSinhVien(sv);
//        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi4/add-sinh-vien.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri tu url (jsp)
        String ma = request.getParameter("c");
        // B2: Goi ham service
        SinhVien sv = sinhVienService.detailSinhVien(ma);
        // B3: Chuyen sang jsp
        request.setAttribute("sv1", sv);
        request.getRequestDispatcher("/buoi4/update-sinh-vien.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri tu url (jsp)
        String ma = request.getParameter("a");
        // B2: Goi ham service
        SinhVien sv = sinhVienService.detailSinhVien(ma);
        // B3: Chuyen sang jsp
        request.setAttribute("sv1", sv);
        request.getRequestDispatcher("/buoi4/detail-sinh-vien.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // B1: Lay gia tri tu url (jsp)
        String ma = request.getParameter("b");
        // B2: Goi service
        sinhVienService.xoaSinhVien(ma);
        // B3: Quay lai trang chu
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDanhSachSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sinhViens = sinhVienService.getAll();
        request.setAttribute("lists", sinhViens);
        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request, response);
    }
}

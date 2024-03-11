package com.sof3011.hangnt169.B4_CRUDListFixCung.controller;

import com.sof3011.hangnt169.B4_CRUDListFixCung.entity.SinhVien;
import com.sof3011.hangnt169.B4_CRUDListFixCung.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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
    private List<SinhVien>sinhViens = new ArrayList<>();

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

    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDanhSachSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sinhViens = sinhVienService.getAll();
        request.setAttribute("lists",sinhViens);
        request.getRequestDispatcher("/buoi4/sinhviens.jsp").forward(request,response);
    }
}

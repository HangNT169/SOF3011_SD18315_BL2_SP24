package com.sof3011.hangnt169.B2_LamViecVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "KetQuaServlet", value = "/ket-qua1")
public class KetQuaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi2/test.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // B1: Lay du lieu tu jsp ve servlet  => getParameter
//        String name = request.getParameter("uname");
//        String password = request.getParameter("psw");
//        // B2: Truyen gia tri tu servlet sang jsp
//        request.setAttribute("usname",name);
//        request.setAttribute("password",password);
//        // B3: Chuyen trang
//        request.getRequestDispatcher("/buoi2/ketqua.jsp").forward(request,response);
    }
}

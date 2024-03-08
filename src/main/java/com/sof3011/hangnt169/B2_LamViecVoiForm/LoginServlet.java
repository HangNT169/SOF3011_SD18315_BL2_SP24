package com.sof3011.hangnt169.B2_LamViecVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet ", value = {"/login","/ket-qua"})
// value : Chua duong dan cua trang web
// Duong dan BAT BUOC PHAI BAT DAU / => KHONG LA CHET TOMCAT K BUILD DC
// server vs client => HTTP methods :
// Co 4 loai co ban:
    // GET : Hien thi lay ra (READ)
    // POST: Them xu ly (CREATE)
    // PUT: Update (UPDATE)
    // DELETE delete => Xoa (DELETE)
// J4, J5 => CHI DUNG 2 LOAI =>
    // GET(Hien thi)
    // POST (Xu ly)
// VALUE=> Giong Y SI DE BAI
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messs="SD18315";
        // Truyen gia tri tu servlet => sang jsp => setAttribute
        request.setAttribute("a",messs);
        // Chuyen trang
        // C1: getRequestDispatcher => Mang du lieu can truyen di
//        request.getRequestDispatcher("login.jsp").forward(request,response);
        // C2: chuyen trang => sendRedirect => Du lieu k dc day di
        response.sendRedirect("/buoi2/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay du lieu tu jsp ve servlet  => getParameter
        String name = request.getParameter("uname");
        String password = request.getParameter("psw");
        // B2: Truyen gia tri tu servlet sang jsp
        request.setAttribute("usname",name);
        request.setAttribute("password",password);
        // B3: Chuyen trang
        request.getRequestDispatcher("/buoi2/ketqua.jsp").forward(request,response);
    }

}

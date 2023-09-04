package com.example.useroradmincheck;

import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.crypto.Data;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String password = request.getParameter("password");

        if (!password.matches("[\\w&&[^_]]{6,12}")) {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }

        Boolean typeAdmin = Boolean.valueOf(request.getParameter("admin"));
        Boolean typeUser = Boolean.valueOf(request.getParameter("user"));

        if (typeAdmin && typeUser)
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        if (typeAdmin){
            setCookie(response,"time",new Date().toString(),4000);
            getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
        } else if (typeUser) {
            getServletContext().getRequestDispatcher("/user.jsp").forward(request,response);
        }

        if (!typeAdmin && !typeUser)
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }
    private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge )throws IOException {
        Cookie cookie = new Cookie( nom, URLEncoder.encode( valeur, "UTF-8" ) );
        cookie.setMaxAge( maxAge );
        response.addCookie( cookie );
    }

    public void destroy() {
    }
}
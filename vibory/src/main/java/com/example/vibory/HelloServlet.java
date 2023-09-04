package com.example.vibory;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    public static  canditates canditates1;
     public static canditates canditates2;
     public static canditates canditates3;
     public static canditates canditates4;

    public void init() {
        message = "Hello World!";
        canditates1 = new canditates("a",0);
        canditates2 = new canditates("b",0);
        canditates3 = new canditates("c",0);
        canditates4 = new canditates("d",0);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("cond1",canditates1);
        request.setAttribute("cond2",canditates2);
        request.setAttribute("cond3",canditates3);
        request.setAttribute("cond4",canditates4);

        request.getServletContext().getRequestDispatcher("/listCond.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
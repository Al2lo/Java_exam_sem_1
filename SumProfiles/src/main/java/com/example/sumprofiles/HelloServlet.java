package com.example.sumprofiles;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    public static ArrayList<Profile> profiles;
    public static String Login;
    public void init() {
        message = "Hello World!";
        try {
            profiles = workBD.getProfiles();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Boolean good = false;
        Login = request.getParameter("loginName");
        for (var item:
             profiles) {
            if (Login.compareTo(item.getLogin()) == 0) {
                good = true;
                break;
            }
        }
        ServletContext context = request.getServletContext();
        RequestDispatcher dispatcher;

        if (good)  dispatcher = context.getRequestDispatcher("/work.jsp");

        else dispatcher = context.getRequestDispatcher("/errors.jsp");

        dispatcher.forward(request,response);

    }

    public void destroy() {
    }
}
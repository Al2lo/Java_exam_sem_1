package com.example.like_dislike;

import java.io.*;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
    public static Message message;


    public void init() {
            try {
                message = WorkBD.getTextInBD();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        request.setAttribute("message",message);
        ServletContext context = request.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/look.jsp");
        dispatcher.forward(request,response);
    }

    public void destroy() {
    }
}
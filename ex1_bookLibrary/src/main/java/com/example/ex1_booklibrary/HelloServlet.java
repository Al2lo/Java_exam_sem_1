package com.example.ex1_booklibrary;

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

    public void init() {
        message = "Hello World!";
    }
private  static ArrayList<Book> books;

    static {
        try {
            books = WorkBD.getAllAutgors();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        ArrayList<Book> books1 = new ArrayList<>();
        int to = WorkBD.count;
        int from = to + 2;
        int i = 0;

        for (var item :
             books) {
            if (to >= from){
                break;
            }
            if (i == to){
                books1.add(item);
                to++;
            }
            i++;
        }
        WorkBD.count += 2;

        request.setAttribute("knigi", books1);

        ServletContext context = request.getServletContext();
        if (books.size()+1 < WorkBD.count){
            WorkBD.count = 0;
            RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
        }

        RequestDispatcher dispatcher = context.getRequestDispatcher("/zadanie.jsp");
        dispatcher.forward(request,response);

    }

    public void destroy() {
    }
}
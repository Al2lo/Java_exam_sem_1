package com.example.groupsfind;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public static ArrayList<Group> groupArrayList;
    public static ArrayList<Group> outGroups;
    private String message;

    public void init() {
        message = "Hello World!";
        try {
            groupArrayList = WorkBD.getTextInBD();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("gr");
        outGroups = new ArrayList<>();

        for (var item:
             groupArrayList) {
            if (item.getGroup().compareTo(id) == 0) {
                outGroups.add(item);
            }
        }
        request.getServletContext().setAttribute("groups",outGroups);


        request.getServletContext().getRequestDispatcher("/vyvod.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
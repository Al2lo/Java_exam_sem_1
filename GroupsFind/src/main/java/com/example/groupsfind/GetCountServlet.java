package com.example.groupsfind;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/getCount")
public class GetCountServlet extends HttpServlet {
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("countGr",HelloServlet.outGroups.size());

        request.getServletContext().getRequestDispatcher("/vyvod.jsp").forward(request,response);
    }

    public void destroy() {
    }
}

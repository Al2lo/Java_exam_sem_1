package com.example.timecloseservlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class FilterSecond implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        String login = request1.getParameter("login");


if (login != null) {
    if (login.charAt(0) == 'a') {
        request.getServletContext().getRequestDispatcher("/out.jsp").forward(request, response);
    }
    request.getServletContext().getRequestDispatcher("/Bad.jsp").forward(request, response);
}
        chain.doFilter(request, response);
    }
}

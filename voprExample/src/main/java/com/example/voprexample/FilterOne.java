package com.example.voprexample;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

public class FilterOne implements Filter {

    public static  boolean b = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String n = request.getParameter("numberValue");
        if (n != null){
            if (Integer.parseInt(n) > 10){
                b = true;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
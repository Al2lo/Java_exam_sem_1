package com.example.filtersdoublelogin;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

public class CheckNumber implements Filter {
    private static final Logger LOGGER = Logger.getLogger(Servlet.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String numb = request.getParameter("numberText");
        if (numb != null){
        if (Integer.parseInt(numb) >= 7777){
            ServletContext context = request.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,servletResponse);
        }}
        LOGGER.info("good");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
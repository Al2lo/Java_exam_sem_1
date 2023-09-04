package com.example.mailfilterswithlogger;
import org.apache.log4j.Logger;
import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class HelloServlet implements Filter {
    private static final Logger log = Logger.getLogger(HelloServlet.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Logger logg = Logger.getLogger(HelloServlet.class);
        logg.info("adr: ");
        logg.info("adr: "+ servletRequest.getLocalAddr());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
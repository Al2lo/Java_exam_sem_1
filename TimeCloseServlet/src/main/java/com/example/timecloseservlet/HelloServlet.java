package com.example.timecloseservlet;

import java.io.*;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jdk.jfr.Timestamp;
import org.apache.log4j.Logger;

public class HelloServlet implements Filter {
    private static final Logger log = Logger.getLogger(HelloServlet.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Date date = new Date();
        log.info("time: "+date.getTime());
        log.info("host: "+servletRequest.getRemoteHost());
        log.info("port: "+servletRequest.getRemotePort());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
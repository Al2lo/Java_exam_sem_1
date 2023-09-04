package com.example.filtersdoublelogin;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Date;

public class DataFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(Servlet.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Date date = new Date();
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        LOGGER.info(date.toString() + ", URI: " + request.getRequestURI()+ ", host: " + request.getServerName() + ", port: " + request.getServerPort() + ", locale: " + request.getLocale()) ;
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

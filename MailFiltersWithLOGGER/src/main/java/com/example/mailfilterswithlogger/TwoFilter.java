package com.example.mailfilterswithlogger;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

import java.io.IOException;

public class TwoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        Logger logg = Logger.getLogger(TwoFilter.class);
        logg.info("adr: " + request.getLocalAddr());
        logg.info("adr: "+ servletRequest.getLocalAddr());
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        if (phone == "" && mail == "") {
            request.setAttribute("error","ERROR");
        }
        else{
            request.setAttribute("error","HELLO");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}

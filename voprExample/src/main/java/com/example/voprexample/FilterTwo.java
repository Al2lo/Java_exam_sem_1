package com.example.voprexample;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;

public class FilterTwo implements  Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String n = request.getParameter("numberValue");
        if (n != null){
            if (Integer.parseInt(n) < 100){
                request.setAttribute("number", n);

                //!!!!!!!!!!!!!!
                String headers = "";


                Enumeration<String> params = request.getHeaderNames();
                while(params.hasMoreElements()){
                    String paramName = params.nextElement();
                    headers +=request.getHeader(paramName) + "</br>";
                }

                //!!!!!!!!!!
                request.setAttribute("headers", headers.toString());
                ServletContext context = request.getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher("/out.jsp");
                dispatcher.forward(request,servletResponse);
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        if (!FilterOne.b) {
            ServletContext context = request.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, servletResponse);
            filterChain.doFilter(servletRequest, servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}

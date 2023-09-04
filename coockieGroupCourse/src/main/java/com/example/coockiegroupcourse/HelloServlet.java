package com.example.coockiegroupcourse;

import java.io.*;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String out = "";
        String group = request.getParameter("group");
        String course = request.getParameter("course");
        String spec = request.getParameter("spec");

        if (request.getCookies().length >=2){

        if ((group.compareTo(getCookie(request,"groupCookies").getValue()) == 0) && (course.compareTo(getCookie(request,"courseCookies").getValue()) == 0) && (spec.compareTo(getCookie(request,"specCookies").getValue()) == 0)) {
            out = "ERROR: this cookie is used";
            request.setAttribute("out",out);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
        }
        request.setAttribute("out",out);
        setCookie(response,"groupCookies", group,4000);
        setCookie(response,"courseCookies", course,4000);
        setCookie(response,"specCookies", spec,4000);
        getServletContext().getRequestDispatcher("/resp.jsp").forward(request, response);
    }

    private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge )throws IOException {
        Cookie cookie = new Cookie( nom, URLEncoder.encode( valeur, "UTF-8" ) );
        cookie.setMaxAge( maxAge );
        response.addCookie( cookie );
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public void destroy() {
    }
}
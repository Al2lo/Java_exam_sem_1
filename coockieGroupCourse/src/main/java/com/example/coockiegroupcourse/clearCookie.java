package com.example.coockiegroupcourse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
@WebServlet("/clearServlet")
public class clearCookie extends HttpServlet {

    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        setCookie(response,"groupCookies", "",4000);
        setCookie(response,"courseCookies", "",4000);
        setCookie(response,"specCookies", "",4000);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
    }

    private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge )throws IOException {
        Cookie cookie = new Cookie( nom, URLEncoder.encode( valeur, "UTF-8" ) );
        cookie.setMaxAge( maxAge );
        response.addCookie( cookie );
    }

    public void destroy() {
    }
}

package com.example.task5;

//Создать сервлет и взаимодействующие с ним классы и JSP- страницы, выполняющие следующие действия.
  //      Пользователю выводится страницы с двумя кнопками GET и POST для выполнения get и post запроса соответственно.
    //    При нажатии на кнопку информация о типе и времени запроса заносится в файл cookie
      //  и при повторном переходе выводится на стартовую страницу.
        //По нажатию на кнопку GET выведите: время последнего get запроса, название и версию протокола.
//        По нажатию на кнопку POST полностью (с заголовками) содержимое HTTP-ответа.

  //      Усложнения задания в GET также нужно вывести MIME тип запроса, определение имени польователя, выполнившего запрос , всю информацию из заголовка запроса

import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

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
        setCookie(response,"time",new Date().toString(),4000);
        setCookie(response,"method", request.getMethod(),4000);

        request.setAttribute("time", new Date().toString());
        request.setAttribute("name", request.getMethod());
        request.setAttribute("headerr", request.getHeader("User-Agent"));
        request.setAttribute("version", request.getProtocol());

        getServletContext().getRequestDispatcher("/get.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setCookie(response,"time",new Date().toString(),4000);
        setCookie(response,"method", request.getMethod(),4000);


        StringBuilder headers = new StringBuilder();
        for(String header : response.getHeaderNames()) {
            headers.append(header + ": " + response.getHeader(header) + "<br/>");
        }
        request.setAttribute("headers", headers.toString());

        getServletContext().getRequestDispatcher("/post.jsp").forward(request, response);
    }



    private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge )throws IOException {
        Cookie cookie = new Cookie( nom, URLEncoder.encode( valeur, "UTF-8" ) );
        cookie.setMaxAge( maxAge );
        response.addCookie( cookie );
    }
    public void destroy() {
    }
}
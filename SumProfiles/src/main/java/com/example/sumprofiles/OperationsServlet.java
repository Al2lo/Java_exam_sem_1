package com.example.sumprofiles;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

@WebServlet("/OperationServlet")
public class OperationsServlet extends  HelloServlet{

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Profile profile = null;
        for (var item:
             HelloServlet.profiles) {
            if (item.getLogin() == HelloServlet.Login) profile = item;
        }


        String out = "";
        String command = request.getParameter("command");
        String textValue = request.getParameter("hhh");

            if (command.compareTo("ADD") == 0) {

                for (var item :
                        HelloServlet.profiles) {
                    if (item.getLogin().compareTo(HelloServlet.Login) == 0) {
                        item.setMoney(item.getMoney() +Integer.parseInt(textValue.toString()));
                    }
                }

            }
            if (command.compareTo("PAY") == 0) {

                for (var item :
                        HelloServlet.profiles) {
                    if (item.getLogin().compareTo(HelloServlet.Login) == 0){
                        if (item.getMoney() - Integer.parseInt(textValue.toString()) < 0) {
                            out = "not have money";
                            break;
                        }
                        item.setMoney(item.getMoney() - Integer.parseInt(textValue.toString()));
                    }
                }

            }
            if (command.compareTo("INFO") == 0) {
                for (var item :
                        HelloServlet.profiles) {
                    if (item.getLogin().compareTo(HelloServlet.Login) == 0) {
                        out = item.getMoney().toString();
                    }
                }

            }

            request.setAttribute("textValue", out);
            ServletContext context = request.getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher("/work.jsp");
            dispatcher.forward(request,response);
    }

    public void destroy() {
    }
}

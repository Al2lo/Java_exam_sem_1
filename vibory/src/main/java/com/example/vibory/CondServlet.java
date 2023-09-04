package com.example.vibory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/condServlet")
public class CondServlet extends HttpServlet {

        public static Integer c;

        public void init(){
            c = 0;
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            if (request.getParameter("oneCond")!= null) {
                HelloServlet.canditates1.setCount( HelloServlet.canditates1.getCount() +1);
                c = ++c;
                request.setAttribute("condidatee", HelloServlet.canditates1);
                request.setAttribute("average",HelloServlet.canditates1.getCount()*100/c);
            }
            else if (request.getParameter("twoCond")!= null) {
                HelloServlet.canditates2.setCount(HelloServlet.canditates2.getCount() + 1);
                request.setAttribute("condidatee", HelloServlet.canditates2);
                c = ++c;
                request.setAttribute("average",HelloServlet.canditates2.getCount()*100/c);
            }
            else if (request.getParameter("threeCond")!= null) {
                HelloServlet.canditates3.setCount(HelloServlet.canditates3.getCount() + 1);
                request.setAttribute("condidatee", HelloServlet.canditates3);
                c = ++c;
                request.setAttribute("average",HelloServlet.canditates3.getCount()*100/c);
            }
            else if (request.getParameter("fourCond")!= null) {
                HelloServlet.canditates4.setCount(HelloServlet.canditates4.getCount() + 1);
                request.setAttribute("condidatee", HelloServlet.canditates4);
                c = ++c;
                request.setAttribute("average",HelloServlet.canditates4.getCount()*100/c);
            }
            request.getServletContext().getRequestDispatcher("/resp.jsp").forward(request, response);
        }

        public void destroy() {
        }
    }


package com.example.jstltag;

import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;
import org.apache.taglibs.standard.tag.el.core.SetTag;

public class HelloServlet extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String addr = request.getLocalAddr();
        String  enc = request.getCharacterEncoding();
        String proto = request.getProtocol();
        String cont = pageContext.getServletContext().toString();

        JspWriter out = pageContext.getOut();

        String buttons = "<h5>"+addr+"</h5>";
          buttons += "<h5>"+enc+"</h5>";
         buttons += "<h5>"+proto+"</h5>";
         buttons += "<h5>"+cont+"</h5>";
        try {
            out.write(buttons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return EVAL_BODY_INCLUDE;
    }
    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

}
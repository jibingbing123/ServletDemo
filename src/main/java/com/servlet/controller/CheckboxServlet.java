package com.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jibingbing on 2018/2/4.
 */
@WebServlet(name = "CheckboxServlet",urlPatterns = {"/getCheckedbox"})
public class CheckboxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<ul>\n" +
                    "<li>" + request.getParameter("google") + "</li>\n" +
                    "<li>" + request.getParameter("sougou") + "</li>\n" +
                    "<li>" + request.getParameter("firefox") + "</li>\n" +
                    "</ul>");
    }
}

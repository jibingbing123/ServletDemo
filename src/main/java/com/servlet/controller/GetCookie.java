package com.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description:
 * @author: jibingbing
 * @create: 2018/02/04
 **/
@WebServlet(name = "GetCookie",urlPatterns = {"/getCookie"})
public class GetCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>获取Cookie</h1><br>" + "<ul><br>");

        if(cookies.length != 0){
            for(Cookie cookie : cookies){
                out.println("<li>cookie名: " + cookie.getName() + ",值: " + cookie.getValue() + "</li><br>" );
            }
        }
        out.println("</ul>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

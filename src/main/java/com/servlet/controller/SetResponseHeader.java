package com.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: jibingbing
 * @create: 2018/02/04
 **/
@WebServlet(name = "SetResponseHeader",urlPatterns = {"/setResponseHeader"})
public class SetResponseHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置刷新自动加载时间
        resp.setIntHeader("Refresh",5);
        //设置响应内容类型
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        LocalDateTime dateTime = LocalDateTime.now();
        out.println("<h2>当前时间为: " + dateTime + "</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

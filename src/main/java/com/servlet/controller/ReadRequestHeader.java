package com.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @description:
 * @author: jibingbing
 * @create: 2018/02/04
 **/
@WebServlet(name = "ReadRequestHeader",urlPatterns = {"/readRequestHeader"})
public class ReadRequestHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.println("<h1>读取表单所有数据</h1><br>" +
                "<table width=\"100%\" border=\"1\" align=\"center\"><br>" +
                "<tr><br>" +
                "<th>Header名称</th><th>对应值</th><br>" +
                "</tr>");

        Enumeration headerNames = (Enumeration) req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headName = (String)headerNames.nextElement();
            out.println("<tr><td>" + headName + "</td><br>");
            String headValue = req.getHeader(headName);
            out.println("<td>" + headValue + "</td></tr><br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

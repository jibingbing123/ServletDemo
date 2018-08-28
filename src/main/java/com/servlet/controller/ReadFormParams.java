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
@WebServlet(name = "ReadParams",urlPatterns = {"/readParams"})
public class ReadFormParams extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.println("<h1>读取表单所有数据</h1><br>" +
                    "<table width=\"100%\" border=\"1\" align=\"center\"><br>" +
                    "<tr><br>" +
                    "<th>参数名称</th><th>参数值</th><br>" +
                    "</tr>");

        Enumeration paramsName = req.getParameterNames();
        while(paramsName.hasMoreElements()){
            String paramName = (String) paramsName.nextElement();
            out.println("<tr><td>" + paramName + "</td><br>");
            String[] paramValues = req.getParameterValues(paramName);
            if(paramValues.length == 0){
                out.println("<td><i>没有值</i></td>");
            } else {
                if(paramValues.length == 1){
                    out.println("<td>" + paramValues[0] + "</td>");
                } else {
                    out.println("<td><ul>");
                    for(int i = 0;i < paramValues.length;i++){
                        out.println("<li>" + paramValues[i] + "</li>");
                    }
                    out.println("</ul></td>");
                }
            }
            out.println("</td>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

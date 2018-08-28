package com.servlet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: jibingbing
 * @create: 2018/02/04
 **/
@WebServlet(name = "SessionTrack",urlPatterns = {"/sessionTrack"})
public class SessionTrack extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        //获取session创建时间
        Date creationTime = new Date(session.getCreationTime());
        //获取最后访问时间
        Date lastAccessedTime = new Date(session.getLastAccessedTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

        String userID = null;
//        String visitCountKey = "visitCountKey";
        Integer visitCount = new Integer(0);
        //检查网页上是否有新的访问者
        if(session.isNew()){
            session.setAttribute("userIDKey","jibingbing");
            session.setAttribute("visitCountKey",visitCount);
        } else {
            visitCount = (Integer) session.getAttribute("visitCountKey");
            visitCount += 1;
            userID = (String) session.getAttribute("userIDKey");
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        out.println("<h1>访问session中数据</h1><br>" +
                    "<ul><br>" +
                    "<li>sessionId: " + session.getId() + "</li><br>" +
                    "<li>创建时间: " + df.format(creationTime) + "</li><br>" +
                    "<li>最后访问时间: " + df.format(lastAccessedTime) + "</li><br>" +
                    "<li>用户: " + userID + "</li><br>" +
                    "</ul><br>" +
                    "<strong>访问量统计: " + visitCount + "</strong>");
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

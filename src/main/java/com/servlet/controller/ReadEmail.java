package com.servlet.controller;

import javax.mail.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * @description:
 * @author: jibingbing
 * @create: 2018/02/05
 **/
@WebServlet(name = "ReadEmail",urlPatterns = {"/readEmail"})
public class ReadEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String host = "pop3.163.com";
        String username = "13388098919@163.com";
        String password = "ji19941228";

        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol","pop3");
        properties.setProperty("mail.pop3.hos",host);

        Session session = Session.getDefaultInstance(properties);

        String form = null;
        String subject = null;
        try {
            Store store = session.getStore();
            store.connect(host,username,password);

            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            for(int i =0;i < messages.length;i++){
                form = messages[i].getFrom()[0].toString();
                subject = messages[i].getSubject();
                out.println("<b>邮件" + (i + 1) + "</b><br>");
                out.println("<ul><br>" +
                            "<li>发件人地址: " + form + "</li><br>" +
                            "<li>主题: " + subject + "</li><br>" +
                            "</ul>");
            }

            folder.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

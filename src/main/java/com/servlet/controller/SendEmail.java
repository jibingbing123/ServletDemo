package com.servlet.controller;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
@WebServlet(name = "SendEmail",urlPatterns = {"/sendEmail"})
public class SendEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String to = "1779518262@qq.com";
        String from = "13388098919@163.com";

        Properties properties = new Properties();
        //设置邮件协议
        properties.put("mail.transport.protocol","smtp");
        //设置发送邮件的服务器地址
        properties.setProperty("mail.host","smtp.163.com");
        //开启验证
        properties.setProperty("mail.smtp.auth","true");

        Session session = Session.getDefaultInstance(properties);

        try {
            //创建邮件信息
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            //设置邮件主题
            message.setSubject("这是你老公写程序给你发的邮件,不是垃圾邮件!");
            //设置邮件内容
            message.setText("爱你吆...");
            //邮件协议也可以这么设置
            Transport transport = session.getTransport("smtp");
            //连接邮箱认证
            transport.connect("smtp.163.com","13388098919@163.com","ji19941228");
            //发送邮件
            transport.sendMessage(message,message.getAllRecipients());

            out.println("<h1>成功发送邮件</h1>");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

package com.liu.servlet;
/**
 * 获取请求
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/servletDemo3")
public class ServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String method = req.getMethod();
//        String contextPath = req.getContextPath();
//        String servletPath = req.getServletPath();
//        String queryString = req.getQueryString();
//        String requestURI = req.getRequestURI();
//        StringBuffer requestURL = req.getRequestURL();
//        String protocol = req.getProtocol();
//        String remoteAddr = req.getRemoteAddr();
//        System.out.println(method);
//        System.out.println(contextPath);
//        System.out.println(servletPath);
//        System.out.println(queryString);
//        System.out.println(requestURI);
//        System.out.println(requestURL);
//        System.out.println(protocol);
//        System.out.println(remoteAddr);
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String header = req.getHeader(name);
            System.out.println(name+":"+header);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

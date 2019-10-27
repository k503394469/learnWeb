package com.liu.simpleLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginSer")
public class LoginSer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String check = request.getParameter("check");
        if ("check".equals(check)){
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
        }

        if ("abc".equals(username)&&"123".equals(password)){
            out.print("欢迎:"+username);
            out.print("<a href='/learnWeb/jsps/simpleLogin.jsp'>返回</a>");
        }else {
            out.print("错误");
            out.print("<a href='/learnWeb/jsps/simpleLogin.jsp'>重新登录</a>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

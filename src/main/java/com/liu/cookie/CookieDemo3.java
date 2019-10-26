package com.liu.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        boolean flag = false;
        Date time = null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时:mm分dd秒");
        String dateFormat = sdf.format(new Date());
        dateFormat= URLEncoder.encode(dateFormat,"utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies.length != 0 || cookies != null) {
            for (Cookie temp : cookies) {
                if ("time".equals(temp.getName())) {
                    flag = true;
                    out.print("<h1>WelcomeBack</h1>");
                    out.print("<p>上次时间是:</p>" + URLDecoder.decode(temp.getValue(),"utf-8"));
                    temp.setValue(dateFormat);
                    temp.setMaxAge(60 * 60);
                    response.addCookie(temp);
                    break;
                }
            }
        }
        if (cookies.length == 0 || cookies == null || flag == false) {
            out.print("<h1>Welcome</h1>");
            out.print("<p>This is your first login</p>");
            Cookie cookie = new Cookie("time", dateFormat);
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

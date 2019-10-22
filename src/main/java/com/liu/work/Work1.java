package com.liu.work;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@WebServlet("/work1")
public class Work1 extends HttpServlet {
    JdbcTemplate jt;
    String method;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");
        if ("ins".equals(method)) {
            String name = request.getParameter("name");
            String sex = request.getParameter("sex");
            String age = request.getParameter("age");
            String date = request.getParameter("date");
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            Date dateDf = null;
            try {
                dateDf = df.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String phone = request.getParameter("phone");
            String hobby = request.getParameter("hobby");
            String sql="insert into stu values (?,?,?,?,?,?)";
            int update = jt.update(sql, name, sex, Integer.parseInt(age),dateDf, phone, hobby);
        }else if ("view".equals(method)){

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    public void init() throws ServletException {
        try {
            jt = new JdbcTemplate(JDBCUtils.getDataSource());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

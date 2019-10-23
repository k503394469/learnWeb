package com.liu.work;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/work1")
public class Work1 extends HttpServlet {
    JdbcTemplate jt;
    String method;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        method = request.getParameter("method");
        if ("ins".equals(method)) {
            Map<String, String[]> stuMap = request.getParameterMap();
            try {
                BeanUtils.populate(Stu.class,stuMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
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
            String []hobby = request.getParameterValues("hobby");
            String hobbies="";
            for (String s:hobby){
                hobbies+=s+" ";
            }
            String sql="insert into stu values (?,?,?,?,?,?)";
            int update = jt.update(sql, name, sex, Integer.parseInt(age),dateDf, phone, hobbies);

        }else if ("view".equals(method)){
            String sql="select * from stu";
            List<Stu> stus=jt.query(sql,(resultSet ,i )->{
                Stu temp=new Stu();
                temp.setName(resultSet.getString(1));
                temp.setSex(resultSet.getString(2));
                temp.setAge(resultSet.getInt(3));
                temp.setDate(resultSet.getDate(4));
                temp.setPhone(resultSet.getString(5));
                temp.setHobby(resultSet.getString(6));
                return temp;
            });
            out.print("<table border='1'>");
            for (Stu temp:stus){
                out.print("<tr><td>"+temp.getName()+"</td><td>"+temp.getSex()+"</td><td>"+temp.getAge()+"</td><td>"+temp.getDate()+"</td><td>"+temp.getPhone()+"</td><td>"+temp.getHobby()+"</td></tr>");
            }
            out.print("</table>");
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

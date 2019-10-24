package com.liu.work;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/getAccessUrl")
public class GetAccessUrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String filePath = this.getServletContext().getRealPath("../classes/ip.txt");
        String filePath = this.getClass().getClassLoader().getResource("/ip.txt").getPath();
        resp.getWriter().print(filePath);
        BufferedWriter bufferedWriter=null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
            String ip = req.getRemoteAddr();
            System.out.println(ip);
            bufferedWriter.write(ip);
            bufferedWriter.write("\r\n");
            bufferedWriter.close();
        }catch (Exception e){

        }finally {
            bufferedWriter.close();
        }

    }
}

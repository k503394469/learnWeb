package com.liu.work;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadDemo")
public class DownloadDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String filename = req.getParameter("filename");
        ServletContext context = this.getServletContext();

        String filePath = context.getRealPath("/imgs/" + filename);
        String mimeType = context.getMimeType(filename);
        resp.setHeader("content-type",mimeType);
        resp.setHeader("content-disposition","attachment;filename="+new String(filename.getBytes("gbk"),"ISO8859-1"));

        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(filePath));
        ServletOutputStream os = resp.getOutputStream();
        try {
            byte[] b=new byte[4096];
            int len=0;
            while ((len=bis.read(b))!=-1){
                os.write(b,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bis.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}

package com.liu.work;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeDemo")
public class CheckCodeDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int height=50,width=100;
        String codeSource="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random r=new Random();
        //创建对象
        BufferedImage bi=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        Graphics g = bi.getGraphics();

        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);

        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        g.setColor(Color.BLUE);

        for (int i = 1; i <=4; i++) {
            g.setFont(new Font("Helvetica",Font.PLAIN,18));
            int index=r.nextInt(codeSource.length());
            char temp=codeSource.charAt(index);
            g.drawString(temp+"",width/5*i,height/2);
        }
        g.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int x1 = r.nextInt(width);
            int x2 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int y2 = r.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        ImageIO.write(bi,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

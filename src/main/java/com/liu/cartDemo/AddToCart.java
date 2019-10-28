package com.liu.cartDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        Map<Integer,Goods> cartMap = (Map<Integer, Goods>) session.getAttribute("cart");
        String pid = request.getParameter("pid");
        System.out.println(pid);
        String pname = request.getParameter("pname");
        System.out.println(pname);
        String pdesc = request.getParameter("pdesc");
        System.out.println(pdesc);
        String price = request.getParameter("price");
        System.out.println(price);
        String num = request.getParameter("num");
        if (cartMap==null||cartMap.size()==0){
            cartMap=new HashMap<>();
            Goods goodsTemp = new Goods();
            goodsTemp.setPid(Integer.valueOf(pid));
            goodsTemp.setPname(pname);
            goodsTemp.setPdesc(pdesc);
            goodsTemp.setPrice(Double.valueOf(price));
            goodsTemp.setNum(Integer.valueOf(num));
            cartMap.put(Integer.valueOf(pid),goodsTemp);
            session.setAttribute("cart",cartMap);
        }else {
            if (!cartMap.containsKey(pid)){
                GoodsDao gd=new GoodsDao();
                Goods goodsTemp = gd.oneGoods(Integer.valueOf(pid));
                goodsTemp.setNum(1);
                cartMap.put(Integer.valueOf(pid),goodsTemp);
            }else{
                Goods goods = cartMap.get(pid);
                goods.setNum(goods.getNum()+1);
            }

        }
        response.sendRedirect("/learnWeb/jsps/cart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

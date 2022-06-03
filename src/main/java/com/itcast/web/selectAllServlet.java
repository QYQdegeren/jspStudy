package com.itcast.web;

import com.itcast.pojo.User;
import com.itcast.pojo.brand;
import com.itcast.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class selectAllServlet extends HttpServlet {

    private BrandService bs = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //调用BrandService查询
        //BrandService bs = new BrandService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();

        System.out.println(username+"欢迎你");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("username")||cookie.getName().equals("password")){
                System.out.println(cookie.getValue());
            }
        }

        List<brand> brands = bs.selectAll();

        for (brand br : brands) {
            System.out.println(br);
        }

//        //将数据存入request域
//        request.setAttribute("brands",brands);
//
//        //转发
//        request.getRequestDispatcher("/brand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

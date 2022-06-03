package com.itcast.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class aServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String value = "张三";
        String encode = URLEncoder.encode(value, "UTF-8");
        System.out.println(encode);

        //创建cookie
        Cookie cookie = new Cookie("username", encode);

        //设置存活时间
        cookie.setMaxAge(120);

        //发送cookie
        response.addCookie(cookie);

      ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

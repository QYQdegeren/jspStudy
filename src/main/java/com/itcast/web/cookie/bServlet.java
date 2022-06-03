package com.itcast.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/bServlet")
public class bServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       //获取cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //获取cookie数据
            //String name = cookie.getName();
            if(cookie.getName().equals("username")){
                String value = cookie.getValue();
                value = URLDecoder.decode(value, "UTF-8");
                System.out.println(value);
                break;
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

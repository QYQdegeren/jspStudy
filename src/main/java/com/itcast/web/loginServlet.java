package com.itcast.web;

import com.itcast.pojo.User;
import com.itcast.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        UserService userService = new UserService();
        User user = userService.login(username, password);
        if(user != null){
            //登陆成功
            if("1".equals(remember)){
                Cookie cookie = new Cookie("username",username);
                Cookie cookie1 = new Cookie("password",password);
                cookie.setMaxAge(180);
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }

            //将user对象存到Session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            //重定向
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");

        }else{
            //登陆失败

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

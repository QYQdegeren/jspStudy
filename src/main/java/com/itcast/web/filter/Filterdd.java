package com.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class Filterdd implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        //判断访问的路径和登陆注册是否相关，相关的资源需要放行

        //获取当前访问路径
        StringBuffer requestURL = req.getRequestURL();


        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        //判断session中是否有数据
        if(user != null){
            //session中有用户数据，---用户登陆过
            chain.doFilter(request, response);
        }else{
            //用户还没有登录
            req.setAttribute("message","用户还没有登陆");
            req.getRequestDispatcher("xxx.jsp").forward(req,response);//重定向
        }


    }
}

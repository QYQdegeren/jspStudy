package com.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filter---");

        //放行前对request数据进行处理

        filterChain.doFilter(servletRequest,servletResponse);//放行

        //放行后对response数据进行处理
    }

    @Override
    public void destroy() {

    }
}

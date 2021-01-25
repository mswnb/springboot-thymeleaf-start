package cn.msw.springbootthymeleafstart.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author 毛送文
 * @Date 2021/1/22 15:56
 * @Version 1.0
 */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("myFilter初始化完成！");
    }

    @Override
    public void destroy() {
        log.info("myFilter销毁！");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("myFilter工作！");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

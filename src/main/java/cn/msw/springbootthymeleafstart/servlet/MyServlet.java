package cn.msw.springbootthymeleafstart.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 毛送文
 * @Date 2021/1/22 15:42
 * @Version 1.0
 */
@Slf4j
//@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("毛送文66666");
    }

    @Override
    public void init() throws ServletException {
        log.info("MyServlet初始化完成...");
    }
}

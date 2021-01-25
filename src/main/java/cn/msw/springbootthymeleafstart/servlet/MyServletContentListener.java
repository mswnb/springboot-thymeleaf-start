package cn.msw.springbootthymeleafstart.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author 毛送文
 * @Date 2021/1/22 16:03
 * @Version 1.0
 */
//@WebListener
@Slf4j
public class MyServletContentListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MyServletContentListener监听初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("MyServletContentListener监听初销毁...");
    }
}

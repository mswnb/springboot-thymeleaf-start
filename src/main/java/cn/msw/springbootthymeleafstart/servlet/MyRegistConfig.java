package cn.msw.springbootthymeleafstart.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author 毛送文
 * @Date 2021/1/22 16:15
 * @Version 1.0
 */
@Configuration
public class MyRegistConfig {
    @Bean
    public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean(new MyServlet(),"/my","/my02");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();
        //return new FilterRegistrationBean(myFilter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContentListener myListener=new MyServletContentListener();
        return new ServletListenerRegistrationBean(myListener);

    }

}

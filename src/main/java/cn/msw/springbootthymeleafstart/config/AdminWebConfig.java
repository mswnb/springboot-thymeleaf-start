package cn.msw.springbootthymeleafstart.config;

import cn.msw.springbootthymeleafstart.interceptor.LoginInterceptor;
import cn.msw.springbootthymeleafstart.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author 毛送文
 * @Date 2021/1/20 19:32
 * @Version 1.0
 */

/**
 * 1、编写一个拦截器实现HandLerInterceptor接口
 * 2、拦截器注册到容器中（实现webMvcConfigurer的addInterceptors )
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 * @author 86188
 */
@Configuration
//@EnableWebMvc
public class AdminWebConfig implements WebMvcConfigurer {
    /**
     * Filter. interceptor 几乎拥有相同的功能?
     * 1、Filter是servlet定义的原生组件。好处，脱离Spring应用也能使用
     * 2、Interceptor是Spring定义的接口。可以使用Spring的自动装配等功能
     */
    @Autowired
    private RedisUrlCountInterceptor redisUrlCountInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**");
        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/aa/**")
                .addResourceLocations("classpath:/static/");
    }
}

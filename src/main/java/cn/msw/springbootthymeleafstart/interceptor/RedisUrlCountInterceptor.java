package cn.msw.springbootthymeleafstart.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author 毛送文
 * @Date 2021/1/24 22:08
 * @Version 1.0
 */
@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        /**
         * 默认每次访问uri，记数加1
         */
        redisTemplate.opsForValue().increment(uri);
        return true;
    }
}

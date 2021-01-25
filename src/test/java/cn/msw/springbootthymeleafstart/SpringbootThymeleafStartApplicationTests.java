package cn.msw.springbootthymeleafstart;

import cn.msw.springbootthymeleafstart.bean.Account;
import cn.msw.springbootthymeleafstart.bean.UserPlus;
import cn.msw.springbootthymeleafstart.mapper.UserPlusMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
@Slf4j
@SpringBootTest
class SpringbootThymeleafStartApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Autowired
    UserPlusMapper userPlusMapper;

    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Test
    void contextLoads() {
        List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accounts) {
           //log.info("{}",account);
            log.info("数据源{}",dataSource.getClass());
        }
    }
    @Test
    void testMyBatisPlus(){
        UserPlus userPlus = userPlusMapper.selectById(3L);
        log.info("用户信息{}",userPlus);
    }

    @Test
    void testRedis(){
        ValueOperations<String, String> operations= redisTemplate.opsForValue();
        operations.set("hello","world");
        String hello = operations.get("hello");
        log.info("redis:{}",hello);
        log.info("连接对象:{}",redisConnectionFactory.getClass());
    }

}

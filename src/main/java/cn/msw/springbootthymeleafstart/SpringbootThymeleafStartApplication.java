package cn.msw.springbootthymeleafstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author 86188
 */
@MapperScan("cn.msw.springbootthymeleafstart.mapper")
@SpringBootApplication
@ServletComponentScan(basePackages = "cn.msw")
public class SpringbootThymeleafStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootThymeleafStartApplication.class, args);
    }

}

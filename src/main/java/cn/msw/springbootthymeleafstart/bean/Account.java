package cn.msw.springbootthymeleafstart.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author 毛送文
 * @Date 2021/1/23 18:07
 * @Version 1.0
 */
@Data
public class Account {
    private Integer id;
    private String name;
    private BigDecimal money;
}

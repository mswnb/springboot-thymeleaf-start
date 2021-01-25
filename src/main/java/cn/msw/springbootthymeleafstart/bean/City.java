package cn.msw.springbootthymeleafstart.bean;

import lombok.Data;

/**
 * @Author 毛送文
 * @Date 2021/1/24 16:27
 * @Version 1.0
 */
@Data
public class City {
    private Long id;
    private String name;
    private String state;
    private String country;
}

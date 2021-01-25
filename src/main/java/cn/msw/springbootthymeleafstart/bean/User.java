package cn.msw.springbootthymeleafstart.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 毛送文
 * @Date 2021/1/17 15:25
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private String password;
}

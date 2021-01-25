package cn.msw.springbootthymeleafstart.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 毛送文
 * @Date 2021/1/24 18:10
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPlus {
    private Long id;
//    @TableField(exist = false)
    private String name;
    private Integer age;
    private String email;
}

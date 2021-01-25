package cn.msw.springbootthymeleafstart.mapper;

import cn.msw.springbootthymeleafstart.bean.Account;

/**
 * @Author 毛送文
 * @Date 2021/1/24 14:55
 * @Version 1.0
 */
//@Mapper
public interface AccountMapper {
    Account getAccount(Long id);
}

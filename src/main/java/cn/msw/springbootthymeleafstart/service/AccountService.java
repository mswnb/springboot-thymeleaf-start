package cn.msw.springbootthymeleafstart.service;

import cn.msw.springbootthymeleafstart.bean.Account;

/**
 * @Author 毛送文
 * @Date 2021/1/24 19:24
 * @Version 1.0
 */
public interface AccountService {
    Account getAcctById(Long id);
}

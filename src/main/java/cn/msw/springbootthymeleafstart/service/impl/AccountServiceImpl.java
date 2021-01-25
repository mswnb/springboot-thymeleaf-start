package cn.msw.springbootthymeleafstart.service.impl;

import cn.msw.springbootthymeleafstart.bean.Account;
import cn.msw.springbootthymeleafstart.mapper.AccountMapper;
import cn.msw.springbootthymeleafstart.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 毛送文
 * @Date 2021/1/24 15:05
 * @Version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Account getAcctById(Long id){
        return accountMapper.getAccount(id);
    }
}

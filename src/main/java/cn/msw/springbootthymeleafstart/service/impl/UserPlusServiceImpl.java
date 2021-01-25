package cn.msw.springbootthymeleafstart.service.impl;

import cn.msw.springbootthymeleafstart.bean.UserPlus;
import cn.msw.springbootthymeleafstart.mapper.UserPlusMapper;
import cn.msw.springbootthymeleafstart.service.UserPlusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 毛送文
 * @Date 2021/1/24 19:22
 * @Version 1.0
 */
@Service
public class UserPlusServiceImpl extends ServiceImpl<UserPlusMapper, UserPlus> implements UserPlusService {
    @Autowired
    private UserPlusMapper userPlusMapper;



}

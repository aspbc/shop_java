package com.shop.shop_java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shop_java.entity.User;
import com.shop.shop_java.mapper.UserMapper;
import com.shop.shop_java.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

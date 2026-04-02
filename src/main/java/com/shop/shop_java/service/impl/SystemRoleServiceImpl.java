package com.shop.shop_java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shop_java.entity.SystemRole;
import com.shop.shop_java.mapper.SystemRoleMapper;
import com.shop.shop_java.service.SystemRoleService;
import org.springframework.stereotype.Service;

@Service
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole> implements SystemRoleService {
}

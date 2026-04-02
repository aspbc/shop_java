package com.shop.shop_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shop_java.entity.SystemMenus;
import com.shop.shop_java.mapper.SystemMenusMapper;
import com.shop.shop_java.service.SystemMenusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SystemMenusServiceImpl extends ServiceImpl<SystemMenusMapper, SystemMenus> implements SystemMenusService {

    @Override
    public List<SystemMenus> getMenuTree(Integer type, Integer isShow) {
        LambdaQueryWrapper<SystemMenus> wrapper = new LambdaQueryWrapper<>();
        if (type != null) {
            wrapper.eq(SystemMenus::getType, type);
        }
        if (isShow != null) {
            wrapper.eq(SystemMenus::getIsShow, isShow);
        }
        wrapper.orderByAsc(SystemMenus::getSort);
        
        List<SystemMenus> allMenus = this.list(wrapper);
        
        // TODO: Build actual nested tree structure if required by frontend, 
        // or return flat list and let frontend build it. 
        // We will return flat for now.
        return allMenus;
    }
}

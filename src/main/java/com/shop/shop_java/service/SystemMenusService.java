package com.shop.shop_java.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shop_java.entity.SystemMenus;
import java.util.List;

public interface SystemMenusService extends IService<SystemMenus> {
    List<SystemMenus> getMenuTree(Integer type, Integer isShow);
}

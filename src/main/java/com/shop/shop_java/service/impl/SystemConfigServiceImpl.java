package com.shop.shop_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shop_java.entity.SystemConfig;
import com.shop.shop_java.mapper.SystemConfigMapper;
import com.shop.shop_java.service.SystemConfigService;
import org.springframework.stereotype.Service;

@Service
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {

    @Override
    public String getValueByKey(String menuName) {
        LambdaQueryWrapper<SystemConfig> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemConfig::getMenuName, menuName);
        SystemConfig config = this.getOne(wrapper);
        return config != null ? config.getValue() : null;
    }

    @Override
    public boolean saveOrUpdateValue(String menuName, String value) {
        LambdaQueryWrapper<SystemConfig> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SystemConfig::getMenuName, menuName);
        SystemConfig config = this.getOne(wrapper);
        
        if (config != null) {
            config.setValue(value);
            return this.updateById(config);
        } else {
            SystemConfig newConfig = new SystemConfig();
            newConfig.setMenuName(menuName);
            newConfig.setValue(value);
            newConfig.setStatus(1);
            return this.save(newConfig);
        }
    }
}

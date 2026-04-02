package com.shop.shop_java.controller;

import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.SystemConfig;
import com.shop.shop_java.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/system/config")
public class SystemConfigController {

    @Autowired
    private SystemConfigService systemConfigService;

    @GetMapping("/list")
    public Result<List<SystemConfig>> list() {
        return Result.success(systemConfigService.list());
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody SystemConfig config) {
        return Result.success(systemConfigService.saveOrUpdate(config));
    }

    @PostMapping("/saveValues")
    public Result<Boolean> saveValues(@RequestBody Map<String, String> configMap) {
        for (Map.Entry<String, String> entry : configMap.entrySet()) {
            systemConfigService.saveOrUpdateValue(entry.getKey(), entry.getValue());
        }
        return Result.success(true);
    }
}

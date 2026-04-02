package com.shop.shop_java.controller;

import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.SystemRole;
import com.shop.shop_java.service.SystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/system/role")
public class SystemRoleController {

    @Autowired
    private SystemRoleService systemRoleService;

    @GetMapping("/list")
    public Result<List<SystemRole>> list() {
        return Result.success(systemRoleService.list());
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody SystemRole role) {
        return Result.success(systemRoleService.saveOrUpdate(role));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(systemRoleService.removeById(id));
    }
}

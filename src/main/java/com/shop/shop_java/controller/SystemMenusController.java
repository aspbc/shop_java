package com.shop.shop_java.controller;

import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.SystemMenus;
import com.shop.shop_java.service.SystemMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/system/menus")
public class SystemMenusController {

    @Autowired
    private SystemMenusService systemMenusService;

    @GetMapping("/list")
    public Result<List<SystemMenus>> list(@RequestParam(required = false) Integer type,
                                          @RequestParam(required = false) Integer isShow) {
        return Result.success(systemMenusService.getMenuTree(type, isShow));
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody SystemMenus menu) {
        return Result.success(systemMenusService.saveOrUpdate(menu));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(systemMenusService.removeById(id));
    }
}

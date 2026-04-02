package com.shop.shop_java.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.User;
import com.shop.shop_java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Result<Page<User>> list(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "15") Integer limit,
                                   @RequestParam(required = false) String keyword) {
        Page<User> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        if (keyword != null && !keyword.isEmpty()) {
            wrapper.like(User::getNickname, keyword).or().like(User::getPhone, keyword);
        }
        wrapper.orderByDesc(User::getUid);
        return Result.success(userService.page(pageParam, wrapper));
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody User user) {
        return Result.success(userService.saveOrUpdate(user));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(userService.removeById(id));
    }
}

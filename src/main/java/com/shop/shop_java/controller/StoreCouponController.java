package com.shop.shop_java.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.StoreCoupon;
import com.shop.shop_java.service.StoreCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/store/coupon")
public class StoreCouponController {

    @Autowired
    private StoreCouponService storeCouponService;

    @GetMapping("/list")
    public Result<Page<StoreCoupon>> list(@RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "15") Integer limit,
                                          @RequestParam(required = false) String title) {
        Page<StoreCoupon> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<StoreCoupon> wrapper = new LambdaQueryWrapper<>();
        
        if (title != null && !title.isEmpty()) {
            wrapper.like(StoreCoupon::getCouponTitle, title);
        }
        wrapper.orderByDesc(StoreCoupon::getId);
        return Result.success(storeCouponService.page(pageParam, wrapper));
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody StoreCoupon coupon) {
        return Result.success(storeCouponService.saveOrUpdate(coupon));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(storeCouponService.removeById(id));
    }
}

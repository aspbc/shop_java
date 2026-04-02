package com.shop.shop_java.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.StoreProduct;
import com.shop.shop_java.service.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/store/product")
public class StoreProductController {

    @Autowired
    private StoreProductService storeProductService;

    @GetMapping("/list")
    public Result<Page<StoreProduct>> list(@RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "15") Integer limit,
                                           @RequestParam(required = false) String keyword,
                                           @RequestParam(required = false) Integer isShow) {
        Page<StoreProduct> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<StoreProduct> wrapper = new LambdaQueryWrapper<>();
        // 过滤掉已删除的
        // wrapper.eq(StoreProduct::getIsDel, 0); 
        
        if (keyword != null && !keyword.isEmpty()) {
            wrapper.like(StoreProduct::getStoreName, keyword).or().like(StoreProduct::getKeyword, keyword);
        }
        if (isShow != null) {
            wrapper.eq(StoreProduct::getIsShow, isShow);
        }
        wrapper.orderByDesc(StoreProduct::getId);
        return Result.success(storeProductService.page(pageParam, wrapper));
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody StoreProduct product) {
        if (product.getAddTime() == null) {
            product.setAddTime((int) (System.currentTimeMillis() / 1000));
        }
        return Result.success(storeProductService.saveOrUpdate(product));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        // 通常是软删除，这里演示直接删除或可以改为软删除逻辑
        return Result.success(storeProductService.removeById(id));
    }
}

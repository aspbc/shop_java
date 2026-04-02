package com.shop.shop_java.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.Supplier;
import com.shop.shop_java.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/list")
    public Result<Page<Supplier>> list(@RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "15") Integer limit,
                                       @RequestParam(required = false) String keyword) {
        Page<Supplier> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<Supplier> wrapper = new LambdaQueryWrapper<>();
        // wrapper.eq(Supplier::getIsDel, 0);
        
        if (keyword != null && !keyword.isEmpty()) {
            wrapper.like(Supplier::getSupplierName, keyword).or().like(Supplier::getPhone, keyword);
        }
        wrapper.orderByDesc(Supplier::getId);
        return Result.success(supplierService.page(pageParam, wrapper));
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody Supplier supplier) {
        if (supplier.getAddTime() == null) {
            supplier.setAddTime(String.valueOf(System.currentTimeMillis() / 1000));
        }
        return Result.success(supplierService.saveOrUpdate(supplier));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(supplierService.removeById(id));
    }
}

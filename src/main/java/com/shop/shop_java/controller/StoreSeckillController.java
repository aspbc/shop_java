package com.shop.shop_java.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.StoreSeckill;
import com.shop.shop_java.service.StoreSeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/store/seckill")
public class StoreSeckillController {

    @Autowired
    private StoreSeckillService storeSeckillService;

    @GetMapping("/list")
    public Result<Page<StoreSeckill>> list(@RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "15") Integer limit,
                                           @RequestParam(required = false) String title) {
        Page<StoreSeckill> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<StoreSeckill> wrapper = new LambdaQueryWrapper<>();
        
        if (title != null && !title.isEmpty()) {
            wrapper.like(StoreSeckill::getTitle, title);
        }
        wrapper.orderByDesc(StoreSeckill::getId);
        return Result.success(storeSeckillService.page(pageParam, wrapper));
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody StoreSeckill seckill) {
        return Result.success(storeSeckillService.saveOrUpdate(seckill));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(storeSeckillService.removeById(id));
    }
}

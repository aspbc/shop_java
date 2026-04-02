package com.shop.shop_java.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.StoreCombination;
import com.shop.shop_java.service.StoreCombinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/store/combination")
public class StoreCombinationController {

    @Autowired
    private StoreCombinationService storeCombinationService;

    @GetMapping("/list")
    public Result<Page<StoreCombination>> list(@RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "15") Integer limit,
                                               @RequestParam(required = false) String title) {
        Page<StoreCombination> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<StoreCombination> wrapper = new LambdaQueryWrapper<>();
        
        if (title != null && !title.isEmpty()) {
            wrapper.like(StoreCombination::getTitle, title);
        }
        wrapper.orderByDesc(StoreCombination::getId);
        return Result.success(storeCombinationService.page(pageParam, wrapper));
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody StoreCombination combination) {
        return Result.success(storeCombinationService.saveOrUpdate(combination));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(storeCombinationService.removeById(id));
    }
}

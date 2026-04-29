package com.shop.shop_java.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.StoreProductDescription;
import com.shop.shop_java.service.StoreProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/store/product/description")
public class StoreProductDescriptionController {
    @Autowired
    private StoreProductDescriptionService descriptionService;

    @GetMapping("/{productId}")
    public Result<StoreProductDescription> get(@PathVariable Integer productId,
                                               @RequestParam(defaultValue = "0") Integer type) {
        StoreProductDescription desc = descriptionService.getOne(new LambdaQueryWrapper<StoreProductDescription>()
                .eq(StoreProductDescription::getProductId, productId)
                .eq(StoreProductDescription::getType, type), false);
        if (desc == null) {
            desc = new StoreProductDescription();
            desc.setProductId(productId);
            desc.setType(type);
            desc.setDescription("");
        }
        return Result.success(desc);
    }

    @PostMapping("/save")
    public Result<Boolean> save(@RequestBody StoreProductDescription desc) {
        if (desc.getType() == null) {
            desc.setType(0);
        }
        return Result.success(descriptionService.saveOrUpdate(desc));
    }
}


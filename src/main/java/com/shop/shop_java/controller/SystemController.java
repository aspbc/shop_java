package com.shop.shop_java.controller;

import com.shop.shop_java.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/system")
public class SystemController {

    @GetMapping("/info")
    public Result<String> getSystemInfo() {
        return Result.success("Shop Java Backend API is running!");
    }
}

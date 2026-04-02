package com.shop.shop_java.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.shop_java.common.Result;
import com.shop.shop_java.entity.SystemAttachment;
import com.shop.shop_java.service.SystemAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin/system/attachment")
public class SystemAttachmentController {

    @Autowired
    private SystemAttachmentService systemAttachmentService;

    @GetMapping("/list")
    public Result<Page<SystemAttachment>> list(@RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "15") Integer limit,
                                               @RequestParam(required = false) Integer pid) {
        Page<SystemAttachment> pageParam = new Page<>(page, limit);
        LambdaQueryWrapper<SystemAttachment> wrapper = new LambdaQueryWrapper<>();
        if (pid != null) {
            wrapper.eq(SystemAttachment::getPid, pid);
        }
        wrapper.orderByDesc(SystemAttachment::getAttId);
        return Result.success(systemAttachmentService.page(pageParam, wrapper));
    }

    @PostMapping("/upload")
    public Result<SystemAttachment> upload(@RequestParam("file") MultipartFile file,
                                           @RequestParam(required = false) Integer pid) {
        if (file.isEmpty()) {
            return Result.error(400, "File is empty");
        }
        return Result.success(systemAttachmentService.upload(file, pid));
    }

    @DeleteMapping("/delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(systemAttachmentService.removeById(id));
    }
}

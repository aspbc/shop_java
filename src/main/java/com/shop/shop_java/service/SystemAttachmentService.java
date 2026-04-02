package com.shop.shop_java.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shop.shop_java.entity.SystemAttachment;
import org.springframework.web.multipart.MultipartFile;

public interface SystemAttachmentService extends IService<SystemAttachment> {
    SystemAttachment upload(MultipartFile file, Integer pid);
}

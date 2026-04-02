package com.shop.shop_java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shop_java.entity.SystemAttachment;
import com.shop.shop_java.mapper.SystemAttachmentMapper;
import com.shop.shop_java.service.SystemAttachmentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;
import java.io.File;
import java.io.IOException;

@Service
public class SystemAttachmentServiceImpl extends ServiceImpl<SystemAttachmentMapper, SystemAttachment> implements SystemAttachmentService {

    @Override
    public SystemAttachment upload(MultipartFile file, Integer pid) {
        // Simple local upload mock for demonstration
        String originalName = file.getOriginalFilename();
        String ext = originalName.substring(originalName.lastIndexOf("."));
        String newName = UUID.randomUUID().toString() + ext;
        
        // TODO: integrate with actual OSS/COS based on SystemConfig settings
        String url = "/uploads/" + newName;
        
        SystemAttachment attachment = new SystemAttachment();
        attachment.setName(originalName);
        attachment.setAttDir(url);
        attachment.setSattDir(url);
        attachment.setAttSize(String.valueOf(file.getSize()));
        attachment.setAttType(file.getContentType());
        attachment.setPid(pid == null ? 0 : pid);
        attachment.setTime((int) (System.currentTimeMillis() / 1000));
        attachment.setImageType(1); // 1 for local
        attachment.setType(1); // platform
        attachment.setFileType(1); // image
        
        this.save(attachment);
        return attachment;
    }
}

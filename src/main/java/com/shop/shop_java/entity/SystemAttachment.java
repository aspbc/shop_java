package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("eb_system_attachment")
public class SystemAttachment {
    @TableId(value = "att_id", type = IdType.AUTO)
    private Integer attId;
    
    private Integer type; // 类型：1平台2:门店
    
    private Integer fileType; // 文件类型：1:图片2：视频
    
    private Integer relationId; // 关联id
    
    private String name; // 附件名称
    
    private String attDir; // 附件路径
    
    private String sattDir; // 压缩图片路径
    
    private String attSize; // 附件大小
    
    private String attType; // 附件类型
    
    private Integer pid; // 分类ID
    
    private Integer time; // 上传时间
    
    private Integer imageType; // 图片上传类型 1本地 2阿里云 3腾讯云 4七牛云
}

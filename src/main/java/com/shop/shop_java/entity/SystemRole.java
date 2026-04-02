package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("eb_system_role")
public class SystemRole {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer type; // 类型：0平台 2:供应商
    
    private Integer relationId; // 门店、供应商id
    
    private String roleName; // 身份管理名称
    
    private String rules; // 身份管理权限(menus_id)
    
    private Integer level;
    
    private Integer status; // 状态 1正常 0禁用
}

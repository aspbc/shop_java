package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("eb_system_supplier")
public class Supplier {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer adminId; // 管理员ID
    
    private String supplierName; // 供应商名称
    
    private String avatar; // 头像
    
    private String name; // 联系人姓名
    
    private String phone; // 联系电话
    
    private String email; // 邮箱
    
    private String address; // 省市区
    
    private Integer province; // 省ID
    
    private Integer city; // 市ID
    
    private Integer area; // 区ID
    
    private Integer street; // 街道ID
    
    private String detailedAddress; // 详细地址
    
    private String mark; // 备注
    
    private Integer sort; // 排序
    
    private Integer isShow; // 是否显示
    
    private Integer isDel; // 是否删除
    
    private String addTime; // 添加时间
}

package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("eb_system_config")
public class SystemConfig {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer isStore; // 0=总后台,1=门店
    
    private String menuName; // 字段名称
    
    private String type; // 类型(文本框,单选按钮...)
    
    private String inputType; // 表单类型
    
    private Integer configTabId; // 配置分类id
    
    private String parameter; // 规则 单选框和多选框
    
    private Integer uploadType; // 上传文件格式1单图2多图3文件
    
    private String required; // 规则
    
    private String value; // 配置值
    
    private String info; // 配置说明
    
    private String desc; // 配置简介
    
    private Integer sort; // 排序
    
    private Integer status; // 是否隐藏
}

package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("eb_system_menus")
public class SystemMenus {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer pid; // 父级id
    
    private Integer type; // 菜单类型1:平台2:门店
    
    private String icon; // 图标
    
    private String menuName; // 按钮名/菜单名
    
    private String module; // 模块名
    
    private String controller; // 控制器
    
    private String action; // 方法名
    
    private String apiUrl; // api接口地址
    
    private String methods; // 提交方式POST GET PUT DELETE
    
    private String params; // 参数
    
    private Integer sort; // 排序
    
    private Integer isShow; // 是否为隐藏菜单0=隐藏菜单,1=显示菜单
    
    private Integer isShowPath; // 是否为隐藏菜单供前台使用
    
    private Integer access; // 子管理员是否可用
    
    private String menuPath; // 路由名称 前端使用
    
    private String path; // 路径
    
    private Integer authType; // 是否为菜单 1菜单 2功能
}

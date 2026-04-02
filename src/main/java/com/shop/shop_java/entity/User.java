package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("eb_user")
public class User {
    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid;
    
    private String account;
    
    private String pwd;
    
    private String realName;
    
    private String birthday;
    
    private String cardId;
    
    private String mark;
    
    private Integer partnerId;
    
    private Integer groupId;
    
    private String nickname;
    
    private String avatar;
    
    private String phone;
    
    private Integer addTime;
    
    private String addIp;
    
    private Integer lastTime;
    
    private String lastIp;
    
    private Double nowMoney;
    
    private Double brokeragePrice;
    
    private Integer integral;
    
    private Integer signNum;
    
    private Integer status;
    
    private Integer level;
    
    private Integer spreadUid;
    
    private Integer isPromoter;
}

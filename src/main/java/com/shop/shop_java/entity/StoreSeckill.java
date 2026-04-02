package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigDecimal;

@Data
@TableName("eb_store_seckill")
public class StoreSeckill {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer activityId; // 活动ID
    
    private Integer type; // 商品所属：0：平台1:门店2:供应商
    
    private Integer productId; // 商品id
    
    private String title; // 活动标题
    
    private String info; // 简介
    
    private String image; // 推荐图
    
    private BigDecimal price; // 秒杀价
    
    private BigDecimal otPrice; // 原价
    
    private Integer stock; // 秒杀库存
    
    private Integer sales; // 销量
    
    private Integer quota; // 限购数量
    
    private Integer startTime; // 开始时间
    
    private Integer stopTime; // 结束时间
    
    private Integer timeId; // 秒杀时间段配置ID
    
    private Integer status; // 状态：1开启 0关闭
    
    private Integer isShow; // 是否显示
}

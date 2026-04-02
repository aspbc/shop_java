package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigDecimal;

@Data
@TableName("eb_store_combination")
public class StoreCombination {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer type; // 商品所属：0：平台1:门店2:供应商
    
    private Integer productId; // 商品id
    
    private Integer relationId; // 关联供应商ID
    
    private String image; // 推荐图
    
    private String title; // 活动标题
    
    private Integer people; // 参团人数
    
    private String info; // 简介
    
    private BigDecimal price; // 拼团价
    
    private Integer sort; // 排序
    
    private Integer sales; // 销量
    
    private Integer stock; // 库存
    
    private Integer isShow; // 状态 1显示 0隐藏
    
    private Integer startTime; // 开始时间
    
    private Integer stopTime; // 结束时间
}

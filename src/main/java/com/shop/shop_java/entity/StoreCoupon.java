package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigDecimal;

@Data
@TableName("eb_store_coupon_issue")
public class StoreCoupon {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer cid; // 优惠券ID
    
    private Integer category; // 优惠券种类：1 普通券，2会员券
    
    private Integer type; // 优惠券类型 0-通用 1-品类券 2-商品券 3-品牌
    
    private Integer receiveType; // 1 手动领取，2 新人券，3赠送券
    
    private Integer couponType; // 1:满减券2:折扣券
    
    private String couponTitle; // 优惠券名称
    
    private Integer startTime; // 领取开启时间
    
    private Integer endTime; // 领取结束时间
    
    private Integer totalCount; // 发放总数
    
    private Integer remainCount; // 剩余数量
    
    private BigDecimal couponPrice; // 优惠金额/折扣
    
    private BigDecimal useMinPrice; // 最低消费多少金额可用
    
    private Integer status; // 状态 1有效 0无效
}

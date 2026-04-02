package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("eb_store_product")
public class StoreProduct {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private Integer pid;
    
    private Integer type; // 商品所属：0：平台1:门店2:供应商
    
    private Integer productType; // 商品类型0:普通商品，1：卡密，2：优惠券，3：虚拟商品,4：次卡商品
    
    private Integer relationId; // 关联门店、供应商ID
    
    private Integer merId; // 商户Id
    
    private String image; // 商品图片
    
    private String recommendImage; // 推荐图
    
    private String sliderImage; // 轮播图
    
    private String storeName; // 商品名称
    
    private String storeInfo; // 商品简介
    
    private String keyword; // 关键字
    
    private String barCode; // 商品条码
    
    private String cateId; // 分类id
    
    private Double price; // 商品价格
    
    private Double vipPrice; // 会员价格
    
    private Double otPrice; // 市场价
    
    private Double postage; // 邮费
    
    private String unitName; // 单位名
    
    private Integer sort; // 排序
    
    private Integer sales; // 销量
    
    private Integer stock; // 库存
    
    private Integer isShow; // 状态（0：未上架，1：上架）
    
    private Integer isHot; // 是否热卖
    
    private Integer isBenefit; // 是否促销
    
    private Integer isBest; // 是否精品
    
    private Integer isNew; // 是否新品
    
    private Integer addTime; // 添加时间
    
    private Integer isPostage; // 是否包邮
    
    private Integer isDel; // 是否删除
}

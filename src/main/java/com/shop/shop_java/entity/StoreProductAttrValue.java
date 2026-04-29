package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("eb_store_product_attr_value")
public class StoreProductAttrValue {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer productId;
    @TableField("suk")
    private String sku;
    private String unique;
    private String image;
    private BigDecimal price;
    private BigDecimal cost;
    private BigDecimal settlePrice;
    private BigDecimal otPrice;
    private Integer stock;
    private String barCode;
    private BigDecimal weight;
    private String code;
}

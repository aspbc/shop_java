package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("eb_store_product_description")
public class StoreProductDescription {
    @TableId(value = "product_id", type = IdType.INPUT)
    private Integer productId;
    private String description;
    private Integer type;
}


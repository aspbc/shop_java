package com.shop.shop_java.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("eb_store_product")
public class StoreProduct {
    @TableId(type = IdType.AUTO)
    private Integer id; // 商品ID
    private Integer pid; // 关联平台商品ID
    private Integer type; // 商品归属：0=平台，1=门店，2=供应商
    private Integer productType; // 商品类型：0=普通商品，1=卡密，2=优惠券，3=虚拟商品，4=次卡商品
    private Integer relationId; // 关联门店/供应商ID
    private Integer merId; // 商户ID(平台默认0)
    private String storeName; // 商品名称
    private String storeInfo; // 商品简介
    @TableField(exist = false)
    private String description;
    private String keyword; // 商品关键字
    private String image; // 商品主图
    private String recommendImage;
    private String sliderImage; // 商品轮播图(多张图的JSON数组或逗号分隔)
    private BigDecimal price; // 商品售价
    private BigDecimal settlePrice;
    private BigDecimal vipPrice;
    private BigDecimal otPrice; // 商品市场价
    private BigDecimal cost; // 成本价
    private String deliveryType;
    private Integer freight;
    private BigDecimal postage;
    private Integer tempId;
    private Integer isPostage;
    private Integer sales; // 销量
    private Integer ficti; // 虚拟销量
    private Integer stock; // 库存
    private Integer sort; // 排序权重(越大越靠前)
    private Integer specType; // 规格类型：0=单规格，1=多规格
    private String activity;
    private String spu;
    private String labelId;
    private String commandWord;
    private String recommendList;
    private Integer collect; // 收藏数
    private Integer isShow; // 是否上架：0=下架(仓库中)，1=上架(销售中)
    private Integer isDel; // 是否删除：0=正常，1=已删除(放入回收站)
    private Integer isVerify; // 审核状态：1=审核通过，0=待审核，-1=审核未通过，-2=强制下架
    private String refusal;
    private Integer isSold; // 是否售罄：0=正常，1=已售罄
    private Integer isPolice; // 是否触发库存预警：0=正常，1=预警
    private String cateId; // 商品分类ID(支持逗号分隔多个分类)
    private Integer brandId; // 商品品牌ID
    private String brandCom;
    private String unitName; // 商品单位(如：件、个、瓶等)
    private String code; // 商品编码(商家自定义SKU等)
    private String barCode; // 商品条形码(扫描码)
    private Integer addTime; // 添加时间(Unix时间戳)
    private Integer videoOpen;
    private String videoLink;
    private Integer isVipProduct;
    private Integer isChannelProduct;
    private Integer isGeneralProduct;
    private Integer isPresaleProduct;
    private Integer presaleStartTime;
    private Integer presaleEndTime;
    private Integer presaleDay;
    private Integer autoOnTime;
    private Integer autoOffTime;
    private BigDecimal giveIntegral;
    private Integer isVip;
    private String storeLabelId;
    private String ensureId;
    private String specs;
    private Integer specsId;
    private Integer isLimit;
    private Integer limitType;
    private Integer limitNum;
    private Integer isSupportRefund;
}

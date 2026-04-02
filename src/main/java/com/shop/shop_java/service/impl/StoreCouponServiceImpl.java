package com.shop.shop_java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shop_java.entity.StoreCoupon;
import com.shop.shop_java.mapper.StoreCouponMapper;
import com.shop.shop_java.service.StoreCouponService;
import org.springframework.stereotype.Service;

@Service
public class StoreCouponServiceImpl extends ServiceImpl<StoreCouponMapper, StoreCoupon> implements StoreCouponService {
}

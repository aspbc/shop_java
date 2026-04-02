package com.shop.shop_java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shop_java.entity.StoreProduct;
import com.shop.shop_java.mapper.StoreProductMapper;
import com.shop.shop_java.service.StoreProductService;
import org.springframework.stereotype.Service;

@Service
public class StoreProductServiceImpl extends ServiceImpl<StoreProductMapper, StoreProduct> implements StoreProductService {
}

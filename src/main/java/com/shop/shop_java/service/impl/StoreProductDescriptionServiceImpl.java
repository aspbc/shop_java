package com.shop.shop_java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shop_java.entity.StoreProductDescription;
import com.shop.shop_java.mapper.StoreProductDescriptionMapper;
import com.shop.shop_java.service.StoreProductDescriptionService;
import org.springframework.stereotype.Service;

@Service
public class StoreProductDescriptionServiceImpl extends ServiceImpl<StoreProductDescriptionMapper, StoreProductDescription> implements StoreProductDescriptionService {
}


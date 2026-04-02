package com.shop.shop_java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shop_java.entity.Supplier;
import com.shop.shop_java.mapper.SupplierMapper;
import com.shop.shop_java.service.SupplierService;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements SupplierService {
}

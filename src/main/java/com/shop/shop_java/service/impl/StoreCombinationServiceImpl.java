package com.shop.shop_java.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shop.shop_java.entity.StoreCombination;
import com.shop.shop_java.mapper.StoreCombinationMapper;
import com.shop.shop_java.service.StoreCombinationService;
import org.springframework.stereotype.Service;

@Service
public class StoreCombinationServiceImpl extends ServiceImpl<StoreCombinationMapper, StoreCombination> implements StoreCombinationService {
}

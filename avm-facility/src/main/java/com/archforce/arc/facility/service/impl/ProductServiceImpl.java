package com.archforce.arc.facility.service.impl;

import com.archforce.arc.facility.mapper.avm.ProductMapper;
import com.archforce.arc.facility.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List pageProducts() {
        return productMapper.selectAllProducts();
    }
}

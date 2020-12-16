package com.archforce.arc.facility.service.impl;

import com.archforce.arc.facility.entity.avm.Product;
import com.archforce.arc.facility.exception.ApplicationException;
import com.archforce.arc.facility.exception.BusinessException;
import com.archforce.arc.facility.mapper.avm.ProductMapper;
import com.archforce.arc.facility.service.ProductService;
import com.archforce.arc.facility.utils.QueryVo;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.archforce.arc.facility.exception.ErrorCodeConstant.PRODUCT_ENGSIMP_NAME_EXISTED;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Page<Product> getAllProduct(QueryVo<Product> queryVo) {
        queryVo.resetPage();

        Page<Product> products = productMapper.selectAllProducts();
        if (1==1) throw new BusinessException(PRODUCT_ENGSIMP_NAME_EXISTED);
        return products;
    }
}

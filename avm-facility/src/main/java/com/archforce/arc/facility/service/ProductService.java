package com.archforce.arc.facility.service;

import com.archforce.arc.facility.entity.avm.Product;
import com.archforce.arc.facility.utils.QueryVo;
import com.github.pagehelper.Page;

import java.util.List;

public interface ProductService {

    Page<Product> getAllProduct(QueryVo<Product> queryVo);
}

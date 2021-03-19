package com.archforce.arc.facility.service.product;

import com.archforce.arc.facility.entity.avm.product.Product;
import com.archforce.arc.facility.utils.QueryVo;
import com.github.pagehelper.Page;

import java.util.List;

public interface ProductService {

    Page<Product> getAllProduct(QueryVo<Product> queryVo);

    List<Product> getAllProductList();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    void deleteBatch(List<Integer> ids);
}




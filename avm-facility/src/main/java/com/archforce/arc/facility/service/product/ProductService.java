package com.archforce.arc.facility.service.product;

import com.archforce.arc.facility.entity.avm.Product;
import com.archforce.arc.facility.utils.QueryVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    Page<Product> getAllProduct(QueryVo<Product> queryVo);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    void deleteBatch(List<Integer> ids);
}




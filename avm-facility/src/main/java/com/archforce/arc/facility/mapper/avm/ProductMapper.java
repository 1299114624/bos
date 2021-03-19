package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.product.Product;import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    List<Product> selectAllProductList();

    Page<Product> selectAllProducts(Product query);

    void deleteBatch(@Param("ids") List<Integer> ids);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

}
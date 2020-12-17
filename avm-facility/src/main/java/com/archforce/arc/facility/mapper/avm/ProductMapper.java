package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.Product;
import com.github.pagehelper.Page;

public interface ProductMapper {
    Page<Product> selectAllProducts();

    int insertProduct(Product product);
}

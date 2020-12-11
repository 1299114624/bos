package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.Product;

import java.util.List;


public interface ProductMapper {
    List<Product> selectAllProducts();
}

package com.archforce.arc.facility.service.product;

import com.archforce.arc.facility.common.AvmTree;
import com.archforce.arc.facility.entity.avm.product.ProductFunction;
import java.util.List;
public interface ProductFunctionService{


    int deleteByPrimaryKey(Integer id);

    ProductFunction selectByPrimaryKey(Integer id);

    int batchInsert(List<ProductFunction> list);

    List<AvmTree> getProductFunction(Integer productId);

}

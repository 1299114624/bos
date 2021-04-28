package com.archforce.arc.facility.service.product;

import java.util.List;
import com.archforce.arc.facility.entity.avm.product.ProductComponent;
public interface ProductComponentService{


    int deleteByPrimaryKey(Integer id);

    ProductComponent selectByPrimaryKey(Integer id);

    int batchInsert(List<ProductComponent> list);

}

package com.archforce.arc.facility.service.product;

import java.util.List;

import com.archforce.arc.facility.entity.avm.product.ProductComponentInfo;
import com.archforce.arc.facility.entity.avm.product.ProductComponent;
import com.archforce.arc.common.utils.QueryVo;
import com.github.pagehelper.Page;

public interface ProductComponentService{


    int deleteByPrimaryKey(Integer id);

    ProductComponent selectByPrimaryKey(Integer id);

    int batchInsert(List<ProductComponent> list);

    Page<ProductComponentInfo> getProductCom(QueryVo<ProductComponentInfo> queryVo);

    List<ProductComponentInfo> getDisProductCom(ProductComponentInfo productComponentInfo);
}

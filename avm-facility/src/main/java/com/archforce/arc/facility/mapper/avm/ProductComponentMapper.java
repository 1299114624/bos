package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.product.ProductComponent;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductComponentMapper {
    int deleteByPrimaryKey(Integer id);

    ProductComponent selectByPrimaryKey(Integer id);

    int batchInsert(@Param("list") List<ProductComponent> list);
}
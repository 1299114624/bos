package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.function.Function;
import com.archforce.arc.facility.entity.avm.product.ProductFunction;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductFunctionMapper {
    int deleteByPrimaryKey(Integer id);

    ProductFunction selectByPrimaryKey(Integer id);

    String selectFunctionIdsByProductIds(Integer id);

    int batchInsert(@Param("list") List<ProductFunction> list);
}
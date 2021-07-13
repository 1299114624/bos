package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.company.CompanyProduct;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CompanyProductMapper {
    int deleteByCompanyId(Integer id);

    int batchInsert(@Param("list") List<CompanyProduct> list);

    String selectUsedCompanyNamesByProductId(Integer productId);

}
package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.company.CompanyComponent;
import java.util.List;

import com.archforce.arc.facility.entity.avm.company.CompanyComponentInfo;
import com.archforce.arc.facility.entity.avm.component.Component;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface CompanyComponentMapper {
    int deleteByPrimaryKey(Integer id);

    CompanyComponent selectByPrimaryKey(Integer id);

    int batchInsert(@Param("list") List<CompanyComponent> list);

    Page<CompanyComponentInfo> getCompanyCom(CompanyComponentInfo companyComponentInfo);

    List<CompanyComponentInfo> getDisCompanyCom(CompanyComponentInfo companyComponentInfo);
}
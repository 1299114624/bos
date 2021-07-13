package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.component.ComponentCompany;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ComponentCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByComponentId(Integer id);

    ComponentCompany selectByPrimaryKey(Integer id);

    String selectCompanyNamesByComponentId(Integer id);

    String selectCompanyIdsByComponentId(Integer id);

    List<ComponentCompany> selectByComponentId(Integer id);

    int batchInsert(@Param("list") List<ComponentCompany> list);

}
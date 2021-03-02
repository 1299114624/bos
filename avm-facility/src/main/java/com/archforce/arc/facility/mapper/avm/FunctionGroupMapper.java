package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.FunctionGroup;

public interface FunctionGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FunctionGroup record);

    FunctionGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FunctionGroup record);
}
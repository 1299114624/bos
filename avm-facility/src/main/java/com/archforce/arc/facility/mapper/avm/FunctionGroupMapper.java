package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.function.FunctionGroup;
import com.archforce.arc.facility.entity.vo.FunctionVo;

import java.util.List;

public interface FunctionGroupMapper {
    List<FunctionGroup> selectAllFunctionGroup();

    int deleteByPrimaryKey(Integer id);

    int deleteByParentCode(String code);

    FunctionGroup selectByPrimaryKey(Integer id);

    List<FunctionGroup> selectByParentCode(String code);

    int insertSelective(FunctionGroup record);

    int updateByPrimaryKeySelective(FunctionGroup record);
}
package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.function.FunctionFunctionGroup;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionFunctionGroupMapper {
    int insert(FunctionFunctionGroup record);

    int deleteByFunctionGroupId(Integer id);

    int deleteByFunctionId(Integer id);

    List<FunctionFunctionGroup> selectByFunctionGroupId(Integer id);

    FunctionFunctionGroup selectByFunctionId(Integer id);
}
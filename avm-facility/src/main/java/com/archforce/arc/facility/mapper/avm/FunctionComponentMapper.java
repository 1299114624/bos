package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.function.FunctionComponent;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionComponentMapper {
    int deleteByFunctionId(Integer id);

    int deleteBatchByComponentId(@Param("ids") List<Integer> ids);

    List<FunctionComponent> selectByFunctionId(Integer id);

    String selectFunctionNamesByComponentId(Integer id);

    int batchInsert(@Param("list") List<FunctionComponent> list);
}
package com.archforce.arc.facility.service.function;

import com.archforce.arc.facility.common.AvmTree;
import com.archforce.arc.facility.entity.avm.function.FunctionGroup;

import java.util.List;
import java.util.Map;

public interface FunctionGroupService{

    List<AvmTree> showTree();

    int deleteByPrimaryKey(Integer id, Map<String, List<Integer>> paramMap);

    int insertSelective(FunctionGroup record);

    FunctionGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FunctionGroup record);

}

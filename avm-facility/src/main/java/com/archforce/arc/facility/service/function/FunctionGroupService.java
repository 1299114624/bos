package com.archforce.arc.facility.service.function;

import com.archforce.arc.facility.entity.avm.function.FunctionGroup;
import com.archforce.arc.facility.common.AvmTree;

import java.util.List;

public interface FunctionGroupService{

    List<AvmTree> showTree();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(FunctionGroup record);

    FunctionGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FunctionGroup record);

    int checkAddType(Integer id);
}

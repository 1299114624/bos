package com.archforce.arc.facility.service.function;

import com.archforce.arc.facility.common.AvmTree;
import com.archforce.arc.facility.entity.avm.FunctionGroup;

import java.util.List;

public interface FunctionGroupService{

    List<AvmTree> showTree();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(FunctionGroup record);

    FunctionGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FunctionGroup record);

}

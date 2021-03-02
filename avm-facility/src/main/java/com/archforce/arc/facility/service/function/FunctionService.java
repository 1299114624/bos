package com.archforce.arc.facility.service.function;

import com.archforce.arc.facility.entity.avm.Function;
public interface FunctionService{


    int deleteByPrimaryKey(Integer id);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Function record);

}

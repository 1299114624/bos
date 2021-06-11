package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.Parameter;
import org.apache.ibatis.annotations.Param;

public interface ParameterMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Parameter record);

    int updateByPrimaryKey(Parameter record);

    Parameter selectByParamName(@Param("paramName") String paramName);
}
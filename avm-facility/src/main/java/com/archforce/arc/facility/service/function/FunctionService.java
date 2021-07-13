package com.archforce.arc.facility.service.function;

import com.archforce.arc.facility.entity.vo.FunctionVo;

public interface FunctionService{

    int deleteByPrimaryKey(Integer id);

    int insertSelective(FunctionVo record);

    FunctionVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FunctionVo record);

}

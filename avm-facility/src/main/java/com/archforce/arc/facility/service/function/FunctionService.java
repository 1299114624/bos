package com.archforce.arc.facility.service.function;

import com.archforce.arc.facility.entity.avm.function.Function;
import com.archforce.arc.facility.entity.vo.FunctionVo;

import java.util.List;

public interface FunctionService{

    int deleteByPrimaryKey(Integer id);

    int insertSelective(FunctionVo record);

    FunctionVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FunctionVo record);

}

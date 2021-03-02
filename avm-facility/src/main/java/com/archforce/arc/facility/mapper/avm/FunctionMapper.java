package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.Function;
import com.archforce.arc.facility.entity.vo.FunctionVo;

import java.util.List;

public interface FunctionMapper {
//    List<FunctionVo> selectAllFunctionVo();

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Function record);
}
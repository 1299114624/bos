package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.vo.FunctionVo;
import com.archforce.arc.facility.entity.avm.function.Function;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FunctionMapper {
    List<FunctionVo> selectAllFunctionVo();

    FunctionVo selectByPrimaryKey(Integer id);

    FunctionVo selectByFunctionName(String name);

    FunctionVo selectByFunctionCode(String code);

    int deleteBatch(@Param("ids") List<Integer> ids);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Function record);

    int updateByPrimaryKeySelective(Function record);
}
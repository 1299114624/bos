package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.avm.function.FunctionCompany;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionCompanyMapper {
    int deleteByFunctionId(Integer id);

    List<FunctionCompany> selectByFunctionId(Integer id);

    int batchInsert(@Param("list") List<FunctionCompany> list);
}
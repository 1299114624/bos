package com.archforce.domain.mapper;

import com.archforce.domain.entity.EnvironmentParameter;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnvironmentParameterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvironmentParameter record);

    int insertSelective(EnvironmentParameter record);

    EnvironmentParameter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvironmentParameter record);

    int updateByPrimaryKey(EnvironmentParameter record);

    int batchInsert(@Param("list") List<EnvironmentParameter> list);
}
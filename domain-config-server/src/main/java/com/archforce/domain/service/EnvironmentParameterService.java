package com.archforce.domain.service;

import java.util.List;
import com.archforce.domain.entity.EnvironmentParameter;
public interface EnvironmentParameterService{


    int deleteByPrimaryKey(Integer id);

    int insert(EnvironmentParameter record);

    int insertSelective(EnvironmentParameter record);

    EnvironmentParameter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvironmentParameter record);

    int updateByPrimaryKey(EnvironmentParameter record);

    int batchInsert(List<EnvironmentParameter> list);

}

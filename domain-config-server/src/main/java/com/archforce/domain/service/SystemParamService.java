package com.archforce.domain.service;

import java.util.List;
import com.archforce.domain.entity.SystemParam;
public interface SystemParamService{


    int deleteByPrimaryKey(Integer id);

    int insertSelective(SystemParam record);

    int updateByPrimaryKey(SystemParam record);

    int batchInsert(List<SystemParam> list);

}

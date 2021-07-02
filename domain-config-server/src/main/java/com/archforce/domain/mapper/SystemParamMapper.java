package com.archforce.domain.mapper;

import com.archforce.domain.entity.SystemParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemParamMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SystemParam record);

    int updateByPrimaryKey(SystemParam record);

    int batchInsert(@Param("list") List<SystemParam> list);
}
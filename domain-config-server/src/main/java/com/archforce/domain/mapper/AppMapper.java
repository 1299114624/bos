package com.archforce.domain.mapper;

import com.archforce.domain.entity.App;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppMapper {
    int deleteByPrimaryKey(Integer appId);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(Integer appId);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);

    int batchInsert(@Param("list") List<App> list);
}
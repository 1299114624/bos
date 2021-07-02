package com.archforce.domain.service;

import java.util.List;
import com.archforce.domain.entity.App;
public interface AppService{


    int deleteByPrimaryKey(Integer appId);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(Integer appId);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);

    int batchInsert(List<App> list);

}

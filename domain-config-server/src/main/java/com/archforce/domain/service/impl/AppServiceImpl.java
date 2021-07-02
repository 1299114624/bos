package com.archforce.domain.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.archforce.domain.mapper.AppMapper;
import com.archforce.domain.entity.App;
import com.archforce.domain.service.AppService;
@Service
public class AppServiceImpl implements AppService{

    @Resource
    private AppMapper appMapper;

    @Override
    public int deleteByPrimaryKey(Integer appId) {
        return appMapper.deleteByPrimaryKey(appId);
    }

    @Override
    public int insert(App record) {
        return appMapper.insert(record);
    }

    @Override
    public int insertSelective(App record) {
        return appMapper.insertSelective(record);
    }

    @Override
    public App selectByPrimaryKey(Integer appId) {
        return appMapper.selectByPrimaryKey(appId);
    }

    @Override
    public int updateByPrimaryKeySelective(App record) {
        return appMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(App record) {
        return appMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<App> list) {
        return appMapper.batchInsert(list);
    }

}

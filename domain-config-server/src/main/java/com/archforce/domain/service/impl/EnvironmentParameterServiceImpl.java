package com.archforce.domain.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.archforce.domain.entity.EnvironmentParameter;
import com.archforce.domain.mapper.EnvironmentParameterMapper;
import com.archforce.domain.service.EnvironmentParameterService;
@Service
public class EnvironmentParameterServiceImpl implements EnvironmentParameterService{

    @Resource
    private EnvironmentParameterMapper environmentParameterMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return environmentParameterMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(EnvironmentParameter record) {
        return environmentParameterMapper.insert(record);
    }

    @Override
    public int insertSelective(EnvironmentParameter record) {
        return environmentParameterMapper.insertSelective(record);
    }

    @Override
    public EnvironmentParameter selectByPrimaryKey(Integer id) {
        return environmentParameterMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(EnvironmentParameter record) {
        return environmentParameterMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(EnvironmentParameter record) {
        return environmentParameterMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<EnvironmentParameter> list) {
        return environmentParameterMapper.batchInsert(list);
    }

}

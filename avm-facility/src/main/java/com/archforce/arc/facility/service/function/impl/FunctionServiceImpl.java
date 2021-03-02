package com.archforce.arc.facility.service.function.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.entity.avm.Function;
import com.archforce.arc.facility.mapper.avm.FunctionMapper;
import com.archforce.arc.facility.service.function.FunctionService;
@Service
public class FunctionServiceImpl implements FunctionService{

    @Resource
    private FunctionMapper functionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return functionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Function record) {
        return functionMapper.insertSelective(record);
    }

    @Override
    public Function selectByPrimaryKey(Integer id) {
        return functionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Function record) {
        return functionMapper.updateByPrimaryKeySelective(record);
    }

}

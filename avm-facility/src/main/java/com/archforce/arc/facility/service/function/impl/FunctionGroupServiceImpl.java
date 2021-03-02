package com.archforce.arc.facility.service.function.impl;

import com.archforce.arc.facility.common.AvmTree;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.arc.facility.mapper.avm.FunctionGroupMapper;
import com.archforce.arc.facility.entity.avm.FunctionGroup;
import com.archforce.arc.facility.service.function.FunctionGroupService;

import java.util.List;

@Service
public class FunctionGroupServiceImpl implements FunctionGroupService{

    @Resource
    private FunctionGroupMapper functionGroupMapper;

    @Override
    public List<AvmTree> showTree() {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return functionGroupMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(FunctionGroup record) {
        return functionGroupMapper.insertSelective(record);
    }

    @Override
    public FunctionGroup selectByPrimaryKey(Integer id) {
        return functionGroupMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(FunctionGroup record) {
        return functionGroupMapper.updateByPrimaryKeySelective(record);
    }

}

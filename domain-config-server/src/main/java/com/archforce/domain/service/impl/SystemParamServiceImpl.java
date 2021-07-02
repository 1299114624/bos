package com.archforce.domain.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.archforce.domain.entity.SystemParam;
import com.archforce.domain.mapper.SystemParamMapper;
import com.archforce.domain.service.SystemParamService;
@Service
public class SystemParamServiceImpl implements SystemParamService{

    @Resource
    private SystemParamMapper systemParamMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return systemParamMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SystemParam record) {
        return systemParamMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(SystemParam record) {
        return systemParamMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<SystemParam> list) {
        return systemParamMapper.batchInsert(list);
    }

}

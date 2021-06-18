package com.archforce.bos.identity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.archforce.bos.identity.mapper.ResourceMapper;
import com.archforce.bos.identity.entity.Resource;
import com.archforce.bos.identity.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Resource record) {
        return resourceMapper.insert(record);
    }

    @Override
    public Resource selectByPrimaryKey(Integer id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Resource record) {
        return resourceMapper.updateByPrimaryKey(record);
    }

}

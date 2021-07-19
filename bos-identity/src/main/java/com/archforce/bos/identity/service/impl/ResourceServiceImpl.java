package com.archforce.bos.identity.service.impl;

import com.archforce.bos.identity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.archforce.bos.identity.mapper.ResourceMapper;
import com.archforce.bos.identity.entity.Resource;
import com.archforce.bos.identity.service.ResourceService;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private UserService userService;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Resource record) {
        return resourceMapper.insert(record);
    }

    @Override
    public Resource selectByPrimaryKey(Long id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Resource record) {
        return resourceMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Resource> getAllMenu() {
        List<Resource> resourceList = resourceMapper.getAllMenu();
        return resourceList;
    }

    @Override
    public List<Resource> getResourceByUserId(Long id) {
        List<Resource> resourceList = resourceMapper.getResourceByUserId(id);
        userService.resetResource(resourceList);
        return resourceList;
    }

}

package com.archforce.bos.identity.service;

import com.archforce.bos.identity.entity.Resource;

import java.util.List;

public interface ResourceService{

    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Resource record);

    /**
     * 获取所有菜单
     */
    List<Resource> getAllMenu();
}

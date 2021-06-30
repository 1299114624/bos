package com.archforce.bos.identity.mapper;

import com.archforce.bos.identity.entity.Resource;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Resource record);

    List<Resource> getAllMenu();
}
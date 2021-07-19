package com.archforce.bos.identity.mapper;

import com.archforce.bos.identity.entity.Resource;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Resource record);

    List<Resource> getAllMenu();

    List<Resource> getResourceByUserId(Long id);
}
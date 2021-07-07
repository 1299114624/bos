package com.archforce.bos.identity.service;

import com.archforce.bos.identity.entity.Role;

import java.util.List;

public interface RoleService {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

}


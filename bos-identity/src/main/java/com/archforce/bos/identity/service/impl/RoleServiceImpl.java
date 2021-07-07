package com.archforce.bos.identity.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.bos.identity.mapper.RoleMapper;
import com.archforce.bos.identity.entity.Role;
import com.archforce.bos.identity.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

}


package com.archforce.bos.identity.mapper;

import com.archforce.bos.identity.entity.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 查询用户角色及资源
     * @param userId
     * @return
     */
    List<Role> selectRoleAndResourceByUserId(Long userId);

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
    List<Role> selectRoleByUserId(Long userId);
}
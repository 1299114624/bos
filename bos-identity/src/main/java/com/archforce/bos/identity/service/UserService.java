package com.archforce.bos.identity.service;

import com.archforce.bos.identity.entity.Role;
import com.archforce.bos.identity.entity.User;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);

    /**
     * 获取用户信息及权限
     * @param userName
     * @return
     */
    User getUserPermission(String userName);

    /**
     * 获取用户的角色
     * @param userId
     * @return
     */
    List<Role> getUserRolesById(Integer userId);

}




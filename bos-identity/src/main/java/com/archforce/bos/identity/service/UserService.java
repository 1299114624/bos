package com.archforce.bos.identity.service;

import com.archforce.bos.identity.entity.Resource;
import com.archforce.bos.identity.entity.Role;
import com.archforce.bos.identity.entity.User;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(Long id);

    User selectByPrimaryKey(Long id);

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
    List<Role> getUserRolesById(Long userId);

    /**
     * 重置资源为查询结果的递归
     * @return
     */
    void resetResource(List<Resource> resourceList);
}




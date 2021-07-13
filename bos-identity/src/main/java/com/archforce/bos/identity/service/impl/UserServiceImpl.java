package com.archforce.bos.identity.service.impl;

import com.archforce.bos.identity.common.RoleTypeEnum;
import com.archforce.bos.identity.entity.Resource;
import com.archforce.bos.identity.entity.Role;
import com.archforce.bos.identity.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.archforce.bos.identity.entity.User;
import com.archforce.bos.identity.mapper.UserMapper;
import com.archforce.bos.identity.service.UserService;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getUserPermission(String userName) {
        User query = new User();
        query.setUserName(userName);
        User user = userMapper.selectOne(query);
        if (Objects.isNull(user)) {
            return null;
        }
        // 用户关联角色对应的菜单
        List<Role> roleList = roleMapper.selectRoleAndResourceByUserId(user.getId());
        user.setRoles(roleList);
        List<String> resourceList = new ArrayList();
        boolean isSuperAdmin = false;
        user.setOnlyAccountRole(true);
        if (!CollectionUtils.isEmpty(roleList)) {
            List<Long> roleIds = new ArrayList();
            for (Role item : roleList) {
                if (RoleTypeEnum.Admin.getValue().equals(item.getOrgType())) {
                    isSuperAdmin = true;
                    user.setSuperAdmin(true);
                }
                roleIds.add(item.getId());
                List<Resource> oldResource = item.getResources();
                if (CollectionUtils.isEmpty(oldResource)) {
                    continue;
                }
                for (Resource itemChild : oldResource) {
                    if (resourceList.contains(itemChild.getResCode())) {
                        continue;
                    }
                    resourceList.add(itemChild.getResCode());
                }
            }
            user.setRoleIds(roleIds);
        }
        user.setPermission(resourceList);
        return user;
    }

    @Override
    public List<Role> getUserRolesById(Long userId) {
        return roleMapper.selectRoleByUserId(userId);
    }

    /**
     * 重置资源为查询结果的递归
     * @return
     */
    @Override
    public void resetResource(List<Resource> resourceList) {
        List<Resource> newResource = new ArrayList<>();
        newResource.addAll(resourceList);
        Map<Long, List<Resource>> resourceMap = new HashMap<>();
        for (Resource itemChild : newResource) {
            Long parentId = itemChild.getParentId();

        }
    }

}




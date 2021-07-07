package com.archforce.bos.identity.mapper;

import com.archforce.bos.identity.entity.User;

public interface UserMapper {
    /**
     * 查询用户
     * @param query
     * @return
     */
    User selectOne(User query);

    int deleteByPrimaryKey(Long id);

    User selectByPrimaryKey(Long id);
}
package com.archforce.bos.identity.mapper;

import com.archforce.bos.identity.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);
}
package com.archforce.arc.facility.mapper.avm;

import com.archforce.arc.facility.entity.common.User;

import java.util.List;

public interface UserMapper {
    User selectByPrimaryKey(Integer id);
    List<User> selectAll();
}
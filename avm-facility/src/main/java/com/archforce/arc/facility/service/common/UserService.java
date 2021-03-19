package com.archforce.arc.facility.service.common;

import com.archforce.arc.facility.entity.common.User;

import java.util.List;

public interface UserService{

    User selectByPrimaryKey(Integer id);
    List<User> selectAll();
}

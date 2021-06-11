package com.archforce.bos.identity.service;

import com.archforce.bos.identity.entity.User;
public interface UserService{


    int deleteByPrimaryKey(Integer id);

    User selectByPrimaryKey(Integer id);

}

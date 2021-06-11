package com.archforce.bos.identity.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.archforce.bos.identity.entity.User;
import com.archforce.bos.identity.mapper.UserMapper;
import com.archforce.bos.identity.service.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}

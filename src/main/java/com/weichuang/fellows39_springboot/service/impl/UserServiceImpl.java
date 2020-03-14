package com.weichuang.fellows39_springboot.service.impl;

import com.weichuang.fellows39_springboot.mapper.UserMapper;
import com.weichuang.fellows39_springboot.pojo.User;
import com.weichuang.fellows39_springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}

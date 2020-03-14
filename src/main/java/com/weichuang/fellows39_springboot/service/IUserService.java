package com.weichuang.fellows39_springboot.service;

import com.weichuang.fellows39_springboot.pojo.User;

public interface IUserService {
    User getUserById(Integer id);

    void updateUser(User user);
}

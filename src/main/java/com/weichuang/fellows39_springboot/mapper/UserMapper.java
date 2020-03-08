package com.weichuang.fellows39_springboot.mapper;

import com.weichuang.fellows39_springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    User getUserById(int id);
}

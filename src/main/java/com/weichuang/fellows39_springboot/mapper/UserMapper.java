package com.weichuang.fellows39_springboot.mapper;

import com.weichuang.fellows39_springboot.pojo.User;
import org.apache.ibatis.annotations.Update;


public interface UserMapper {
    User getUserById(int id);

    @Update("update t_user set name = #{name} where id = #{id}")
    void updateUser(User user);
}

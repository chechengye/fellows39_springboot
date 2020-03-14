package com.weichuang.fellows39_springboot.controller;

import com.weichuang.fellows39_springboot.pojo.User;
import com.weichuang.fellows39_springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Controller
@RestController  //SpringBoot独有注解@RestController  是一个组合注解,包含了@Controller与@ResponseBody
//@ResponseBody 会将对象或者map格式转换成json
public class HelloController {

    @Autowired
    IUserService iUserService;
    @Autowired
    JdbcTemplate jt;
    @RequestMapping("/hello")
    //@ResponseBody
    public String hello(){
        return "hello , world!";
    }

    @GetMapping("/getUserById")
    public User getUserById(Integer id){
        /*List<User> userList = jt.query("select * from t_user where id = ?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setAge(rs.getInt("age"));
                u.setEmail(rs.getString("email"));
                return u;
            }
        }, id);
        return userList.get(0);*/
        return iUserService.getUserById(id);
    }

    @PostMapping("/updateUser")
    public User updateUser(User user){
        iUserService.updateUser(user);
        return user;
    }

}

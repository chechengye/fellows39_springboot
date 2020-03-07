package com.weichuang.fellows39_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController  //SpringBoot独有注解@RestController  是一个组合注解,包含了@Controller与@ResponseBody
public class HelloController {

    @RequestMapping("/hello")
    //@ResponseBody
    public String hello(){
        return "hello , world!";
    }
}

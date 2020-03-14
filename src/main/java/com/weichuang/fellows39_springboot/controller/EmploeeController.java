package com.weichuang.fellows39_springboot.controller;

import com.weichuang.fellows39_springboot.pojo.Employee;
import com.weichuang.fellows39_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmploeeController {

    @Autowired
    EmployeeService es;
    @RequestMapping("/getEmployeeById")
    public Employee getEmployeeById(int id){
        return es.getEmployeeById(id);
    }

    @RequestMapping("/updateEmployee")
    public Employee updateEmployee(Employee employee){
        es.updateEmployee(employee);
        return employee;
    }
}

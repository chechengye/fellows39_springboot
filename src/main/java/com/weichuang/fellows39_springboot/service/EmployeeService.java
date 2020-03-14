package com.weichuang.fellows39_springboot.service;

import com.weichuang.fellows39_springboot.pojo.Employee;

public interface EmployeeService {
    Employee getEmployeeById(int id);

    Employee updateEmployee(Employee employee);
}

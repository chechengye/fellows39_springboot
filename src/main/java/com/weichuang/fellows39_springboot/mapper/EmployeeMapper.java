package com.weichuang.fellows39_springboot.mapper;

import com.weichuang.fellows39_springboot.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeMapper {
    @Select("select * from t_employee where id = #{id}")
    Employee getEmployeeById(int id);

    @Update("update t_employee set name = #{name} , email = #{email} where id = #{id}")
    void updateEmployee(Employee employee);

    @Delete("delete from t_employee where id = #{id}")
    void deleteEmployeeById(int id);
}

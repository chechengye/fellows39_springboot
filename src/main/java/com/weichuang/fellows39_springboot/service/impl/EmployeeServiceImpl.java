package com.weichuang.fellows39_springboot.service.impl;

import com.weichuang.fellows39_springboot.mapper.EmployeeMapper;
import com.weichuang.fellows39_springboot.pojo.Employee;
import com.weichuang.fellows39_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    /**
     * 根据id获取员工
     * @Cacheable ：（方法前） 查询方法上的缓存处理。查询数据时，会先去缓存数据库中查询，若不存在则调用方法
     *        执行数据库的操作，将返回的结果进行缓存。若缓存中存在，则方法不会调用，直接从缓存中获取。
     * cacheNames/value ： 为缓存组件起名称，数组。只使用一个，必须属性
     * key/keyGenerator : 二选一，给我们缓存组件做标识。非必须属性，默认取方法的第一个参数的值作为它的值
     * cacheManager / cacheResolver : 缓存管理器/缓存解析器，二选一，通常不需要知道，SpringBoot会自动根据咱们的缓存组件进行适配
     * condition : 条件判断。只有符合该条件的才会被缓存condition = "#{id> 1} "
     * unless ： 条件成立则不缓存。除非 unless = "#result == null"
     * sync : 标记同步还是异步的。
     *
     * 获取第一个参数  #root.args[0] 、#参数名 、#a0、#p0
     * 获取方法执行后的结果 #result
     * @param id
     * @return
     */
    //@Cacheable(cacheNames = {"emp"})
    @Override
    public Employee getEmployeeById(int id) {
        System.out.println("员工:" + id + "号");
        return employeeMapper.getEmployeeById(id);
    }

    /**
     *   @CachePut ：(方法后) 既调用方法，又缓存返回的数据。
     * 更新员工
     * @param employee
     */
    @CachePut(cacheNames = "emp" , key = "#result.id")
    @Override
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return employee;
    }
    /**
     *  key : 可以指定删除一个缓存记录 ,推荐使用的
     *  allEntries : 若为true删除指定缓存组件中的所有缓存记录;
     *  beforeInvocation : false ，方法正常执行之后。若方法中出现异常；就不会清除缓存。
     *      true ： 方法执行前进行缓存清除
     */
    @CacheEvict(cacheNames = "emp" ,key = "#id")
    public void deleteEmployeeById(int id){
        employeeMapper.deleteEmployeeById(id);
        int i = 1/0;
    }
}

package com.weichuang.fellows39_springboot.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中的值一一映射到这个类的属性上
 * @ConfigurationProperties(prefix = "person"): 告诉SpringBoot将这个类中的所有属性与配置文件中的哪个值，相匹配
 * 匹配的类必须是已经添加进Spring容器中的组件
 */
@ConfigurationProperties(prefix = "person")
@Component
//JSR303校验注解开启
@Validated
public class Person {
    //@Value("${person.lastName}")
    private String lastName;
    @Value("#{11+22}")
    private Integer age;
    private Boolean flag;
    private Map<String, Object> map;
    private List<Object> list;
    @Email
    private String email;

    private Cat cat;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", flag=" + flag +
                ", map=" + map +
                ", list=" + list +
                ", cat=" + cat +
                '}';
    }
}

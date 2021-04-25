package com.fundark.salary.service;

import com.fundark.salary.bean.Person;

import java.util.List;

public interface PersonService {

    //通过id查询
    Person getPersonById(Integer id);

    //获取用户列表
    public List<Person> getPersonList();

    //增
    public int add(Person person);

    //删
    public int delete(Integer id);

    //改
    public int update(Integer id, Person person);
}

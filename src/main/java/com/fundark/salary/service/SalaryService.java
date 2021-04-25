package com.fundark.salary.service;

import com.fundark.salary.bean.Salary;

import java.util.List;

public interface SalaryService {

    //通过id查询
    Salary getSalaryById(Integer id);

    //获取工资列表
    public List<Salary> getSalaryList();

    //增
    public int add(Salary salary);

    //删
    public int delete(Integer id);

    //改
    public int update(Integer id, Salary salary);
}

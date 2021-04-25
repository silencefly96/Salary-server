package com.fundark.salary.service.impl;

import com.fundark.salary.bean.Salary;
import com.fundark.salary.mapper.SalaryMapper;
import com.fundark.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    //Autowired:把配置好的Bean拿来用，完成属性、方法的组装
    private final SalaryMapper salaryMapper;

    @Autowired(required = false)
    public SalaryServiceImpl(SalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }

    @Override
    public Salary getSalaryById(Integer id) {
        return salaryMapper.getSalaryById(id);
    }

    @Override
    public List<Salary> getSalaryList() {
        return salaryMapper.getSalaryList();
    }

    @Override
    public int add(Salary salary) {
        return salaryMapper.add(salary);
    }

    @Override
    public int delete(Integer id) {
        return salaryMapper.delete(id);
    }

    @Override
    public int update(Integer id, Salary salary) {
        return salaryMapper.update(id, salary);
    }
}

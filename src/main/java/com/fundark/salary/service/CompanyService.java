package com.fundark.salary.service;

import com.fundark.salary.bean.Company;

import java.util.List;

public interface CompanyService {

    //通过id查询
    Company getCompanyById(Integer id);

    //获取公司列表
    public List<Company> getCompanyList();

    //增
    public int add(Company company);

    //删
    public int delete(Integer id);

    //改
    public int update(Integer id, Company company);
}

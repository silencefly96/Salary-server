package com.fundark.salary.service;

import com.fundark.salary.bean.Statistical;

import java.util.List;

public interface StatisticalService {

    //通过id查询
    Statistical getStatisticalById(Integer id);

    //获取统计列表
    public List<Statistical> getStatisticalList();

    //增
    public int add(Statistical salary);

    //删
    public int delete(Integer id);

    //改
    public int update(Integer id, Statistical salary);
}

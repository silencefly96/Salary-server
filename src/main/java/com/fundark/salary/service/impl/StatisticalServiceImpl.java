package com.fundark.salary.service.impl;

import com.fundark.salary.bean.Statistical;
import com.fundark.salary.mapper.StatisticalMapper;
import com.fundark.salary.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticalServiceImpl implements StatisticalService {

    private final StatisticalMapper statisticalMapper;

    @Autowired(required = false)
    public StatisticalServiceImpl(StatisticalMapper statisticalMapper) {
        this.statisticalMapper = statisticalMapper;
    }


    @Override
    public Statistical getStatisticalById(Integer id) {
        return statisticalMapper.getStatisticalById(id);
    }

    @Override
    public List<Statistical> getStatisticalList() {
        return statisticalMapper.getStatisticalList();
    }

    @Override
    public int add(Statistical salary) {
        return statisticalMapper.add(salary);
    }

    @Override
    public int delete(Integer id) {
        return statisticalMapper.delete(id);
    }

    @Override
    public int update(Integer id, Statistical salary) {
        return statisticalMapper.update(id, salary);
    }
}

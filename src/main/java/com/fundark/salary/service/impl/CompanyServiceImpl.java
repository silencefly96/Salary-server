package com.fundark.salary.service.impl;

import com.fundark.salary.bean.Company;
import com.fundark.salary.mapper.CompanyMapper;
import com.fundark.salary.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyMapper companyMapper;

    @Autowired(required = false)
    public CompanyServiceImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public Company getCompanyById(Integer id) {
        return companyMapper.getCompanyById(id);
    }

    @Override
    public List<Company> getCompanyList() {
        return companyMapper.getCompanyList();
    }

    @Override
    public int add(Company company) {
        return companyMapper.add(company);
    }

    @Override
    public int delete(Integer id) {
        return companyMapper.delete(id);
    }

    @Override
    public int update(Integer id, Company company) {
        return companyMapper.update(id, company);
    }
}

package com.fundark.salary;

import com.fundark.salary.mapper.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackageClasses = TaskMapper.class)
@MapperScan(basePackageClasses = CompanyMapper.class)
@MapperScan(basePackageClasses = OrderMapper.class)
@MapperScan(basePackageClasses = PersonMapper.class)
@MapperScan(basePackageClasses = SalaryMapper.class)
@MapperScan(basePackageClasses = StatisticalMapper.class)
public class SalaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalaryApplication.class, args);
    }

}

package com.fundark.salary.mapper;

import com.fundark.salary.bean.Salary;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SalaryMapper {

    //查
    @Select("SELECT * FROM tb_salary WHERE id = #{id}")
    Salary getSalaryById(Integer id);

    //查全部
    @Select("SELECT * FROM tb_salary")
    public List<Salary> getSalaryList();

    //增
    @Insert("insert into tb_salary(id,time,worker_id,worker,salary) " +
            "values(#{id},#{time},#{workerId},#{worker},#{salary})")
    public int add(Salary salary);

    //删
    @Delete("delete from tb_salary where id=#{id}")
    public int delete(Integer id);

    //改
    @Update("update tb_salary set " +
            "id=#{salary.id}," +
            "time=#{salary.time}," +
            "worker_id=#{salary.workerId}," +
            "worker=#{salary.worker}," +
            "salary=#{salary.salary} " +
            "where id=#{id}")
    public int update(@Param("id") Integer id, @Param("salary") Salary salary);

}


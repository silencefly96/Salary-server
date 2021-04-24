package com.fundark.salary.mapper;

import com.fundark.salary.bean.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CompanyMapper {

    //查
    @Select("SELECT * FROM tb_company WHERE id = #{id}")
    Company getCompanyById(Integer id);

    //查全部
    @Select("SELECT * FROM tb_company")
    public List<Company> getCompanyList();

    //增
    @Insert("insert into tb_company(id,name,owner,size,create_time,vip,vip_create_time,vip_period) " +
            "values(#{id},#{name},#{owner},#{size},#{createTime},#{vip},#{vipCreateTime},#{vipPeriod})")
    public int add(Company company);

    //删
    @Delete("delete from tb_company where id=#{id}")
    public int delete(Integer id);

    //改
    @Update("update tb_company set " +
            "id=#{company`.id}," +
            "name=#{company.name}," +
            "owner=#{company.owner}," +
            "size=#{company.size}," +
            "create_time=#{company.createTime}," +
            "vip=#{company.vip}," +
            "vip_create_time=#{company.vipCreateTime}," +
            "vip_period=#{company.vipPeriod}," +
            "where id=#{id}")
    public int update(@Param("id") Integer id, @Param("company") Company company);

}


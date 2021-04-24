package com.fundark.salary.mapper;

import com.fundark.salary.bean.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PersonMapper {

    //查
    @Select("SELECT * FROM tb_person WHERE id = #{id}")
    Person getPersonById(Integer id);

    //查全部
    @Select("SELECT * FROM tb_person")
    public List<Person> getPersonList();

    //增
    @Insert("insert into tb_person(id,name,company_id,company,character,wx_name,phone " +
            "values(#{id},#{name},#{companyId},#{company},#{character},#{wxName},#{phone})")
    public int add(Person person);

    //删
    @Delete("delete from tb_person where id=#{id}")
    public int delete(Integer id);

    //改
    @Update("update tb_person set " +
            "id=#{person.id}," +
            "name=#{person.name}," +
            "company_id=#{person.companyId}," +
            "company=#{person.company}," +
            "character=#{person.character}," +
            "wx_name=#{person.wxName}," +
            "phone=#{person.phone} " +
            "where id=#{id}")
    public int update(@Param("id") Integer id, @Param("person") Person person);

}

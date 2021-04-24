package com.fundark.salary.mapper;

import com.fundark.salary.bean.Statistical;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StatisticalMapper {

    //查
    @Select("SELECT * FROM tb_statistical WHERE id = #{id}")
    Statistical getStatisticalById(Integer id);

    //查全部
    @Select("SELECT * FROM tb_statistical")
    public List<Statistical> getStatisticalList();

    //增
    @Insert("insert into tb_statistical(id,time,order_sum_amount,order_sum_cost,order_cost,profit) " +
            "values(#{id},#{time},#{orderSumAmount},#{orderSumCost},#{orderCost},#{profit})")
    public int add(Statistical statistical);

    //删
    @Delete("delete from tb_statistical where id=#{id}")
    public int delete(Integer id);

    //改
    @Update("update tb_statistical set " +
            "id=#{statistical.id}," +
            "time=#{statistical.time}," +
            "order_sum_amount=#{statistical.orderSumAmount}," +
            "order_sum_cost=#{statistical.orderSumCost}," +
            "order_cost=#{statistical.orderCost}," +
            "profit=#{statistical.profit} " +
            "where id=#{id}")
    public int update(@Param("id") Integer id, @Param("statistical") Statistical statistical);

}

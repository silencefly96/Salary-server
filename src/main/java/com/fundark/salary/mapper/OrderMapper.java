package com.fundark.salary.mapper;

import com.fundark.salary.bean.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {

    //查
    @Select("SELECT * FROM tb_order WHERE id = #{id}")
    Order getOrderById(Integer id);

    //查全部
    @Select("SELECT * FROM tb_order")
    public List<Order> getOrderList();

    //增
    @Insert("insert into tb_order(id,name,status,unit_price,unit_numb,create_time,deadline,end_time,salary_cost,other_cost,profit) " +
            "values(#{id},#{name},#{status},#{unitPrice},#{unitNumb},#{createTime},#{deadline},#{endTime},#{salaryCost},#{otherCost},#{profit})")
    public int add(Order order);

    //删
    @Delete("delete from tb_order where id=#{id}")
    public int delete(Integer id);

    //改
    @Update("update tb_order set " +
            "id=#{order.id}," +
            "name=#{order.name}," +
            "status=#{order.status}," +
            "unit_price=#{order.unitPrice}," +
            "unit_numb=#{order.unitNumb}," +
            "create_time=#{order.createTime}," +
            "deadline=#{order.deadline}," +
            "end_time=#{order.endTime}," +
            "salary_cost=#{order.salaryCost}," +
            "other_cost=#{order.otherCost}," +
            "profit=#{order.profit} " +
            "where id=#{id}")
    public int update(@Param("id") Integer id, @Param("order") Order order);

}

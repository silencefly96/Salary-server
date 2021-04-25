package com.fundark.salary.service;

import com.fundark.salary.bean.Order;

import java.util.List;

public interface OrderService {

    //通过id查询
    Order getOrderById(Integer id);

    //获取订单列表
    public List<Order> getOrderList();

    //增
    public int add(Order order);

    //删
    public int delete(Integer id);

    //改
    public int update(Integer id, Order order);
}

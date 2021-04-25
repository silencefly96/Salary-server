package com.fundark.salary.service.impl;

import com.fundark.salary.bean.Order;
import com.fundark.salary.mapper.OrderMapper;
import com.fundark.salary.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Autowired(required = false)
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    public Order getOrderById(Integer id) {
        return orderMapper.getOrderById(id);
    }

    @Override
    public List<Order> getOrderList() {
        return orderMapper.getOrderList();
    }

    @Override
    public int add(Order order) {
        return orderMapper.add(order);
    }

    @Override
    public int delete(Integer id) {
        return orderMapper.delete(id);
    }

    @Override
    public int update(Integer id, Order order) {
        return orderMapper.update(id, order);
    }
}

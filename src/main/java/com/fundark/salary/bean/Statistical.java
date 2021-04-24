package com.fundark.salary.bean;

public class Statistical {

    //月度统计id
    private int id;

    //统计月份，时间为当月最后一天，关联订单已结束时间为准
    private String time;

    //当月订单金额总和
    private double orderSumAmount;

    //当月订单支出总和
    private double orderSumCost;

    //当月其他支出
    private double orderCost;

    //当月盈利
    private double profit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getOrderSumAmount() {
        return orderSumAmount;
    }

    public void setOrderSumAmount(double orderSumAmount) {
        this.orderSumAmount = orderSumAmount;
    }

    public double getOrderSumCost() {
        return orderSumCost;
    }

    public void setOrderSumCost(double orderSumCost) {
        this.orderSumCost = orderSumCost;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(double orderCost) {
        this.orderCost = orderCost;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}

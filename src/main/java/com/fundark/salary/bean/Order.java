package com.fundark.salary.bean;

public class Order {

    //订单id
    private int id;

    //订单名称
    private String name;

    //订单状态 0 进行中 1 结束
    private int status;

    //订单单价
    private double unitPrice;

    //订单数目
    private int unitNumb;

    //订单创建时间
    private String createTime;

    //订单截至时间
    private String deadline;

    //订单结束时间
    private String endTime;

    //订单工资支出
    private double salaryCost;

    //订单其他支出
    private double otherCost;

    //订单利润
    private double profit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitNumb() {
        return unitNumb;
    }

    public void setUnitNumb(int unitNumb) {
        this.unitNumb = unitNumb;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getSalaryCost() {
        return salaryCost;
    }

    public void setSalaryCost(double salaryCost) {
        this.salaryCost = salaryCost;
    }

    public double getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(double otherCost) {
        this.otherCost = otherCost;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}

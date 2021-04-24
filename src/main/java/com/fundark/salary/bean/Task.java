package com.fundark.salary.bean;

public class Task {

    //任务id
    private int id;

    //任务名称
    private String name;

    //任务状态 0 进行中 1 结束 2 完成
    //（完成指结束，并且数目全部完成）
    private int status;

    //所属订单id
    private int orderId;

    //订单名称
    private String orderName;

    //员工id
    private int workerId;

    //员工名称
    private String worker;

    //任务单价
    private double price;

    //任务数量
    private int numb;

    //当前完成数量
    private int finishNumb;

    //任务创建时间
    private String createTime;

    //任务截止时间
    private String deadline;

    //任务结束时间
    private String endTime;

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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public int getFinishNumb() {
        return finishNumb;
    }

    public void setFinishNumb(int finishNumb) {
        this.finishNumb = finishNumb;
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
}

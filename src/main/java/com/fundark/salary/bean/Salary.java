package com.fundark.salary.bean;

public class Salary {

    //工资id
    private int id;

    //统计月份，时间为当月最后一天，关联任务开始时间为准
    private String time;

    //员工id
    private int workerId;

    //员工姓名
    private String worker;

    //员工工资
    private double salary;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

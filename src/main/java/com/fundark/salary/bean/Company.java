package com.fundark.salary.bean;

public class Company {

    //单位id
    private int id;

    //单位名称
    private String name;

    //单位所属人
    private String owner;

    //单位体量，员工人数
    private int size;

    //入驻时间
    private String createTime;

    //是否为VIP ，0 否 1 是
    private int vip;

    //vip创建时间
    private String vipCreateTime;

    //vip持续时长
    private int vipPeriod;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public String getVipCreateTime() {
        return vipCreateTime;
    }

    public void setVipCreateTime(String vipCreateTime) {
        this.vipCreateTime = vipCreateTime;
    }

    public int getVipPeriod() {
        return vipPeriod;
    }

    public void setVipPeriod(int vipPeriod) {
        this.vipPeriod = vipPeriod;
    }
}

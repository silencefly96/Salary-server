package com.fundark.salary.service;

import com.fundark.salary.bean.Task;

import java.util.List;

public interface TaskService {

    //通过id查询
    Task getTaskById(Integer id);

    //获取任务列表
    public List<Task> getTaskList();

    //增
    public int add(Task task);

    //删
    public int delete(Integer id);

    //改
    public int update(Integer id, Task task);

}

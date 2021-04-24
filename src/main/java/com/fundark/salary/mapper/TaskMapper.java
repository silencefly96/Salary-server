package com.fundark.salary.mapper;

import com.fundark.salary.bean.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

// @Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，
// 所以统一配置@MapperScan在扫描路径在application类中
public interface TaskMapper {

    //查
    @Select("SELECT * FROM tb_task WHERE id = #{id}")
    Task getTaskById(Integer id);

    //查全部
    @Select("SELECT * FROM tb_task")
    public List<Task> getTaskList();

    //增
    @Insert("insert into tb_task(id,name,status,order_id,order_name,worker_id,worker,price,numb,finish_numb,create_time,deadline,end_time) " +
            "values(#{id},#{name},#{status},#{orderId},#{orderName},#{workerId},#{worker},#{price},#{numb},#{finishNumb},#{createTime},#{deadline},#{endTime})")
    public int add(Task task);

    //删
    @Delete("delete from tb_task where id=#{id}")
    public int delete(Integer id);

    //改
    @Update("update tb_task set " +
            "id=#{task.id}," +
            "name=#{task.name}," +
            "status=#{task.status}," +
            "order_id=#{task.orderId}," +
            "order_name=#{task.orderName}," +
            "worker_id=#{task.workerId}," +
            "worker=#{task.worker}," +
            "price=#{task.price}," +
            "numb=#{task.numb}," +
            "finish_numb=#{task.finishNumb}," +
            "create_time=#{task.createTime}," +
            "deadline=#{task.deadline}," +
            "end_time=#{task.endTime} " +
            "where id=#{id}")
    public int update(@Param("id") Integer id, @Param("task") Task task);

}

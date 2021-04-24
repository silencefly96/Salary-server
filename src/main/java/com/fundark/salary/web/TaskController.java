package com.fundark.salary.web;

import com.fundark.salary.bean.JsonResult;
import com.fundark.salary.bean.Task;
import com.fundark.salary.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fundark.salary.bean.JsonResult.RESULT_ERROR;
import static com.fundark.salary.bean.JsonResult.RESULT_FAIL;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * 根据ID查询任务
     * @param id 查询ID
     * @return 任务
     */
    //@PathVariable:用于获取url中的数据
    @GetMapping(value = "task/query/{id}")
    public ResponseEntity<JsonResult<Task>> getTaskById(@PathVariable(value = "id") Integer id){
        JsonResult<Task> r = new JsonResult<>();
        try {
            Task task = taskService.getTaskById(id);
            r.setResult(task);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 查询任务列表
     * @return 任务列表
     */
    @RequestMapping(value = "task/all",method = RequestMethod.GET)
    public ResponseEntity<JsonResult<List<Task>>> getTaskList(){
        JsonResult<List<Task>> r = new JsonResult<>();
        try {
            List<Task> tasks = taskService.getTaskList();
            r.setResult(tasks);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加任务
     * @param task 任务
     * @return 结果
     */
    @RequestMapping(value = "task/add",method = RequestMethod.POST)
    public ResponseEntity<JsonResult<Integer>> add(@RequestBody Task task){
        JsonResult<Integer> r = new JsonResult<>();
        try {
            int orderId = taskService.add(task);
            if (orderId < 0){
                r.setStatus(RESULT_FAIL);
                r.setResult(orderId);
                r.setErrMsg("IllegalArgumentException:orderId=" + orderId);
            }else {
                r.setResult(orderId);
            }
        }catch (Exception e){
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            r.setStatus(RESULT_ERROR);
            e.printStackTrace();
        }

        return ResponseEntity.ok(r);
    }

    /**
     * 根据id删除任务
     * @param id 任务id
     * @return 结果
     */
    @RequestMapping(value = "task/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult<Integer>> delete(@PathVariable(value = "id") Integer id){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int delId = taskService.delete(id);
            if (delId < 0){
                r.setStatus(RESULT_FAIL);
                r.setResult(delId);
                r.setErrMsg("IllegalArgumentException:delId=" + delId);
            }else {
                r.setResult(delId);
            }
        }catch (Exception e){
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            r.setStatus(RESULT_ERROR);
            e.printStackTrace();
        }

        return ResponseEntity.ok(r);
    }

    /**
     * 根据id修改task信息
     * @param task 任务
     * @return 结果
     */
    @RequestMapping(value = "task/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult<Integer>> update(@PathVariable(value = "id") Integer id,
                                             @RequestBody Task task){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int ret = taskService.update(id, task);
            if (ret<0){
                r.setResult(ret);
                r.setStatus(RESULT_FAIL);
                r.setErrMsg("IllegalArgumentException:ret=" + ret);
            }else {
                r.setResult(ret);
            }
        }catch (Exception e){
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            r.setStatus(RESULT_ERROR);
            e.printStackTrace();
        }

        return ResponseEntity.ok(r);
    }

}

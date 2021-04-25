package com.fundark.salary.web;

import com.fundark.salary.bean.JsonResult;
import com.fundark.salary.bean.Salary;
import com.fundark.salary.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fundark.salary.bean.JsonResult.RESULT_ERROR;
import static com.fundark.salary.bean.JsonResult.RESULT_FAIL;

public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    /**
     * 根据ID查询工資
     * @param id 查询ID
     * @return 工資
     */
    //@PathVariable:用于获取url中的数据
    @GetMapping(value = "salary/query/{id}")
    public ResponseEntity<JsonResult<Salary>> getSalaryById(@PathVariable(value = "id") Integer id){
        JsonResult<Salary> r = new JsonResult<>();
        try {
            Salary salary = salaryService.getSalaryById(id);
            r.setResult(salary);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 查询工資列表
     * @return 工資列表
     */
    @RequestMapping(value = "salary/all",method = RequestMethod.GET)
    public ResponseEntity<JsonResult<List<Salary>>> getSalaryList(){
        JsonResult<List<Salary>> r = new JsonResult<>();
        try {
            List<Salary> salarys = salaryService.getSalaryList();
            r.setResult(salarys);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加工資
     * @param salary 工資
     * @return 结果
     */
    @RequestMapping(value = "salary/add",method = RequestMethod.POST)
    public ResponseEntity<JsonResult<Integer>> add(@RequestBody Salary salary){
        JsonResult<Integer> r = new JsonResult<>();
        try {
            int orderId = salaryService.add(salary);
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
     * 根据id删除工資
     * @param id 工資id
     * @return 结果
     */
    @RequestMapping(value = "salary/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult<Integer>> delete(@PathVariable(value = "id") Integer id){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int delId = salaryService.delete(id);
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
     * 根据id修改salary信息
     * @param salary 工資
     * @return 结果
     */
    @RequestMapping(value = "salary/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult<Integer>> update(@PathVariable(value = "id") Integer id,
                                                      @RequestBody Salary salary){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int ret = salaryService.update(id, salary);
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

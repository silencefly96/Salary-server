package com.fundark.salary.web;

import com.fundark.salary.bean.JsonResult;
import com.fundark.salary.bean.Person;
import com.fundark.salary.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fundark.salary.bean.JsonResult.RESULT_ERROR;
import static com.fundark.salary.bean.JsonResult.RESULT_FAIL;

public class PersonController {
    
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * 根据ID查询员工
     * @param id 查询ID
     * @return 员工
     */
    //@PathVariable:用于获取url中的数据
    @GetMapping(value = "person/query/{id}")
    public ResponseEntity<JsonResult<Person>> getPersonById(@PathVariable(value = "id") Integer id){
        JsonResult<Person> r = new JsonResult<>();
        try {
            Person person = personService.getPersonById(id);
            r.setResult(person);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 查询员工列表
     * @return 员工列表
     */
    @RequestMapping(value = "person/all",method = RequestMethod.GET)
    public ResponseEntity<JsonResult<List<Person>>> getPersonList(){
        JsonResult<List<Person>> r = new JsonResult<>();
        try {
            List<Person> persons = personService.getPersonList();
            r.setResult(persons);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加员工
     * @param person 员工
     * @return 结果
     */
    @RequestMapping(value = "person/add",method = RequestMethod.POST)
    public ResponseEntity<JsonResult<Integer>> add(@RequestBody Person person){
        JsonResult<Integer> r = new JsonResult<>();
        try {
            int orderId = personService.add(person);
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
     * 根据id删除员工
     * @param id 员工id
     * @return 结果
     */
    @RequestMapping(value = "person/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult<Integer>> delete(@PathVariable(value = "id") Integer id){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int delId = personService.delete(id);
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
     * 根据id修改person信息
     * @param person 员工
     * @return 结果
     */
    @RequestMapping(value = "person/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult<Integer>> update(@PathVariable(value = "id") Integer id,
                                                      @RequestBody Person person){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int ret = personService.update(id, person);
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

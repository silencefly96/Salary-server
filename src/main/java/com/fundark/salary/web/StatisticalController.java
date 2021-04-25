package com.fundark.salary.web;

import com.fundark.salary.bean.JsonResult;
import com.fundark.salary.bean.Statistical;
import com.fundark.salary.service.StatisticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fundark.salary.bean.JsonResult.RESULT_ERROR;
import static com.fundark.salary.bean.JsonResult.RESULT_FAIL;

public class StatisticalController {

    private final StatisticalService statisticalService;

    @Autowired
    public StatisticalController(StatisticalService statisticalService) {
        this.statisticalService = statisticalService;
    }

    /**
     * 根据ID查询统计
     * @param id 查询ID
     * @return 统计
     */
    //@PathVariable:用于获取url中的数据
    @GetMapping(value = "statistical/query/{id}")
    public ResponseEntity<JsonResult<Statistical>> getStatisticalById(@PathVariable(value = "id") Integer id){
        JsonResult<Statistical> r = new JsonResult<>();
        try {
            Statistical statistical = statisticalService.getStatisticalById(id);
            r.setResult(statistical);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 查询统计列表
     * @return 统计列表
     */
    @RequestMapping(value = "statistical/all",method = RequestMethod.GET)
    public ResponseEntity<JsonResult<List<Statistical>>> getStatisticalList(){
        JsonResult<List<Statistical>> r = new JsonResult<>();
        try {
            List<Statistical> statisticals = statisticalService.getStatisticalList();
            r.setResult(statisticals);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加统计
     * @param statistical 统计
     * @return 结果
     */
    @RequestMapping(value = "statistical/add",method = RequestMethod.POST)
    public ResponseEntity<JsonResult<Integer>> add(@RequestBody Statistical statistical){
        JsonResult<Integer> r = new JsonResult<>();
        try {
            int orderId = statisticalService.add(statistical);
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
     * 根据id删除统计
     * @param id 统计id
     * @return 结果
     */
    @RequestMapping(value = "statistical/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult<Integer>> delete(@PathVariable(value = "id") Integer id){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int delId = statisticalService.delete(id);
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
     * 根据id修改statistical信息
     * @param statistical 统计
     * @return 结果
     */
    @RequestMapping(value = "statistical/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult<Integer>> update(@PathVariable(value = "id") Integer id,
                                                      @RequestBody Statistical statistical){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int ret = statisticalService.update(id, statistical);
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

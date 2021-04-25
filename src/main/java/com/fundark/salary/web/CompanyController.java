package com.fundark.salary.web;

import com.fundark.salary.bean.Company;
import com.fundark.salary.bean.JsonResult;
import com.fundark.salary.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fundark.salary.bean.JsonResult.RESULT_ERROR;
import static com.fundark.salary.bean.JsonResult.RESULT_FAIL;

public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    /**
     * 根据ID查询公司
     * @param id 查询ID
     * @return 公司
     */
    //@PathVariable:用于获取url中的数据
    @GetMapping(value = "company/query/{id}")
    public ResponseEntity<JsonResult<Company>> getCompanyById(@PathVariable(value = "id") Integer id){
        JsonResult<Company> r = new JsonResult<>();
        try {
            Company company = companyService.getCompanyById(id);
            r.setResult(company);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 查询公司列表
     * @return 公司列表
     */
    @RequestMapping(value = "company/all",method = RequestMethod.GET)
    public ResponseEntity<JsonResult<List<Company>>> getCompanyList(){
        JsonResult<List<Company>> r = new JsonResult<>();
        try {
            List<Company> companies = companyService.getCompanyList();
            r.setResult(companies);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加公司
     * @param company 公司
     * @return 结果
     */
    @RequestMapping(value = "company/add",method = RequestMethod.POST)
    public ResponseEntity<JsonResult<Integer>> add(@RequestBody Company company){
        JsonResult<Integer> r = new JsonResult<>();
        try {
            int orderId = companyService.add(company);
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
     * 根据id删除公司
     * @param id 公司id
     * @return 结果
     */
    @RequestMapping(value = "company/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult<Integer>> delete(@PathVariable(value = "id") Integer id){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int delId = companyService.delete(id);
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
     * 根据id修改公司信息
     * @param company 公司
     * @return 结果
     */
    @RequestMapping(value = "task/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult<Integer>> update(@PathVariable(value = "id") Integer id,
                                                      @RequestBody Company company){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int ret = companyService.update(id, company);
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

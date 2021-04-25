package com.fundark.salary.web;

import com.fundark.salary.bean.JsonResult;
import com.fundark.salary.bean.Order;
import com.fundark.salary.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.fundark.salary.bean.JsonResult.RESULT_ERROR;
import static com.fundark.salary.bean.JsonResult.RESULT_FAIL;

public class OrderController {
    
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 根据ID查询订单
     * @param id 查询ID
     * @return 订单
     */
    //@PathVariable:用于获取url中的数据
    @GetMapping(value = "order/query/{id}")
    public ResponseEntity<JsonResult<Order>> getOrderById(@PathVariable(value = "id") Integer id){
        JsonResult<Order> r = new JsonResult<>();
        try {
            Order order = orderService.getOrderById(id);
            r.setResult(order);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }


    /**
     * 查询订单列表
     * @return 订单列表
     */
    @RequestMapping(value = "order/all",method = RequestMethod.GET)
    public ResponseEntity<JsonResult<List<Order>>> getOrderList(){
        JsonResult<List<Order>> r = new JsonResult<>();
        try {
            List<Order> orders = orderService.getOrderList();
            r.setResult(orders);
        }catch (Exception e){
            r.setStatus(RESULT_ERROR);
            r.setErrMsg(e.getClass().getName()+":"+e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加订单
     * @param order 订单
     * @return 结果
     */
    @RequestMapping(value = "order/add",method = RequestMethod.POST)
    public ResponseEntity<JsonResult<Integer>> add(@RequestBody Order order){
        JsonResult<Integer> r = new JsonResult<>();
        try {
            int orderId = orderService.add(order);
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
     * 根据id删除订单
     * @param id 订单id
     * @return 结果
     */
    @RequestMapping(value = "order/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult<Integer>> delete(@PathVariable(value = "id") Integer id){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int delId = orderService.delete(id);
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
     * 根据id修改订单信息
     * @param order 订单
     * @return 结果
     */
    @RequestMapping(value = "order/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<JsonResult<Integer>> update(@PathVariable(value = "id") Integer id,
                                                      @RequestBody Order order){
        JsonResult<Integer> r=new JsonResult<>();
        try {
            int ret = orderService.update(id, order);
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

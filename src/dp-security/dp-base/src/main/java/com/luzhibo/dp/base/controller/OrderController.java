package com.luzhibo.dp.base.controller;

import com.luzhibo.dp.base.entity.TmOrderEntity;
import com.luzhibo.dp.base.service.TmOrderService;
import com.luzhibo.dp.common.annotation.SysLog;
import com.luzhibo.dp.common.controller.AbstractController;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 89754
 */
@RestController
@RequestMapping("/base/order")
public class OrderController  extends AbstractController {

    @Autowired
    private TmOrderService tmOrderService;


    @PostMapping("/list")
    public Page<TmOrderEntity> list(@RequestBody Map<String, Object> params){
        return tmOrderService.listOrders(params);
    }

    @SysLog("新增订单")
    @PostMapping("/save")
    public R save(@RequestBody TmOrderEntity tmOrderEntity){
        return tmOrderService.saveOrder(tmOrderEntity);
    }

    @RequestMapping("/findOrderById")
    public R findOrderById(@RequestBody Long id){
        return tmOrderService.findById(id);
    }
    @SysLog("修改订单")
    @RequestMapping("/update")
    public R update(@RequestBody TmOrderEntity tmOrderEntity){
        return tmOrderService.updateOrder(tmOrderEntity);
    }

    @SysLog("删除订单")
    @RequestMapping("/remove")
    public R batchRemove (@RequestBody Long[] ids){
        return tmOrderService.batchRemove(ids);
    }

}

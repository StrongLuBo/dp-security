package com.luzhibo.dp.base.controller;

import com.luzhibo.dp.base.entity.TmOrderEntity;
import com.luzhibo.dp.base.service.TmOrderService;
import com.luzhibo.dp.common.annotation.SysLog;
import com.luzhibo.dp.common.controller.AbstractController;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
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
        String customerName = tmOrderEntity.getCustomerName();
        String[] split = customerName.split("-");
        tmOrderEntity.setCustomerId(Integer.parseInt(split[0].toString()));
        tmOrderEntity.setCustomerName(split[1]);
        tmOrderEntity.setOrderNo(DateUtils.getCurrentDate());
        tmOrderEntity.setPayMoneySum(BigDecimal.valueOf(0));
        tmOrderEntity.setOrderStatus(TmOrderEntity.ORDERSTATUS_0);
        tmOrderEntity.setCreateUser(getUser().getUsername());
        tmOrderEntity.setCreateTime(new Date());
        return tmOrderService.saveOrder(tmOrderEntity);
    }

    @RequestMapping("/findOrderById")
    public R findOrderById(@RequestBody Long id){
        return tmOrderService.findById(id);
    }
    @SysLog("修改订单")
    @RequestMapping("/update")
    public R update(@RequestBody TmOrderEntity tmOrderEntity){
        TmOrderEntity tmOrder = new TmOrderEntity();
        tmOrder.setRemarks(tmOrderEntity.getRemarks());
        tmOrder.setOrderId(tmOrderEntity.getOrderId());
        tmOrder.setUpdateUser(getUser().getUsername());
        tmOrder.setUpdateTime(new Date());
        return tmOrderService.updateOrder(tmOrder);
    }

    @SysLog("删除订单")
    @RequestMapping("/remove")
    public R batchRemove (@RequestBody Long[] ids){
        return tmOrderService.batchRemove(ids);
    }

    @SysLog("完成订单")
    @RequestMapping("/updateOrderSuccess")
    public R updateOrderSuccess( Integer orderId){
        TmOrderEntity tmOrderEntity = new TmOrderEntity();
        tmOrderEntity.setUpdateUser(getUser().getUsername());
        tmOrderEntity.setUpdateTime(new Date());
        tmOrderEntity.setOrderId(orderId);
        return tmOrderService.updateOrderSuccess(tmOrderEntity);
    }

}

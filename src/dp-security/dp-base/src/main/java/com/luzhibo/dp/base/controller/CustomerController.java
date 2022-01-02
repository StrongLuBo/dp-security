package com.luzhibo.dp.base.controller;

import com.luzhibo.dp.base.entity.TmCustomerEntity;
import com.luzhibo.dp.base.entity.TmOrderEntity;
import com.luzhibo.dp.base.service.TmCustomerService;
import com.luzhibo.dp.common.annotation.SysLog;
import com.luzhibo.dp.common.controller.AbstractController;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author 89754
 */
@RestController
@RequestMapping("/base/customer")
public class CustomerController extends AbstractController {

    @Autowired
    private TmCustomerService tmCustomerService;

    @RequestMapping("/listPage")
    public Page<TmCustomerEntity> listPage(@RequestBody Map<String,Object> params){
        return tmCustomerService.listCustomer(params);
    }

    @SysLog("新增客户")
    @RequestMapping("/save")
    public R save(@RequestBody TmCustomerEntity tmCustomerEntity){
        tmCustomerEntity.setCreateUser(getUser().getUsername());
        tmCustomerEntity.setCreateTime(new Date());
        return tmCustomerService.saveCustomer(tmCustomerEntity);
    }

    @RequestMapping("/findCustomerById")
    public R findCustomerById(@RequestBody Long id){
        return tmCustomerService.findById(id);
    }

    @SysLog("修改客户")
    @RequestMapping("/update")
    public R update(@RequestBody TmCustomerEntity tmCustomerEntity){
        tmCustomerEntity.setUpdateUser(getUser().getUsername());
        return tmCustomerService.updateCustomer(tmCustomerEntity);
    }

    @SysLog("删除客户")
    @RequestMapping("/remove")
    public R batchRemove(@RequestBody Long[] ids){
        return tmCustomerService.batchRemove(ids);
    }
}

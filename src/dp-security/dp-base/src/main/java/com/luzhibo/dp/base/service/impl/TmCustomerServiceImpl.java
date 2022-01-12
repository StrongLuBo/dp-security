package com.luzhibo.dp.base.service.impl;

import com.luzhibo.dp.base.entity.TmCustomerEntity;
import com.luzhibo.dp.base.entity.TmOrderEntity;
import com.luzhibo.dp.base.manager.TmCustomerManager;
import com.luzhibo.dp.base.service.TmCustomerService;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author 89754
* @description 针对表【tm_customer】的数据库操作Service实现
* @createDate 2021-12-20 17:52:05
*/
@Service("tmCustomerService")
public class TmCustomerServiceImpl implements TmCustomerService {

    @Autowired
    private TmCustomerManager tmCustomerManager;

    @Override
    public Page<TmCustomerEntity> listCustomer(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TmCustomerEntity> page = new Page<>(query);
        tmCustomerManager.list(page, query);
        return page;
    }

    @Override
    public R saveCustomer(TmCustomerEntity customer) {
        return CommonUtils.msg(tmCustomerManager.save(customer));
    }

    @Override
    public R findById(Long id) {
        return CommonUtils.msg(tmCustomerManager.findById(id));
    }

    @Override
    public R updateCustomer(TmCustomerEntity customer) {
        return CommonUtils.msg(tmCustomerManager.update(customer));
    }

    @Override
    public R batchRemove(Long[] id) {
        return CommonUtils.msg(tmCustomerManager.batchRemove(id));
    }

    @Override
    public List<TmCustomerEntity> listAll() {
        return tmCustomerManager.listAll();
    }
}

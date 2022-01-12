package com.luzhibo.dp.base.service.impl;

import com.luzhibo.dp.base.entity.TmOrderEntity;
import com.luzhibo.dp.base.manager.TmOrderManager;
import com.luzhibo.dp.base.service.TmOrderService;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author 89754
* @description 针对表【tm_order】的数据库操作Service实现
* @createDate 2021-12-20 17:46:51
*/
@Service("tmOrderService")
public class TmOrderServiceImpl implements TmOrderService{

    @Autowired
    private TmOrderManager tmOrderManager;

    @Override
    public Page<TmOrderEntity> listOrders(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TmOrderEntity> page = new Page<>(query);
        tmOrderManager.list(page, query);
        return page;
    }

    @Override
    public R saveOrder(TmOrderEntity tmOrderEntity) {
        return CommonUtils.msg(tmOrderManager.save(tmOrderEntity));
    }

    @Override
    public R findById(Long id) {
        return CommonUtils.msg(tmOrderManager.findById(id));
    }

    @Override
    public R updateOrder(TmOrderEntity tmOrderEntity) {
        return CommonUtils.msg(tmOrderManager.update(tmOrderEntity));
    }

    @Override
    public R batchRemove(Long[] id) {
        return CommonUtils.msg(tmOrderManager.batchRemove(id));
    }

    @Override
    public R updateOrderSuccess(TmOrderEntity tmOrderEntity) {
        return CommonUtils.msg(tmOrderManager.updateOrderSuccess(tmOrderEntity));
    }
}

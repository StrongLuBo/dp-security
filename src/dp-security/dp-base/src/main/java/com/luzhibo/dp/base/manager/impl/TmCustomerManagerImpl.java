package com.luzhibo.dp.base.manager.impl;

import com.luzhibo.dp.base.dao.TmCustomerMapper;
import com.luzhibo.dp.base.entity.TmCustomerEntity;
import com.luzhibo.dp.base.manager.TmCustomerManager;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.entity.SysLogEntity;
import com.luzhibo.dp.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 89754
 */
@Component("tmCustomerManager")
public class TmCustomerManagerImpl implements TmCustomerManager {

    @Autowired
    private TmCustomerMapper tmCustomerMapper;

    @Override
    public List<TmCustomerEntity> list(Page<TmCustomerEntity> page, Query query) {
        return tmCustomerMapper.listForPage(page,query);
    }


    @Override
    public R save(TmCustomerEntity order) {
        return CommonUtils.msg(tmCustomerMapper.save(order));
    }

    @Override
    public R findById(Long id) {
        return CommonUtils.msg(tmCustomerMapper.findById(id));

    }

    @Override
    public R update(TmCustomerEntity order) {
        return CommonUtils.msg(tmCustomerMapper.update(order));
    }

    @Override
    public R batchRemove(Long[] id) {
        return CommonUtils.msg(tmCustomerMapper.batchRemove(id));
    }
}

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
    public int save(TmCustomerEntity order) {
        return tmCustomerMapper.save(order);
    }

    @Override
    public TmCustomerEntity findById(Long id) {
        return tmCustomerMapper.findById(id);

    }

    @Override
    public int update(TmCustomerEntity order) {
        return tmCustomerMapper.update(order);
    }

    @Override
    public int batchRemove(Long[] id) {
        return tmCustomerMapper.batchRemove(id);
    }

    @Override
    public List<TmCustomerEntity> listAll() {
        return tmCustomerMapper.list();
    }
}

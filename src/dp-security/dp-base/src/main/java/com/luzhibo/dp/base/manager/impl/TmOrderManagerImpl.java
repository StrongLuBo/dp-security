package com.luzhibo.dp.base.manager.impl;

import com.luzhibo.dp.base.dao.TmOrderMapper;
import com.luzhibo.dp.base.entity.TmCustomerEntity;
import com.luzhibo.dp.base.entity.TmOrderEntity;
import com.luzhibo.dp.base.manager.TmOrderManager;
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
@Component("tmOrderManager")
public class TmOrderManagerImpl implements TmOrderManager {

    @Autowired
    private TmOrderMapper tmOrderMapper;

    @Override
    public List<TmOrderEntity> list(Page<TmOrderEntity> page, Query query) {
        return tmOrderMapper.listForPage(page,query);
    }

    @Override
    public int save(TmOrderEntity order) {
        return tmOrderMapper.save(order);
    }

    @Override
    public TmOrderEntity findById(Long id) {
        return tmOrderMapper.findById(id);
    }

    @Override
    public int update(TmOrderEntity order) {
        return tmOrderMapper.update(order);
    }


    @Override
    public int batchRemove(Long[] id) {
        return tmOrderMapper.batchRemove(id);
    }
}

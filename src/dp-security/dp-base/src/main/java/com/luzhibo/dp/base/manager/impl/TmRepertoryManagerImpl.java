package com.luzhibo.dp.base.manager.impl;

import com.luzhibo.dp.base.dao.TmRepertoryMapper;
import com.luzhibo.dp.base.entity.TmRepertoryEntity;
import com.luzhibo.dp.base.manager.TmRepertoryManager;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 89754
 */
@Component("tmRepertoryManager")
public class TmRepertoryManagerImpl implements TmRepertoryManager {

    @Autowired
    private TmRepertoryMapper tmRepertoryMapper;
    @Override
    public List<TmRepertoryEntity> list(Page<TmRepertoryEntity> page, Query query) {
        return tmRepertoryMapper.listForPage(page,query);
    }

    @Override
    public int save(TmRepertoryEntity tmRepertoryEntity) {
        return tmRepertoryMapper.save(tmRepertoryEntity);
    }

    @Override
    public TmRepertoryEntity findById(Long id) {
        return tmRepertoryMapper.findById(id);
    }

    @Override
    public int update(TmRepertoryEntity tmRepertoryEntity) {
        return tmRepertoryMapper.update(tmRepertoryEntity);
    }

    @Override
    public int batchRemove(Long[] id) {
        return tmRepertoryMapper.batchRemove(id);
    }
}

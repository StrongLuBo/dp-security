package com.luzhibo.dp.base.manager.impl;

import com.luzhibo.dp.base.dao.TmMaterialMapper;
import com.luzhibo.dp.base.entity.TmMaterialEntity;
import com.luzhibo.dp.base.manager.TmMaterialManager;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 89754
 */
@Component("tmMaterialManager")
public class TmMaterialManagerImpl implements TmMaterialManager {

    @Autowired
    private TmMaterialMapper tmMaterialMapper;

    @Override
    public List<TmMaterialEntity> list(Page<TmMaterialEntity> page, Query query) {
        return tmMaterialMapper.listForPage(page,query);
    }

    @Override
    public int save(TmMaterialEntity tmMaterialEntity) {
        return tmMaterialMapper.save(tmMaterialEntity);
    }

    @Override
    public TmMaterialEntity findById(Long id) {
        return tmMaterialMapper.findById(id);
    }

    @Override
    public int update(TmMaterialEntity tmMaterialEntity) {
        return tmMaterialMapper.update(tmMaterialEntity);
    }

    @Override
    public int batchRemove(Long[] id) {
        return tmMaterialMapper.batchRemove(id);
    }
}

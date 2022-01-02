package com.luzhibo.dp.base.service.impl;

import com.luzhibo.dp.base.entity.TmMaterialEntity;
import com.luzhibo.dp.base.manager.TmMaterialManager;
import com.luzhibo.dp.base.service.TmMaterialService;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 89754
 */
@Service("tmMaterialService")
public class TmMaterialServiceImpl implements TmMaterialService {

    @Autowired
    private TmMaterialManager tmMaterialManager;

    @Override
    public Page<TmMaterialEntity> list(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TmMaterialEntity> page = new Page<>(query);
        tmMaterialManager.list(page, query);
        return page;
    }

    @Override
    public R save(TmMaterialEntity tmMaterialEntity) {
        return CommonUtils.msg(tmMaterialManager.save(tmMaterialEntity));
    }

    @Override
    public R findById(Long id) {
        return CommonUtils.msg(tmMaterialManager.findById(id));
    }

    @Override
    public R update(TmMaterialEntity tmMaterialEntity) {
        return CommonUtils.msg(tmMaterialManager.update(tmMaterialEntity));
    }

    @Override
    public R batchRemove(Long[] id) {
        return CommonUtils.msg(tmMaterialManager.batchRemove(id));
    }
}

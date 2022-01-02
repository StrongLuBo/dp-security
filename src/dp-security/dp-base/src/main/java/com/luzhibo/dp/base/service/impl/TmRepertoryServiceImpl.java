package com.luzhibo.dp.base.service.impl;

import com.luzhibo.dp.base.entity.TmMaterialEntity;
import com.luzhibo.dp.base.entity.TmRepertoryEntity;
import com.luzhibo.dp.base.manager.TmMaterialManager;
import com.luzhibo.dp.base.manager.TmRepertoryManager;
import com.luzhibo.dp.base.service.TmRepertoryService;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.exception.RRException;
import com.luzhibo.dp.common.utils.CommonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 89754
 */
@Service("tmRepertoryService")
public class TmRepertoryServiceImpl implements TmRepertoryService {

    @Autowired
    private TmRepertoryManager tmRepertoryManager;

    @Autowired
    private TmMaterialManager tmMaterialManager;

    @Override
    public Page<TmRepertoryEntity> listPage(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TmRepertoryEntity> page = new Page<>(query);
        tmRepertoryManager.list(page, query);
        return page;
    }

    @Override
    public R save(TmRepertoryEntity tmRepertoryEntity) throws RRException {
        //加减库存
        checkRepertory(tmRepertoryEntity);
        return CommonUtils.msg(tmRepertoryManager.save(tmRepertoryEntity));
    }

    @Override
    public R findById(Long id) {
        return CommonUtils.msg(tmRepertoryManager.findById(id));
    }

    @Override
    public R update(TmRepertoryEntity tmRepertoryEntity) {
        TmRepertoryEntity entity = tmRepertoryManager.findById(Long.parseLong(tmRepertoryEntity.getId().toString()));
        Integer num=~((entity.getNum()-tmRepertoryEntity.getNum())-1);
        TmRepertoryEntity tmRepertory = new TmRepertoryEntity();
        BeanUtils.copyProperties(tmRepertoryEntity,tmRepertory);
        tmRepertory.setNum(num);
        //加减库存
        checkRepertory(tmRepertory);
        return CommonUtils.msg(tmRepertoryManager.update(tmRepertoryEntity));
    }

    @Override
    public R batchRemove(Long[] id) {
        return CommonUtils.msg(tmRepertoryManager.batchRemove(id));
    }

    public void checkRepertory(TmRepertoryEntity tmRepertoryEntity){
        TmMaterialEntity tmMaterial = tmMaterialManager.findById(Long.parseLong(tmRepertoryEntity.getTmMaterialId().toString()));
        TmMaterialEntity tmMaterialEntity = new TmMaterialEntity();
        tmMaterialEntity.setId(tmRepertoryEntity.getTmMaterialId());
        if (TmRepertoryEntity.STATUS_0.equals(tmRepertoryEntity.getStatus())){
            tmMaterialEntity.setTotal(tmMaterial.getTotal()+tmRepertoryEntity.getNum());
        }else if (TmRepertoryEntity.STATUS_1.equals(tmRepertoryEntity.getStatus())){
            if (tmMaterial.getTotal()<tmRepertoryEntity.getNum()){
                throw new  RRException("出库数量大于库存总数，请审查库存！");
            }
            tmMaterialEntity.setTotal(tmMaterial.getTotal()-tmRepertoryEntity.getNum());
        }
        tmMaterialManager.update(tmMaterialEntity);
    }
}

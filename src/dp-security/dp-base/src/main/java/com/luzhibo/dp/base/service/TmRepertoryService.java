package com.luzhibo.dp.base.service;

import com.luzhibo.dp.base.entity.TmRepertoryEntity;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.exception.RRException;

import java.util.Map;

/**
 * @author 89754
 */
public interface TmRepertoryService {

    /**
     * 分页查询入库列表
     * @param params
     * @return Page<TmOrderEntity>
     */
    Page<TmRepertoryEntity> listPage(Map<String, Object> params);

    /**
     * 保存入库信息
     * @param tmRepertoryEntity
     * @return R
     */
    R save(TmRepertoryEntity tmRepertoryEntity) throws RRException;

    /**
     * 根据ID查询入库信息
     * @param id
     * @return R
     */
    R findById(Long id);

    /**
     * 根据ID查询入库信息
     * @param tmRepertoryEntity
     * @return R
     */
    R update(TmRepertoryEntity tmRepertoryEntity);

    /**
     * 根据ID批量删除入库信息
     * @param id
     * @return R
     */
    R batchRemove(Long[] id);
}

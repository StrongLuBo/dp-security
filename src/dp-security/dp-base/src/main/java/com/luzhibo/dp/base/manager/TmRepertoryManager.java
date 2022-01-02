package com.luzhibo.dp.base.manager;

import com.luzhibo.dp.base.entity.TmRepertoryEntity;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;

import java.util.List;

/**
 * @author 89754
 */
public interface TmRepertoryManager {

    /**
     * 获取入库列表
     * @param page
     * @param query
     * @return List<TmRepertoryEntity>
     */
    List<TmRepertoryEntity> list(Page<TmRepertoryEntity> page, Query query);

    /**
     * 保存入库记录
     * @param tmRepertoryEntity
     * @return int
     */
    int save(TmRepertoryEntity tmRepertoryEntity);

    /**
     * 根据ID查询入库记录
     * @param id
     * @return TmRepertoryEntity
     */
    TmRepertoryEntity findById(Long id);

    /**
     * 根据ID更新入库记录
     * @param tmRepertoryEntity
     * @return int
     */
    int update(TmRepertoryEntity tmRepertoryEntity);

    /**
     * 根据ID批量删除入库记录
     * @param id
     * @return int
     */
    int batchRemove(Long[] id);
}

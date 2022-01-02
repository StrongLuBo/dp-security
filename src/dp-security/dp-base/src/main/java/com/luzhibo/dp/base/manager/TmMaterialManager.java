package com.luzhibo.dp.base.manager;

import com.luzhibo.dp.base.entity.TmMaterialEntity;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;

import java.util.List;

/**
 * @author 89754
 */
public interface TmMaterialManager {

    /**
     * 获取分页钢材列表
     * @param page
     * @param query
     * @return List<TmMaterialEntity>
     */
    List<TmMaterialEntity> list(Page<TmMaterialEntity> page, Query query);

    /**
     * 保存钢材
     * @param tmMaterialEntity
     * @return int
     */
    int save(TmMaterialEntity tmMaterialEntity);

    /**
     * 根据ID查询钢材
     * @param id
     * @return TmMaterialEntity
     */
    TmMaterialEntity findById(Long id);

    /**
     * 根据ID更新钢材
     * @param tmMaterialEntity
     * @return int
     */
    int update(TmMaterialEntity tmMaterialEntity);

    /**
     * 根据ID批量删除钢材信息
     * @param id
     * @return int
     */
    int batchRemove(Long[] id);
}

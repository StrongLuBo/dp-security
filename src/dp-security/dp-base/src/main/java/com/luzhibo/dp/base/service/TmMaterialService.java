package com.luzhibo.dp.base.service;

import com.luzhibo.dp.base.entity.TmMaterialEntity;
import com.luzhibo.dp.base.entity.TmOrderEntity;
import com.luzhibo.dp.base.vo.MaterialListVo;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;

import java.util.List;
import java.util.Map;

/**
 * @author 89754
 */
public interface TmMaterialService {

    /**
     * 分页查询钢材列表
     * @param params
     * @return Page<TmMaterialEntity>
     */
    Page<TmMaterialEntity> list(Map<String, Object> params);

    /**
     * 保存钢材信息
     * @param tmMaterialEntity
     * @return R
     */
    R save(TmMaterialEntity tmMaterialEntity);

    /**
     * 根据ID查询订单信息
     * @param id
     * @return R
     */
    R findById(Long id);

    /**
     * 根据ID查询钢材信息
     * @param tmMaterialEntity
     * @return R
     */
    R update(TmMaterialEntity tmMaterialEntity);

    /**
     * 根据ID批量删除钢材
     * @param id
     * @return R
     */
    R batchRemove(Long[] id);

    /**
     * 查询建材列表
     * @return
     */
    List<MaterialListVo> listMaterial();
}

package com.luzhibo.dp.base.manager;

import com.luzhibo.dp.base.entity.TmOrderEntity;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.entity.SysLogEntity;

import java.util.List;

/**
 * @author 89754
 */
public interface TmOrderManager {

    /**
     * 获取分页订单列表
     * @param page
     * @param query
     * @return
     */
    List<TmOrderEntity> list(Page<TmOrderEntity> page, Query query);

    /**
     * 保存订单
     * @param order
     * @return
     */
    R save(TmOrderEntity order);

    /**
     * 根据ID查询订单
     * @param id
     * @return
     */
    R findById(Long id);

    /**
     * 根据ID更新订单
     * @param order
     * @return
     */
    R update(TmOrderEntity order);

    /**
     * 根据ID批量删除订单信息
     * @param id
     * @return
     */
    R batchRemove(Long[] id);
}

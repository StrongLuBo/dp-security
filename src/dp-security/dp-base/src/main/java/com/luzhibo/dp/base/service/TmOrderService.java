package com.luzhibo.dp.base.service;

import com.luzhibo.dp.base.entity.TmOrderEntity;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;

import java.util.List;
import java.util.Map;

/**
* @author 89754
* @description 针对表【tm_order】的数据库操作Service
* @createDate 2021-12-20 17:46:51
*/
public interface TmOrderService {

    /**
     * 分页查询订单列表
     * @param params
     * @return Page<TmOrderEntity>
     */
    Page<TmOrderEntity> listOrders(Map<String, Object> params);

    /**
     * 保存订单信息
     * @param tmOrderEntity
     * @return R
     */
    R saveOrder(TmOrderEntity tmOrderEntity);

    /**
     * 根据ID查询订单信息
     * @param id
     * @return R
     */
    R findById(Long id);

    /**
     * 根据ID查询订单信息
     * @param tmOrderEntity
     * @return R
     */
    R updateOrder(TmOrderEntity tmOrderEntity);

    /**
     * 根据ID批量删除订单
     * @param id
     * @return R
     */
    R batchRemove(Long[] id);
}

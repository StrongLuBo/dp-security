package com.luzhibo.dp.base.dao;

import com.luzhibo.dp.base.entity.TmOrderEntity;
import com.luzhibo.dp.common.dao.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author 89754
 */
@MapperScan
public interface TmOrderMapper extends BaseMapper<TmOrderEntity> {

    /**
     * 批量完成订单
     * @param tmOrderEntity
     * @return
     */
    int updateOrderSuccess(TmOrderEntity tmOrderEntity);
}

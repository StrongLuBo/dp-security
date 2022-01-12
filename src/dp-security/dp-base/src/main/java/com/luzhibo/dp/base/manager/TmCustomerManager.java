package com.luzhibo.dp.base.manager;

import com.luzhibo.dp.base.entity.TmCustomerEntity;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.entity.SysLogEntity;

import java.util.List;

/**
* @author 89754
* @description 针对表【tm_customer】的数据库操作Mapper
* @createDate 2021-12-20 17:52:04
* @Entity com.luzhibo.base.entity.TmCustomer
*/
public interface TmCustomerManager {

    List<TmCustomerEntity> list(Page<TmCustomerEntity> page, Query query);

    int save(TmCustomerEntity order);

    TmCustomerEntity findById(Long id);

    int update(TmCustomerEntity order);

    int batchRemove(Long[] id);

    List<TmCustomerEntity> listAll();
}

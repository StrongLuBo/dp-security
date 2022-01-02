package com.luzhibo.dp.base.service;

import com.luzhibo.dp.base.entity.TmCustomerEntity;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;

import java.util.List;
import java.util.Map;

/**
* @author 89754
* @description 针对表【tm_customer】的数据库操作Service
* @createDate 2021-12-20 17:52:05
*/
public interface TmCustomerService{

    /**
     * 客户分页查询列表
     * @param params
     * @return Page<TmCustomerEntity>
     */
    Page<TmCustomerEntity> listCustomer(Map<String, Object> params);

    /**
     * 保存客户信息
     * @param customer
     * @return R
     */
    R saveCustomer(TmCustomerEntity customer);

    /**
     * 根据ID获取客户
     * @param id
     * @return R
     */
    R findById(Long id);

    /**
     * 根据ID获取客户信息
     * @param customer
     * @return R
     */
    R updateCustomer(TmCustomerEntity customer);

    /**
     * 根据ID批量删除客户信息
     * @param id
     * @return R
     */
    R batchRemove(Long[] id);
}

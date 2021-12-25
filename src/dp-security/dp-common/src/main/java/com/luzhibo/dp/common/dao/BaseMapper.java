package com.luzhibo.dp.common.dao;

import java.util.List;

import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;

/**
 * 基础dao
 * @author 89754
 */
public interface BaseMapper<T> {
	
	/**
	 * 新增
	 * @param t
	 * @return int
	 */
	int save(T t);
	
	/**
	 * 新增
	 * @param query
	 * @return int
	 */
	int save(Query query);
	
	/**
	 * 批量新增
	 * @param items
	 * @return int
	 */
	int batchSave(List<T> items);
	
	/**
	 * 查询详情
	 * @param t
	 * @return T
	 */
	T find(T t);
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return T
	 */
	T findById(Object id);
	
	/**
	 * 更新
	 * @param t
	 * @return int
	 */
	int update(T t);
	
	/**
	 * 更新
	 * @param query
	 * @return int
	 */
	int update(Query query);
	
	/**
	 * 删除
	 * @param id
	 * @return int
	 */
	int remove(Object id);
	
	/**
	 * 逻辑删除
	 * @param id
	 * @return int
	 */
	int removeLogic(Object id);
	
	/**
	 * 批量删除
	 * @param id
	 * @return int
	 */
	int batchRemove(Object[] id);
	
	/**
	 * 批量逻辑删除
	 * @param id
	 * @return int
	 */
	int batchRemoveLogic(Object[] id);
	
	/**
	 * 分页查询列表
	 * @param page
	 * @param query
	 * @return List<T>
	 */
	List<T> listForPage(Page<T> page, Query query);
	
	/**
	 * 查询列表
	 * @param query
	 * @return List<T>
	 */
	List<T> list(Query query);
	
	/**
	 * 查询列表
	 * @return List<T>
	 */
	List<T> list();
	
	/**
	 * 统计
	 * @return int
	 */
	int countTotal();
	
	/**
	 * 统计
	 * @param query
	 * @return int
	 */
	int countTotal(Query query);

}

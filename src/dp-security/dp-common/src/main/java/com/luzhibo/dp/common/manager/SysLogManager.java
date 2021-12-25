package com.luzhibo.dp.common.manager;

import java.util.List;

import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.SysLogEntity;

/**
 * 系统日志
 * @author 89754
 *
 */
public interface SysLogManager {

	/**
	 * 保存系统日志
	 * @param log
	 */
	void saveLog(SysLogEntity log);

	/**
	 * 查询日志列表
	 * @param page
	 * @param query
	 * @return List<SysLogEntity>
	 */
	List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query);

	/**
	 * 根据ID删除系统日志
	 * @param id
	 * @return int
	 */
	int batchRemove(Long[] id);

	/**
	 * 删除所有日志
	 * @return int
	 */
	int batchRemoveAll();
	
}

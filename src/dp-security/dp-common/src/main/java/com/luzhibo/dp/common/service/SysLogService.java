package com.luzhibo.dp.common.service;

import java.util.Map;

import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.entity.SysLogEntity;

/**
 * 系统日志
 * @author 89754
 */
public interface SysLogService {

	/**
	 * 查询日志列表
	 * @param params
	 * @return Page<SysLogEntity>
	 */
	Page<SysLogEntity> listLog(Map<String, Object> params);

	/**
	 * 根据ID批量删除日志
	 * @param id
	 * @return R
	 */
	R batchRemove(Long[] id);

	/**
	 * 删除所有日志
	 * @return R
	 */
	R batchRemoveAll();
	
}

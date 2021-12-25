package com.luzhibo.dp.common.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.luzhibo.dp.common.entity.SysLogEntity;

/**
 * 系统日志 
 * @author 89754
 */
@MapperScan
public interface SysLogMapper extends BaseMapper<SysLogEntity> {

	/**
	 * 删除所有日志
	 * @return int
	 */
	int batchRemoveAll();
	
}

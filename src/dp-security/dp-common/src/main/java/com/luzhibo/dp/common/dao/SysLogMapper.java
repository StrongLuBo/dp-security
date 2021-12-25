package com.luzhibo.dp.common.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.luzhibo.dp.common.entity.SysLogEntity;

/**
 * 系统日志 
 *
 *
 * 2017年8月14日 下午8:19:01
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

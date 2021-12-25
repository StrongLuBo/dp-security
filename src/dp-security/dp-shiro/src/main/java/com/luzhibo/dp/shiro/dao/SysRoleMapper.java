package com.luzhibo.dp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.luzhibo.dp.common.dao.BaseMapper;
import com.luzhibo.dp.shiro.entity.SysRoleEntity;

/**
 * 系统角色
 *
 *
 * 2017年8月12日 上午12:35:51
 */
@MapperScan
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {

	/**
	 * 获取用户角色列表
	 * @param userId
	 * @return
	 */
	List<String> listUserRoles(Long userId);
	
}

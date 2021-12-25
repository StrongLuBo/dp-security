package com.luzhibo.dp.shiro.service;

import java.util.Map;

import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.shiro.entity.SysRoleEntity;

/**
 * 系统角色
 *
 *
 * 2017年8月12日 上午12:40:42
 */
public interface SysRoleService {

	Page<SysRoleEntity> listRole(Map<String, Object> params);
	
	R saveRole(SysRoleEntity role);
	
	R getRoleById(Long id);
	
	R updateRole(SysRoleEntity role);
	
	R batchRemove(Long[] id);
	
	R listRole();
	
	R updateRoleAuthorization(SysRoleEntity role);
	
}

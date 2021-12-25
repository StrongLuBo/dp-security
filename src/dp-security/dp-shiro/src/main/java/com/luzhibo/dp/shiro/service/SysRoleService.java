package com.luzhibo.dp.shiro.service;

import java.util.Map;

import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.shiro.entity.SysRoleEntity;

/**
 * 系统角色
 * @author 89754
 */
public interface SysRoleService {

	/**
	 * 查询角色列表
	 * @param params
	 * @return Page<SysRoleEntity>
	 */
	Page<SysRoleEntity> listRole(Map<String, Object> params);

	/**
	 * 保存角色
	 * @param role
	 * @return R
	 */
	R saveRole(SysRoleEntity role);

	/**
	 * 根据ID更新角色信息
	 * @param id
	 * @return R
	 */
	R getRoleById(Long id);

	/**
	 * 更新角色的信息
	 * @param role
	 * @return R
	 */
	R updateRole(SysRoleEntity role);

	/**
	 * 根据ID批量删除角色
	 * @param id
	 * @return R
	 */
	R batchRemove(Long[] id);

	/**
	 * 查询所有角色
	 * @return R
	 */
	R listRole();

	/**
	 * 更新角色
	 * @param role
	 * @return R
	 */
	R updateRoleAuthorization(SysRoleEntity role);
	
}

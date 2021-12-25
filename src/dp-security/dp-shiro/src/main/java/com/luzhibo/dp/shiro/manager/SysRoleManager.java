package com.luzhibo.dp.shiro.manager;

import java.util.List;

import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.shiro.entity.SysRoleEntity;

/**
 * 系统角色
 *
 * @author 89754
 */
public interface SysRoleManager {
	/**
	 * 查询角色列表
	 * @param page
	 * @param search
	 * @return List<SysRoleEntity>
	 */
	List<SysRoleEntity> listRole(Page<SysRoleEntity> page, Query search);

	/**
	 * 保存角色
	 * @param role
	 * @return int
	 */
	int saveRole(SysRoleEntity role);

	/**
	 * 根据ID查询角色
	 * @param id
	 * @return SysRoleEntity
	 */
	SysRoleEntity getRoleById(Long id);

	/**
	 * 根据ID更新角色信息
	 * @param role
	 * @return int
	 */
	int updateRole(SysRoleEntity role);

	/**
	 * 根据ID批量删除角色
	 * @param id
	 * @return int
	 */
	int batchRemove(Long[] id);

	/**
	 * 查询角色列表
	 * @return List<SysRoleEntity>
	 */
	List<SysRoleEntity> listRole();

	/**
	 * 更新角色
	 * @param role
	 * @return int
	 */
	int updateRoleAuthorization(SysRoleEntity role);
	
}

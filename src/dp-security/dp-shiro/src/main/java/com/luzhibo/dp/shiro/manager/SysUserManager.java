package com.luzhibo.dp.shiro.manager;

import java.util.List;
import java.util.Set;

import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.SysUserEntity;

/**
 * 系统用户
 * @author 89754
 */
public interface SysUserManager {

	/**
	 * 根据用户名获取用户信息
	 * @param username
	 * @return SysUserEntity
	 */
	SysUserEntity getByUserName(String username);

	/**
	 * 获取用户列表
	 * @param page
	 * @param search
	 * @return List<SysUserEntity>
	 */
	List<SysUserEntity> listUser(Page<SysUserEntity> page, Query search);

	/**
	 * 保存用户信息
	 * @param user
	 * @return int
	 */
	int saveUser(SysUserEntity user);

	/**
	 * 根据ID获取用户信息
	 * @param userId
	 * @return SysUserEntity
	 */
	SysUserEntity getById(Long userId);

	/**
	 * 根据ID更新用户信息
	 * @param user
	 * @return int
	 */
	int updateUser(SysUserEntity user);

	/**
	 * 根据ID批量删除用户信息
	 * @param id
	 * @return int
	 */
	int batchRemove(Long[] id);

	/**
	 * 查询用户
	 * @param userId
	 * @return Set<String>
	 */
	Set<String> listUserPerms(Long userId);

	/**
	 * 查询用户角色列表
	 * @param userId
	 * @return Set<String>
	 */
	Set<String> listUserRoles(Long userId);

	/**
	 * 更新用户密码
	 * @param query
	 * @return int
	 */
	int updatePswdByUser(Query query);

	/**
	 * 隐藏用户
	 * @param id
	 * @return int
	 */
	int updateUserEnable(Long[] id);

	/**
	 * 显示用户
	 * @param id
	 * @return int
	 */
	int updateUserDisable(Long[] id);

	/**
	 * 更新密码
	 * @param user
	 * @return int
	 */
	int updatePswd(SysUserEntity user);

	/**
	 * 根据ID更新用户信息
	 * @param userId
	 * @return SysUserEntity
	 */
	SysUserEntity getUserById(Long userId);
	
}

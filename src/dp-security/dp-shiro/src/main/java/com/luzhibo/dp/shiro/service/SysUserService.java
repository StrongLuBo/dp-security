package com.luzhibo.dp.shiro.service;

import java.util.Map;

import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.entity.SysUserEntity;

/**
 * 系统用户
 * @author 89754
 */
public interface SysUserService {

	/**
	 * 分页查询用户
	 * @param params
	 * @return Page<SysUserEntity>
	 */
	Page<SysUserEntity> listUser(Map<String, Object> params);

	/**
	 * 保存用户
	 * @param user
	 * @return R
	 */
	R saveUser(SysUserEntity user);

	/**
	 * 根据ID获取用户
	 * @param userId
	 * @return R
	 */
	R getUserById(Long userId);

	/**
	 * 更新用户信息
	 * @param user
	 * @return R
	 */
	R updateUser(SysUserEntity user);

	/**
	 * 更具ID批量删除用户
	 * @param id
	 * @return R
	 */
	R batchRemove(Long[] id);

	/**
	 * 更具用户ID获取信息
	 * @param userId
	 * @return R
	 */
	R listUserPerms(Long userId);

	/**
	 * 更新用户密码
	 * @param user
	 * @return R
	 */
	R updatePswdByUser(SysUserEntity user);

	/**
	 * 隐藏用户
	 * @param id
	 * @return R
	 */
	R updateUserEnable(Long[] id);

	/**
	 * 显示用户
	 * @param id
	 * @return R
	 */
	R updateUserDisable(Long[] id);

	/**
	 * 更新用户密码
	 * @param user
	 * @return R
	 */
	R updatePswd(SysUserEntity user);
	
}

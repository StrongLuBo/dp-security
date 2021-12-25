package com.luzhibo.dp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.luzhibo.dp.common.dao.BaseMapper;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.SysUserEntity;

/**
 * 系统用户dao
 * @author 89754
 */
@MapperScan
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

	/**
	 * 根据用户更新
	 * @param username
	 * @return SysUserEntity
	 */
	SysUserEntity getByUserName(String username);

	/**
	 * 根据菜单ID查询
	 * @param userId
	 * @return List<Long>
	 */
	List<Long> listAllMenuId(Long userId);

	/**
	 * 根据用户名更新密码
	 * @param query
	 * @return int
	 */
	int updatePswdByUser(Query query);

	/**
	 * 更新用户状态
	 * @param query
	 * @return int
	 */
	int updateUserStatus(Query query);

	/**
	 * 更新用户密码
	 * @param user
	 * @return int
	 */
	int updatePswd(SysUserEntity user);
	
}
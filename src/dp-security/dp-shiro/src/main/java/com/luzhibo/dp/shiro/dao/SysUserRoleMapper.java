package com.luzhibo.dp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.luzhibo.dp.common.dao.BaseMapper;
import com.luzhibo.dp.shiro.entity.SysUserRoleEntity;

/**
 * 用户与角色关系
 * @author 89754
 */
@MapperScan
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

	/**
	 * 获取用户角色ID
	 * @param userId
	 * @return List<Long>
	 */
	List<Long> listUserRoleId(Long userId);

	/**
	 * 根据用户ID删除角色
	 * @param id
	 * @return int
	 */
	int batchRemoveByUserId(Long[] id);

	/**
	 * 根据角色ID删除
	 * @param id
	 * @return int
	 */
	int batchRemoveByRoleId(Long[] id);
	
}

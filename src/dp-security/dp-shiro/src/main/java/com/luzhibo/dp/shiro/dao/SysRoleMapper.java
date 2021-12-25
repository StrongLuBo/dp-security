package com.luzhibo.dp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.luzhibo.dp.common.dao.BaseMapper;
import com.luzhibo.dp.shiro.entity.SysRoleEntity;

/**
 * 系统角色
 * @author 89754
 */
@MapperScan
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {

	/**
	 * 获取用户角色列表
	 * @param userId
	 * @return  List<String>
	 */
	List<String> listUserRoles(Long userId);
	
}

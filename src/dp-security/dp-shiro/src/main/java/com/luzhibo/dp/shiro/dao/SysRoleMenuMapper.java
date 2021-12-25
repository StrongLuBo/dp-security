package com.luzhibo.dp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.luzhibo.dp.common.dao.BaseMapper;
import com.luzhibo.dp.shiro.entity.SysRoleMenuEntity;

/**
 * 系统角色与菜单关系
 *
 *
 * 2017年8月13日 下午8:32:26
 */
@MapperScan
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {

	/**
	 * 根据菜单ID删除
	 * @param id
	 * @return
	 */
	int batchRemoveByMenuId(Long[] id);

	/**
	 * 根据角色ID删除
	 * @param id
	 * @return
	 */
	int batchRemoveByRoleId(Long[] id);

	/**
	 * 根据菜单ID查询
	 * @param id
	 * @return
	 */
	List<Long> listMenuId(Long id);
	
}

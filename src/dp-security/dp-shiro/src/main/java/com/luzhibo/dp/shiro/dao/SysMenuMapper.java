package com.luzhibo.dp.shiro.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.luzhibo.dp.common.dao.BaseMapper;
import com.luzhibo.dp.shiro.entity.SysMenuEntity;

/**
 * 系统菜单dao
 * @author 89754
 */
@MapperScan
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {
	/**
	 * 获取父级菜单ID
	 * @param parentId
	 * @return List<SysMenuEntity>
	 */
	List<SysMenuEntity> listParentId(Long parentId);

	/**
	 * 获取按钮
	 * @return List<SysMenuEntity>
	 */
	List<SysMenuEntity> listNotButton();

	/**
	 * 获取用户父级菜单
	 * @param userId
	 * @return  List<String>
	 */
	List<String> listUserPerms(Long userId);

}

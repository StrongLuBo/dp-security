package com.luzhibo.dp.shiro.manager;

import java.util.List;

import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.shiro.entity.SysMenuEntity;

/**
 * 系统菜单
 * @author 89754
 *
 */
public interface SysMenuManager {

	/**
	 * 根据ID获取用户菜单
	 * @param userId
	 * @return List<SysMenuEntity>
	 */
	List<SysMenuEntity> listUserMenu(Long userId);

	/**
	 * 根据ID获取父级菜单
	 * @param parentId
	 * @param menuIdList
	 * @return List<SysMenuEntity>
	 */
	List<SysMenuEntity> listParentId(Long parentId, List<Long> menuIdList);

	/**
	 * 获取菜单列表
	 * @param search
	 * @return List<SysMenuEntity>
	 */
	List<SysMenuEntity> listMenu(Query search);

	/**
	 * 获取按钮
	 * @return List<SysMenuEntity>
	 */
	List<SysMenuEntity> listNotButton();

	/**
	 * 保存菜单
	 * @param menu
	 * @return int
	 */
	int saveMenu(SysMenuEntity menu);

	/**
	 * 根据ID获取菜单
	 * @param id
	 * @return SysMenuEntity
	 */
	SysMenuEntity getMenuById(Long id);

	/**
	 * 根据ID跟新菜单
	 * @param menu
	 * @return int
	 */
	int updateMenu(SysMenuEntity menu);

	/**
	 * 根据ID删除菜单
	 * @param id
	 * @return int
	 */
	int batchRemove(Long[] id);
	
}

package com.luzhibo.dp.shiro.service;

import java.util.List;
import java.util.Map;

import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.shiro.entity.SysMenuEntity;

/**
 * 系统菜单
 * @author 89754
 */
public interface SysMenuService {

	/**
	 * 根据ID获取用户菜单
	 * @param userId
	 * @return R
	 */
	R listUserMenu(Long userId);

	/**
	 * 获取菜单列表
	 * @param params
	 * @return List<SysMenuEntity>
	 */
	List<SysMenuEntity> listMenu(Map<String, Object> params);

	/**
	 * 获取权限按钮
	 * @return R
	 */
	R listNotButton();

	/**
	 * 保存菜单
	 * @param menu
	 * @return R
	 */
	R saveMenu(SysMenuEntity menu);

	/**
	 * 根据ID获取菜单
	 * @param id
	 * @return R
	 */
	R getMenuById(Long id);

	/**
	 * 更具ID更新菜单
	 * @param menu
	 * @return R
	 */
	R updateMenu(SysMenuEntity menu);

	/**
	 * 根据ID批量删除
	 * @param id
	 * @return R
	 */
	R batchRemove(Long[] id);

}

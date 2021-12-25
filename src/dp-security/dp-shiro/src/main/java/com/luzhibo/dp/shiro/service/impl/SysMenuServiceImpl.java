package com.luzhibo.dp.shiro.service.impl;

import java.util.List;
import java.util.Map;

import com.luzhibo.dp.shiro.entity.SysMenuEntity;
import com.luzhibo.dp.shiro.manager.SysMenuManager;
import com.luzhibo.dp.shiro.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.utils.CommonUtils;

/**
 * 系统菜单
 *
 *
 * 2017年8月10日 上午10:36:31
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuManager sysMenuManager;

	@Override
	public R listUserMenu(Long userId) {
		return R.ok().put("menuList", sysMenuManager.listUserMenu(userId));
	}

	@Override
	public List<SysMenuEntity> listMenu(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysMenuEntity> menuList = sysMenuManager.listMenu(query);
		return menuList;
	}

	@Override
	public R listNotButton() {
		List<SysMenuEntity> menuList = sysMenuManager.listNotButton();
		SysMenuEntity root = new SysMenuEntity();
		root.setMenuId(0L);
		root.setName("一级菜单");
		root.setParentId(-1L);
		root.setOpen(true);
		menuList.add(root);
		return CommonUtils.msgNotNull(menuList);
	}

	@Override
	public R saveMenu(SysMenuEntity menu) {
		int count = sysMenuManager.saveMenu(menu);
		return CommonUtils.msg(count);
	}

	@Override
	public R getMenuById(Long id) {
		SysMenuEntity menu = sysMenuManager.getMenuById(id);
		return CommonUtils.msg(menu);
	}

	@Override
	public R updateMenu(SysMenuEntity menu) {
		int count = sysMenuManager.updateMenu(menu);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysMenuManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}

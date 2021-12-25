package com.luzhibo.dp.base.manager;

import java.util.List;

import com.luzhibo.dp.base.entity.SysMacroEntity;

/**
 * 通用字典
 * @author 89754
 */
public interface SysMacroManager {

	/**
	 * 查询通用列表
	 * @return List<SysMacroEntity>
	 */
	List<SysMacroEntity> listMacro();

	/**
	 * 查询通用配置列表
	 * @return List<SysMacroEntity>
	 */
	List<SysMacroEntity> listNotMacro();

	/**
	 * 保存通用配置
	 * @param macro
	 * @return int
	 */
	int saveMacro(SysMacroEntity macro);

	/**
	 * 根据ID获取通用配置
	 * @param id
	 * @return SysMacroEntity
	 */
	SysMacroEntity getObjectById(Long id);

	/**
	 * 更具ID更新通用配置
	 * @param macro
	 * @return int
	 */
	int updateMacro(SysMacroEntity macro);

	/**
	 * 根据ID删除通用配置
	 * @param id
	 * @return int
	 */
	int batchRemove(Long[] id);
	
}

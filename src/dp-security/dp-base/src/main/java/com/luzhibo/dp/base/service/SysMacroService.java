package com.luzhibo.dp.base.service;

import java.util.List;

import com.luzhibo.dp.base.entity.SysMacroEntity;
import com.luzhibo.dp.common.entity.R;

/**
 * 通用字典
 *
 * @author 89754
 */
public interface SysMacroService {

	/**
	 * 获取通用字段列表
	 * @return List<SysMacroEntity>
	 */
	List<SysMacroEntity> listMacro();

	/**
	 * 获取通用字典列表
	 * @return List<SysMacroEntity>
	 */
	List<SysMacroEntity> listNotMacro();

	/**
	 * 保存通用字典
	 * @param macro
	 * @return R
	 */
	R saveMacro(SysMacroEntity macro);

	/**
	 * 根据ID获取通用字典
	 * @param id
	 * @return R
	 */
	R getObjectById(Long id);

	/**
	 * 根据ID获取通用字典
	 * @param macro
	 * @return R
	 */
	R updateMacro(SysMacroEntity macro);

	/**
	 * 根据ID批量删除
	 * @param id
	 * @return R
	 */
	R batchRemove(Long[] id);
	
}

package com.luzhibo.dp.base.dao;

import java.util.List;

import com.luzhibo.dp.base.entity.SysMacroEntity;
import org.mybatis.spring.annotation.MapperScan;

import com.luzhibo.dp.common.dao.BaseMapper;

/**
 * 通用字典
 * @author 89754
 */
@MapperScan
public interface SysMacroMapper extends BaseMapper<SysMacroEntity> {

	/**
	 * 获取没有分页通用字典
	 * @return List<SysMacroEntity>
	 */
	List<SysMacroEntity> listNotMacro();
	
}

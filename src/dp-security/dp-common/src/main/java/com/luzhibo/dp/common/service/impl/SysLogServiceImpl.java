package com.luzhibo.dp.common.service.impl;

import java.util.Map;

import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.Query;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.entity.SysLogEntity;
import com.luzhibo.dp.common.manager.SysLogManager;
import com.luzhibo.dp.common.service.SysLogService;
import com.luzhibo.dp.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统日志
 * @author 89754
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogManager sysLogManager;
	
	@Override
	public Page<SysLogEntity> listLog(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysLogEntity> page = new Page<>(query);
		sysLogManager.listLog(page, query);
		return page;
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysLogManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R batchRemoveAll() {
		int count = sysLogManager.batchRemoveAll();
		return CommonUtils.msg(count);
	}

}

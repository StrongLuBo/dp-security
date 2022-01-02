package com.luzhibo.dp.base.controller;

import com.luzhibo.dp.base.entity.TmRepertoryEntity;
import com.luzhibo.dp.base.service.TmRepertoryService;
import com.luzhibo.dp.common.annotation.SysLog;
import com.luzhibo.dp.common.controller.AbstractController;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;
import com.luzhibo.dp.common.exception.RRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author 89754
 */
@RestController
@RequestMapping("/base/repertory")
public class RepertoryController extends AbstractController {

    @Autowired
    private TmRepertoryService tmRepertoryService;

    @PostMapping("/listPage")
    public Page<TmRepertoryEntity> list(@RequestBody Map<String, Object> params){
        return tmRepertoryService.listPage(params);
    }

    @SysLog("新增入库记录")
    @PostMapping("/save")
    public R save(@RequestBody TmRepertoryEntity TmRepertoryEntity) throws RRException {
        String materialName = TmRepertoryEntity.getMaterialName();
        String[] split = materialName.split("-");
        TmRepertoryEntity.setTmMaterialId(Integer.parseInt(split[0].toString()));
        TmRepertoryEntity.setMaterialName(split[1].toString());
        TmRepertoryEntity.setCreateUser(getUser().getUsername());
        TmRepertoryEntity.setCreateTime(new Date());
        return tmRepertoryService.save(TmRepertoryEntity);
    }

    @RequestMapping("/findById")
    public R findOrderById(@RequestBody Long id){
        return tmRepertoryService.findById(id);
    }
    @SysLog("修改入库记录")
    @RequestMapping("/update")
    public R update(@RequestBody TmRepertoryEntity TmRepertoryEntity){
        String materialName = TmRepertoryEntity.getMaterialName();
        String[] split = materialName.split("-");
        TmRepertoryEntity.setTmMaterialId(Integer.parseInt(split[0].toString()));
        TmRepertoryEntity.setMaterialName(split[1].toString());
        TmRepertoryEntity.setUpdateUser(getUser().getUsername());
        TmRepertoryEntity.setUpdateTime(new Date());
        return tmRepertoryService.update(TmRepertoryEntity);
    }

    @SysLog("删除入库记录")
    @RequestMapping("/remove")
    public R batchRemove (@RequestBody Long[] ids){
        return tmRepertoryService.batchRemove(ids);
    }

}

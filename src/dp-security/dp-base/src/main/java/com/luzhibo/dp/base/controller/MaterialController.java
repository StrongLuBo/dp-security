package com.luzhibo.dp.base.controller;

import com.luzhibo.dp.base.entity.TmMaterialEntity;
import com.luzhibo.dp.base.service.TmMaterialService;
import com.luzhibo.dp.base.vo.MaterialListVo;
import com.luzhibo.dp.common.annotation.SysLog;
import com.luzhibo.dp.common.controller.AbstractController;
import com.luzhibo.dp.common.entity.Page;
import com.luzhibo.dp.common.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 89754
 */
@RestController
@RequestMapping("/base/material")
public class MaterialController extends AbstractController {

    @Autowired
    private TmMaterialService tmMaterialService;


    @PostMapping("/listPage")
    public Page<TmMaterialEntity> list(@RequestBody Map<String, Object> params){
        return tmMaterialService.list(params);
    }

    @SysLog("新增建材")
    @PostMapping("/save")
    public R save(@RequestBody TmMaterialEntity tmMaterialEntity){
        tmMaterialEntity.setCreateUser(getUser().getUsername());
        tmMaterialEntity.setCreateTime(new Date());
        return tmMaterialService.save(tmMaterialEntity);
    }

    @RequestMapping("/findById")
    public R findOrderById(@RequestBody Long id){
        return tmMaterialService.findById(id);
    }
    @SysLog("修改建材")
    @RequestMapping("/update")
    public R update(@RequestBody TmMaterialEntity tmMaterialEntity){
        tmMaterialEntity.setUpdateUser(getUser().getUsername());
        tmMaterialEntity.setUpdateTime(new Date());
        return tmMaterialService.update(tmMaterialEntity);
    }

    @SysLog("删除建材")
    @RequestMapping("/remove")
    public R batchRemove (@RequestBody Long[] ids){
        return tmMaterialService.batchRemove(ids);
    }

    @RequestMapping("/findSelectAll")
    @ResponseBody
    public List<MaterialListVo> findSelectAll(){
        return tmMaterialService.listMaterial();
    }
}

package com.luzhibo.dp.base.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 89754
 */
@Data
public class TmRepertoryEntity {

    /**
     * 入库
     */
    public final static Integer STATUS_0=0;
    /**
     * 出库
     */
    public final static Integer STATUS_1=1;
    private Integer id;
    private Integer status;
    private Integer num;
    private Integer tmMaterialId;
    private String materialName;
    private String remarks;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
}

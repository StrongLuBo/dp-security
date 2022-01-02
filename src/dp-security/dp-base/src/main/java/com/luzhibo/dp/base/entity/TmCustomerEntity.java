package com.luzhibo.dp.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 89754
 * @TableName tm_customer
 */
@Data
public class TmCustomerEntity implements Serializable {
    /**
     * 
     */
    private Integer customerId;

    /**
     * 客户姓名
     */
    private String cName;

    /**
     * 客户手机号
     */
    private String cMobile;

    /**
     * 客户住址
     */
    private String cAddress;

    /**
     * 状态 0:禁用，1:正常
     */
    private Integer cStatus;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private String createUser;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String updateUser;

}
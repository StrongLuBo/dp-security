package com.luzhibo.dp.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author 89754
 * @TableName tm_order
 */
@Data
public class TmOrderEntity implements Serializable {

    public final static Integer ORDERSTATUS_0=0;
    public final static Integer ORDERSTATUS_1=1;
    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 客户ID
     */
    private Integer customerId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 订单状态0，进行中，1，已完成
     */
    private Integer orderStatus;

    /**
     * 订单已支付的总金额
     */
    private BigDecimal payMoneySum;

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
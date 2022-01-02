package com.luzhibo.dp.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 材料类
 * 对应数据库的tbl_material
 * @author 89754
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TmMaterialEntity implements Serializable {

    private Integer id;
    private String name;
    private String model;
    private Double specification;
    private String unit;
    private Double price;
    private Integer stocks;
    private Integer total;
    private String description;
    private Double cost;
    private char valid;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

}

package com.yongyuan.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author fengsheming
 * @since 2024-04-23
 */
@Getter
@Setter
@TableName("commodity")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("sort")
    private String sort;

    @TableField("cost")
    private BigDecimal cost;

    @TableField("price")
    private BigDecimal price;


}

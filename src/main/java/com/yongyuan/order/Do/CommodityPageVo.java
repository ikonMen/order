package com.yongyuan.order.Do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class CommodityPageVo {
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

package com.yongyuan.order.Do;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CommodityInsertDto {

    private Integer id;

    private String name;

    private String sort;

    private BigDecimal cost;

    private BigDecimal price;

}

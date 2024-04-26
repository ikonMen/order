package com.yongyuan.order.Do;

import lombok.Data;

@Data
public class SearchDto extends BasePageDto {
    private String commodityName;
    private String commoditySort;

}

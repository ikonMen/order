package com.yongyuan.order.Do;

import lombok.Data;

import java.util.List;
@Data
public class ChangeSortDto {
    private List<String> removeIds;
    private List<String> insertSortNames;
}

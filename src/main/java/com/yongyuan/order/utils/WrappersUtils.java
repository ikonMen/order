package com.yongyuan.order.utils;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WrappersUtils {
    public static <T,U> List<T> reverseListVo(List<U> list, Class<T> cls){
        List<T> resultList = new ArrayList<>();
        for (U sourceObj : list) {
            T targetObj = BeanUtil.copyProperties(sourceObj,cls);
            resultList.add(targetObj);
        }
        return resultList;
    }

    public static <T> IPage<T> reverseListVoOfPage(IPage page, Class<T> cls){
        List list=page.getRecords();
        List<T> resultList = reverseListVo(list, cls);
        page.setRecords(resultList);
        return page;
    }

    public static QueryWrapper collectSqlParamsFromCls(QueryWrapper query, Class cls){
        List<String> paramsList=new ArrayList<>();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(TableField.class)  ){
                paramsList.add(field.getAnnotation(TableField.class).value());
            }else if (field.isAnnotationPresent(TableId.class)){
                paramsList.add(field.getAnnotation(TableId.class).value());
            }
        }
        String[] paramsArr = paramsList.toArray(new String[paramsList.size()]);
        query.select(paramsArr);
        return query;
    }



    @SneakyThrows
    public static <U,T> T copyPropertiesByMap(HashMap<String,String> map, U sourceObj, T targetObj){
        Class<?> sClass = sourceObj.getClass();
        Class<?> tClass = targetObj.getClass();
        for (String sourceFieldName : map.keySet()) {
            Field sourceField = sClass.getDeclaredField(sourceFieldName);
            sourceField.setAccessible(true);
            Object sourceValue = sourceField.get(sourceObj);
            Field targetField = tClass.getDeclaredField(map.get(sourceFieldName));
            targetField.setAccessible(true);
            targetField.set(targetObj,sourceValue);
        }
        return targetObj;
    }
}

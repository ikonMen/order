package com.yongyuan.order.common;

import lombok.Data;

@Data
public class Result<T> {
    private String message;
    private T data;
    private int code;

    private Result(){}

    private Result(T data){
        this.data=data;
        this.code=200;
    }

    private Result(String message){
        this.message=message;
        this.code=500;
    }


    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>(data);
        return result;
    }

    public static <T> Result<T> fail(String message){
        Result<T> result = new Result<>(message);
        return result;
    }


}
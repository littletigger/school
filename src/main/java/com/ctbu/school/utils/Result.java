package com.ctbu.school.utils;

import lombok.Data;

@Data
public class Result<T> {
    /*响应码*/
     int code=1;
    /*响应消息*/
    String msg;
    /*数据单元*/
    T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功时候的调用
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }


    /**
     * 失败时候的调用
     */
    public static <T> Result<T> error(int code, String msg) {
        return new Result<T>(code, msg);
    }


}
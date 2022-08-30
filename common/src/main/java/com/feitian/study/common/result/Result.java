package com.feitian.study.common.result;

import lombok.Data;
import lombok.ToString;

// 统一返回结果

@Data
@ToString
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回特定的结果集
     *
     * @param resultCode 枚举类
     * @return R
     */
    public static Result setResult(ResponseCode resultCode) {
        Result R = new Result();
        R.setCode(resultCode.getCode());
        R.setMessage(resultCode.getMessage());
        return R;
    }

    public static Result ok() {
        Result R = new Result();
        R.setCode(ResponseCode.SUCCESS.getCode());
        return R;
    }

    public Result<T> result(ResponseCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
        return this;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }

    public Result code(Integer code) {
        this.code = code;
        return this;
    }

}

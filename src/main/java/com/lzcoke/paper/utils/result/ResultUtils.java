package com.lzcoke.paper.utils.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

@ApiModel("结果参数")
public class ResultUtils<T> {
    @ApiModelProperty(required = true, notes = "结果码", example = "200")
    private int code = 404;

    @ApiModelProperty(required = true, notes = "返回信息说明", example = "SUCCESS")
    private String message = "success";

    @ApiModelProperty(required = true, notes = "返回数据")
    private T data;

    private ResultUtils(T data) {
        this.code = 200;
        this.message = "获取成功";
        this.data = data;
    }

    private ResultUtils(String message) {
        this.code = 500;
        this.message = message;
        Map<String, Object> map = new HashMap<>();
        this.data = (T) map;
    }

    public static <T> ResultUtils<T> success(T data) {
        return new ResultUtils<T>(data);
    }

    public static <T> ResultUtils<T> error(String message) {
        return new ResultUtils<T>(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

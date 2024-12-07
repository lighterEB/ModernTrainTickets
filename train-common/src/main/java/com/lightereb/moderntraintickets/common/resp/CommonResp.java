package com.lightereb.moderntraintickets.common.resp;

import lombok.Data;

@Data
public class CommonResp<T> {

    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 响应码
     */
    private String code;

    /**
     * 返回泛型数据，自定义类型
     */
    private T data;


    public CommonResp(boolean success, String code,String message, T content) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = content;
    }

    public static <T> CommonResp<T> ok() {
        return new CommonResp<>(true, "200", "操作成功", null);
    }

    public static <T> CommonResp<T> ok(String message, T content) {
        return new CommonResp<>(true, "200", message, content);
    }

    public static <T> CommonResp<T> ok(String code, String message, T content) {
        return new CommonResp<>(true, code, message, content);
    }

    public static <T> CommonResp<T> ok(String message) {
        return new CommonResp<>(true, "200", message, null);
    }

    public static <T> CommonResp<T> failed(String message, T content) {
        return new CommonResp<>(true, "500", message, content);
    }

    public static <T> CommonResp<T> failed(String code, String message, T content) {
        return new CommonResp<>(true, code, message, content);
    }

    public static <T> CommonResp<T> failed(String message) {
        return new CommonResp<>(true, "500", message, null);
    }
}

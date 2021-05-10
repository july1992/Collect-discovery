package com.vily.collect.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应业务状态
     */
    private Integer code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应中的数据
     */
    private T data;

    public ResultVO(T data) {
        this.code = 0;
        this.message = "success";
        this.data = data;
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    public static <T> ResultVO<T> ok(T data) {
        return new ResultVO(data);
    }

    public static <T> ResultVO<T> error(Integer code, String msg) {
        return error(code,msg,null);
    }

    public static <T> ResultVO<T> error(Integer code, String msg, T t) {
        return new ResultVO(code, msg, t);
    }

}

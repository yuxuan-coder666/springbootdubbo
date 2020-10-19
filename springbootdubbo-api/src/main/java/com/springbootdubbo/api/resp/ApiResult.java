package com.springbootdubbo.api.resp;

import java.io.Serializable;

import com.springbootdubbo.api.enums.RespCode;

/**
 * 封装的restfulAPI
 * @author liuyuxuan
 *
 * @param <T>
 */
public class ApiResult<T> implements Serializable{
	
    public static final String CODE_OK = "000000";
    public static final String DEFAULT_OK_MSG = "请求成功";
    public static final String CODE_FAIL = "999999";
    public static final String DEFAULT_FAIL_MSG = "请求失败";
    private String resultCode ;
    private String msg;
    private T data;

    public ApiResult() {
    }

    public ApiResult(String code) {
        this.resultCode  = code;
    }

    public ApiResult(String resultCode , String msg) {
        this.resultCode  = resultCode ;
        this.msg = msg;
    }

    public ApiResult(String resultCode , String msg, T data) {
        this.resultCode  = resultCode ;
        this.msg = msg;
        this.data = data;
    }

    public static  ApiResult OK() {
        return new ApiResult(CODE_OK, DEFAULT_OK_MSG);
    }
    
    public static  ApiResult OK(Object data) {
    	return new ApiResult(CODE_OK, DEFAULT_OK_MSG, data);
    }

    public static ApiResult FAIL() {
        return new ApiResult(CODE_FAIL, DEFAULT_FAIL_MSG);
    }
    
    public static ApiResult FAIL(String message) {
        return new ApiResult(CODE_FAIL, message);
    }
    
    public static ApiResult FAIL(RespCode respCode) {
    	return new ApiResult(respCode.getCode(), respCode.getMsg());
    }


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

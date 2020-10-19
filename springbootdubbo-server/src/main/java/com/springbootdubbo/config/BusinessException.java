package com.springbootdubbo.config;

import com.springbootdubbo.api.enums.RespCode;

import lombok.Data;

/**
 * 自定义异常
 * @author liuyuxuan
 *
 */
@Data
public class BusinessException extends RuntimeException {
	
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误原因
     */
    private String errorMsg;

    public BusinessException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public BusinessException(RespCode accountingRespCode) {
    	this.errorCode = accountingRespCode.getCode();
    	this.errorMsg = accountingRespCode.getMsg();
    }

    public BusinessException(String message, String errorCode, String errorMsg) {
        super(message);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(String message, Throwable cause, String errorCode, String errorMsg) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BusinessException(Throwable cause, String errorCode, String errorMsg) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}

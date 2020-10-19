package com.springbootdubbo.api.enums;

/**
 * 统一响应码
 * @author liuyuxuan
 *
 */
public enum RespCode {
	
	/**
	 * 响应码定义规则
	 * 响应码长度为6位数字,列如:100502
	 * 其中前2位为服务错误级别码值,中间2位为服务模块代码,后2位为具体错误代码
	 */
	
	SUCCESS("000000","成功"),
    ERROR("999999","失败"),
	PARAM_FAIL("102001","参数错误");

	
    private String code;

    private String msg;
    RespCode(){

    }
    RespCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RespCode find(String code){
        RespCode[] values = RespCode.values();
        for(RespCode status : values){
            if(status.code.equalsIgnoreCase(code)){
                return status;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

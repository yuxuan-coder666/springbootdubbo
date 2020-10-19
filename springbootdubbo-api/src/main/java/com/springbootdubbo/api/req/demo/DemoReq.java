package com.springbootdubbo.api.req.demo;

import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class DemoReq implements Serializable {

	@NotBlank(message = "类型不能为空")
    @Size(max = 2,message = "类型最大长度2个字符")
    private String type;

    @NotBlank(message = "手机号不能为空")
//    @Pattern(regexp = "^(1[3-9][0-9])\\d{8}$",message = "手机号格式不正确")
    private String phone;
}

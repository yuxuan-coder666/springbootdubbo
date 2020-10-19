package com.springbootdubbo.api.resp.demo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DemoResp implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
    
    private int age;
    
    private Integer sum;
    
    private Date time;
    
    private Object obj;

}

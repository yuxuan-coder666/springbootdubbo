package com.springbootdubbo.server.entity;

import javax.persistence.Column;
import javax.persistence.Table;

import com.springbdubbo.commons.entity.BaseEntity;

import lombok.Data;

@Table(name = "demo_table")
@Data
public class Demo extends BaseEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	

}

package com.springbdubbo.commons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 实体基类
 * @author liuyuxuan
 *
 */
public class BaseEntity {
	
	@Id
	private String id;

	@Column(name = "create_userid")
	private String createUserId;
	
	@Column(name = "create_username")
	private String createUserName;
	
	@Column(name = "is_deleted")
	private Integer isDeleted;
	
	@Column(name = "version")
	private Integer version;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_time")
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


}

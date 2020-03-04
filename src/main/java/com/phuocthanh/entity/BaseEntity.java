package com.phuocthanh.entity;

import java.util.Date;

import com.phuocthanh.annotation.Column;

public class BaseEntity {
	@Column(name="id")
	protected Long id;
	@Column(name="createddate")
	protected Date createdDate;
	@Column(name="modifieddate")
	protected Date modifiedDate;
	@Column(name="createdby")
	protected String createdBy;
	@Column(name="modifiedby")
	protected String modifiedBy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
}

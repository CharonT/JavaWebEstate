package com.phuocthanh.entity;

import com.phuocthanh.annotation.Column;
import com.phuocthanh.annotation.Entity;
import com.phuocthanh.annotation.Table;

@Entity
@Table(name="rentarea")
public class RentAreaEntity extends BaseEntity {
	@Column(name="buildingid")
	private Long buildingId;
	@Column(name="value")
	private Integer value;
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}

}

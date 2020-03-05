package com.phuocthanh.dto;

public class RentAreaDTO extends BaseDTO {
	private Long buildingId;
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

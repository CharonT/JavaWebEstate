package com.phuocthanh.api.input;

public class RentAreaInput {
	private Long buildingId;
	private Integer[] value=new Integer[] {};
	public Long getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	public Integer[] getValue() {
		return value;
	}
	public void setValue(Integer[] value) {
		this.value = value;
	}
	
}

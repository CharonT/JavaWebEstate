package com.phuocthanh.enums;

public enum BuildingTypeEnum {
	TANG_TRET("Tầng Trệt"),
	NGUYEN_CAN("Nguyên Căn"),
	NOI_THAT("Nội Thất");
	
	private String value;
	
	private BuildingTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}

package com.phuocthanh.service;

import java.util.List;
import java.util.Map;

import com.phuocthanh.api.output.BuildingTypeOutput;
import com.phuocthanh.builder.BuildingSearchBuilder;
import com.phuocthanh.dto.BuildingDTO;
import com.phuocthanh.dto.RentAreaDTO;

public interface IBuildingService {
	List<BuildingDTO> findAll(BuildingSearchBuilder builder);
	List<BuildingDTO> findById(Object...ids);
	Long save(BuildingDTO dto);
	Long save(RentAreaDTO dto);
	List<Long> upgrade(BuildingDTO dto,Object ...where);
	void dropById(Object... ids);
	void dropRandom(BuildingDTO dto);
	List<BuildingTypeOutput> getBuildingType(); //nhớ nghiên cứu rồi thay buidingTypeoutput thành dto
	Map<String,String> getMapBuildingType();
}

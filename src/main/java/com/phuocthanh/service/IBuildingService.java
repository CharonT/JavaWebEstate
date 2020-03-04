package com.phuocthanh.service;

import java.util.List;
import com.phuocthanh.builder.BuildingSearchBuilder;
import com.phuocthanh.dto.BuildingDTO;

public interface IBuildingService {
	List<BuildingDTO> findAll(BuildingSearchBuilder builder);
	List<BuildingDTO> findById(Object...ids);
	Long save(BuildingDTO dto);
	List<Long> upgrade(BuildingDTO dto,Object ...where);
	void dropById(Object... ids);
	void dropRandom(BuildingDTO dto);
}

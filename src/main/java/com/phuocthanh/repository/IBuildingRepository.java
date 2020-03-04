package com.phuocthanh.repository;

import java.util.List;
import java.util.Map;

import com.phuocthanh.builder.BuildingSearchBuilder;
import com.phuocthanh.dto.BuildingDTO;
import com.phuocthanh.entity.BuildingEntity;

public interface IBuildingRepository extends JpaRepository<BuildingEntity> {
	List<BuildingEntity> findAll(Map<String,Object> params,BuildingSearchBuilder builder);
}

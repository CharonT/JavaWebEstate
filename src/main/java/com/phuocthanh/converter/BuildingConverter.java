package com.phuocthanh.converter;

import org.modelmapper.ModelMapper;

import com.phuocthanh.dto.BuildingDTO;
import com.phuocthanh.entity.BuildingEntity;

public class BuildingConverter {
	private ModelMapper modelMapper =new ModelMapper();
	public BuildingDTO convertEntityToDTO(BuildingEntity entity) {
		BuildingDTO buildingDTO=modelMapper.map(entity,BuildingDTO.class); //map thằng entity vs vo thằng DTO
		return buildingDTO;
	}
	public BuildingEntity convertDTOToEntity(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity=modelMapper.map(buildingDTO,BuildingEntity.class);
		return buildingEntity;
	}
	
}

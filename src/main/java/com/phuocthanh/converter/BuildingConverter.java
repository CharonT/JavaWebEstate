package com.phuocthanh.converter;

import org.modelmapper.ModelMapper;

import com.phuocthanh.dto.BuildingDTO;
import com.phuocthanh.dto.RentAreaDTO;
import com.phuocthanh.entity.BuildingEntity;
import com.phuocthanh.entity.RentAreaEntity;

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
	
	public RentAreaDTO convertEntityToDTO(RentAreaEntity entity) {
		RentAreaDTO rentAreaDTO=modelMapper.map(entity,RentAreaDTO.class); //map thằng entity vs vo thằng DTO
		return rentAreaDTO;
	}
	public RentAreaEntity convertDTOToEntity(RentAreaDTO rentAreaDTO) {
		RentAreaEntity entity=modelMapper.map(rentAreaDTO,RentAreaEntity.class);
		return entity;
	}
	
}	

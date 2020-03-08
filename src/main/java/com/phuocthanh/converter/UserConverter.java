package com.phuocthanh.converter;

import org.modelmapper.ModelMapper;

import com.phuocthanh.dto.UserDTO;
import com.phuocthanh.entity.BuildingEntity;
import com.phuocthanh.entity.UserEntity;

public class UserConverter {
	private ModelMapper modelMapper =new ModelMapper();
	public UserDTO convertEntityToDTO(UserEntity entity) {
		UserDTO userDTO=modelMapper.map(entity,UserDTO.class); //map thằng entity vs vo thằng DTO
		return userDTO;
	}
	public UserEntity convertDTOToEntity(UserDTO buildingDTO) {
		UserEntity userEntity=modelMapper.map(buildingDTO,UserEntity.class);
		return userEntity	;
	}
}

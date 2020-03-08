package com.phuocthanh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.phuocthanh.converter.UserConverter;
import com.phuocthanh.dto.UserDTO;
import com.phuocthanh.entity.UserEntity;
import com.phuocthanh.repository.IUserRepository;
import com.phuocthanh.repository.impl.UserRepository;
import com.phuocthanh.service.IUserService;

public class UserService implements IUserService {
	private IUserRepository userRepository=new UserRepository();
	private UserConverter userConverter=new UserConverter();
	@Override
	public List<UserDTO> findStaffs(String roleCode) {
		List<UserEntity> entities=userRepository.findByRole(roleCode);
		List<UserDTO> results=entities.stream()
				.map(item->userConverter.convertEntityToDTO(item)).collect(Collectors.toList());
		results.stream().forEach(item ->{
			item.setChecked("");	
			if(userRepository.findStaffId().contains(item.getId())) {
				item.setChecked("checked");	
			}
		});
		return results;
	}
}

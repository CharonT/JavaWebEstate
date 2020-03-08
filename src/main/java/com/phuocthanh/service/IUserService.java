package com.phuocthanh.service;

import java.util.List;

import com.phuocthanh.dto.UserDTO;

public interface IUserService {
	List<UserDTO> findStaffs(String roleCode);
}

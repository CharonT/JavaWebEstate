package com.phuocthanh.repository;

import java.util.List;

import com.phuocthanh.dto.UserDTO;
import com.phuocthanh.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity>{
	List<UserEntity> findByRole(String roleCode);
	List<Long> findStaffId();
	
}	

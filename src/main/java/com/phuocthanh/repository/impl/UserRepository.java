package com.phuocthanh.repository.impl;

import java.util.List;

import com.phuocthanh.entity.UserEntity;
import com.phuocthanh.repository.IUserRepository;

public class UserRepository extends SimpleJpaRepository<UserEntity> implements IUserRepository{

	@Override
	public List<UserEntity> findByRole(String roleCode) {
		StringBuilder sql=new StringBuilder("SELECT * FROM user u ");
		sql.append(" INNER JOIN user_role ur on u.id = ur.userid");
		sql.append(" INNER JOIN role r on r.id = ur.roleid");
		sql.append(" WHERE r.code= '"+roleCode+"' ");
		//giải thích sql query : lấy từ user inner join(để lấy tất cả cái trùng) join với userrole vì user role có chưa roleid (loại user) nên 
		//kết quả trả về là 1 bảng các userid có trong user role bảng đó inner join với role để lấy những thằng trùng với role id của nó tương ứng với manager hay staff
		return this.findAll(sql.toString());
	}

	@Override
	public List<Long> findStaffId() {
		StringBuilder query=new StringBuilder("SELECT * FROM assignmentbuilding ");

		return this.checked(query.toString());
	}

}

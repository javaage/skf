package com.skf.management.mapper;

import java.util.List;

import com.skf.management.entity.UserOEMEntity;

public interface UserOEMMapper {

	/**
	 * Add By Jamie 20180608
	 * @param userCode
	 * @return List<UserOEMEntity>
	 */
	List<UserOEMEntity> selectByUserCode(String userCode);
}
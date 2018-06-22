package com.skf.management.mapper;

import java.util.List;

import com.skf.management.entity.UserCustomerEntity;

public interface UserCustomerMapper {

	/**
	 * Add By Jamie 20180608
	 * @param userCode
	 * @return List<UserCustomerEntity>
	 */
	List<UserCustomerEntity> selectByUserCode(String code);
}
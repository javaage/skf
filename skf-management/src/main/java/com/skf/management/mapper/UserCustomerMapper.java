package com.skf.management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skf.management.entity.UserCustomerEntity;
import com.skf.management.model.UserCustomerModelExample;
import com.skf.management.model.UserCustomerModelKey;

public interface UserCustomerMapper {

	/**
	 * Add By Jamie 20180608
	 * @param userCode
	 * @return List<UserCustomerEntity>
	 */
	List<UserCustomerEntity> selectByUserCode(String userCode);
}
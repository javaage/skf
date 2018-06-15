package com.skf.management.mapper;

import com.skf.management.entity.UserOEMEntity;
import com.skf.management.model.UserOEMModelExample;
import com.skf.management.model.UserOEMModelKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserOEMMapper {

	/**
	 * Add By Jamie 20180608
	 * @param userCode
	 * @return List<UserOEMEntity>
	 */
	List<UserOEMEntity> selectByUserCode(String userCode);
}
package com.skf.management.mapper;

import com.skf.management.entity.UserOEMEntity;
import com.skf.management.model.UserOEMModelExample;
import com.skf.management.model.UserOEMModelKey;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserOEMModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_OEM
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	long countByExample(UserOEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_OEM
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int deleteByExample(UserOEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_OEM
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int deleteByPrimaryKey(UserOEMModelKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_OEM
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int insert(UserOEMModelKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_OEM
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int insertSelective(UserOEMModelKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_OEM
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	List<UserOEMModelKey> selectByExample(UserOEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_OEM
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int updateByExampleSelective(@Param("record") UserOEMModelKey record,
			@Param("example") UserOEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_OEM
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int updateByExample(@Param("record") UserOEMModelKey record, @Param("example") UserOEMModelExample example);

}
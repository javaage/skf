package com.skf.management.mapper;

import com.skf.management.model.UserModel;
import com.skf.management.model.UserModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	long countByExample(UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int deleteByExample(UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int insert(UserModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int insertSelective(UserModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	List<UserModel> selectByExampleWithBLOBs(UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	List<UserModel> selectByExample(UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	UserModel selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByExampleSelective(@Param("record") UserModel record, @Param("example") UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByExampleWithBLOBs(@Param("record") UserModel record, @Param("example") UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByExample(@Param("record") UserModel record, @Param("example") UserModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByPrimaryKeySelective(UserModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByPrimaryKeyWithBLOBs(UserModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByPrimaryKey(UserModel record);
}
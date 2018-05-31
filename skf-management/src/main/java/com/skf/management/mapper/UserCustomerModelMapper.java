package com.skf.management.mapper;

import com.skf.management.model.UserCustomerModelExample;
import com.skf.management.model.UserCustomerModelKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCustomerModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_CSTM
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	long countByExample(UserCustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_CSTM
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int deleteByExample(UserCustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_CSTM
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int deleteByPrimaryKey(UserCustomerModelKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_CSTM
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int insert(UserCustomerModelKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_CSTM
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int insertSelective(UserCustomerModelKey record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_CSTM
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	List<UserCustomerModelKey> selectByExample(UserCustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_CSTM
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExampleSelective(@Param("record") UserCustomerModelKey record,
			@Param("example") UserCustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_USR_CSTM
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExample(@Param("record") UserCustomerModelKey record,
			@Param("example") UserCustomerModelExample example);
}
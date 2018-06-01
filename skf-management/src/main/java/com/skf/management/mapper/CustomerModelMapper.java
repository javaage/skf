package com.skf.management.mapper;

import com.skf.management.model.CustomerModel;
import com.skf.management.model.CustomerModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	long countByExample(CustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int deleteByExample(CustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int insert(CustomerModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int insertSelective(CustomerModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	List<CustomerModel> selectByExampleWithBLOBs(CustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	List<CustomerModel> selectByExample(CustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	CustomerModel selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByExampleSelective(@Param("record") CustomerModel record, @Param("example") CustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByExampleWithBLOBs(@Param("record") CustomerModel record, @Param("example") CustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByExample(@Param("record") CustomerModel record, @Param("example") CustomerModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByPrimaryKeySelective(CustomerModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByPrimaryKeyWithBLOBs(CustomerModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CSTM
	 * @mbg.generated  Fri Jun 01 09:24:15 CST 2018
	 */
	int updateByPrimaryKey(CustomerModel record);
}
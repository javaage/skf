package com.skf.management.mapper;

import com.skf.management.model.SensorModel;
import com.skf.management.model.SensorModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensorModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	long countByExample(SensorModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int deleteByExample(SensorModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int insert(SensorModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int insertSelective(SensorModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	List<SensorModel> selectByExample(SensorModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	SensorModel selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int updateByExampleSelective(@Param("record") SensorModel record, @Param("example") SensorModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int updateByExample(@Param("record") SensorModel record, @Param("example") SensorModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int updateByPrimaryKeySelective(SensorModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_SNSR
	 * @mbg.generated  Wed Jun 20 16:31:56 CST 2018
	 */
	int updateByPrimaryKey(SensorModel record);
}
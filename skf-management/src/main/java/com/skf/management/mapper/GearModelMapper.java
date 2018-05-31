package com.skf.management.mapper;

import com.skf.management.model.GearModel;
import com.skf.management.model.GearModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GearModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	long countByExample(GearModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int deleteByExample(GearModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int insert(GearModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int insertSelective(GearModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	List<GearModel> selectByExample(GearModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	GearModel selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExampleSelective(@Param("record") GearModel record, @Param("example") GearModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExample(@Param("record") GearModel record, @Param("example") GearModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByPrimaryKeySelective(GearModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_GEAR
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByPrimaryKey(GearModel record);
}
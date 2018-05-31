package com.skf.management.mapper;

import com.skf.management.model.BearingModel;
import com.skf.management.model.BearingModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BearingModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	long countByExample(BearingModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int deleteByExample(BearingModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int insert(BearingModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int insertSelective(BearingModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	List<BearingModel> selectByExample(BearingModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	BearingModel selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int updateByExampleSelective(@Param("record") BearingModel record, @Param("example") BearingModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int updateByExample(@Param("record") BearingModel record, @Param("example") BearingModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int updateByPrimaryKeySelective(BearingModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_brng
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int updateByPrimaryKey(BearingModel record);
}
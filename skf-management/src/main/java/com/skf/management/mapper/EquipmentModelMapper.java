package com.skf.management.mapper;

import com.skf.management.model.EquipmentModel;
import com.skf.management.model.EquipmentModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	long countByExample(EquipmentModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int deleteByExample(EquipmentModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int insert(EquipmentModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int insertSelective(EquipmentModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	List<EquipmentModel> selectByExample(EquipmentModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	EquipmentModel selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int updateByExampleSelective(@Param("record") EquipmentModel record,
			@Param("example") EquipmentModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int updateByExample(@Param("record") EquipmentModel record, @Param("example") EquipmentModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int updateByPrimaryKeySelective(EquipmentModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_qpmt
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	int updateByPrimaryKey(EquipmentModel record);
}
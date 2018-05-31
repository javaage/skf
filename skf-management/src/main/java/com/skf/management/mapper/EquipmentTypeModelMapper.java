package com.skf.management.mapper;

import com.skf.management.model.EquipmentTypeModel;
import com.skf.management.model.EquipmentTypeModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentTypeModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	long countByExample(EquipmentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int deleteByExample(EquipmentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int insert(EquipmentTypeModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int insertSelective(EquipmentTypeModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	List<EquipmentTypeModel> selectByExampleWithBLOBs(EquipmentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	List<EquipmentTypeModel> selectByExample(EquipmentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	EquipmentTypeModel selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExampleSelective(@Param("record") EquipmentTypeModel record,
			@Param("example") EquipmentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExampleWithBLOBs(@Param("record") EquipmentTypeModel record,
			@Param("example") EquipmentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExample(@Param("record") EquipmentTypeModel record,
			@Param("example") EquipmentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByPrimaryKeySelective(EquipmentTypeModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByPrimaryKeyWithBLOBs(EquipmentTypeModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_QPMT_TYPE
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByPrimaryKey(EquipmentTypeModel record);
}
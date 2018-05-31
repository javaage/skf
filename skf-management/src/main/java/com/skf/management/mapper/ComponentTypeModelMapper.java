package com.skf.management.mapper;

import com.skf.management.model.ComponentTypeModel;
import com.skf.management.model.ComponentTypeModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComponentTypeModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	long countByExample(ComponentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int deleteByExample(ComponentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int insert(ComponentTypeModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int insertSelective(ComponentTypeModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	List<ComponentTypeModel> selectByExample(ComponentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	ComponentTypeModel selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExampleSelective(@Param("record") ComponentTypeModel record,
			@Param("example") ComponentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExample(@Param("record") ComponentTypeModel record,
			@Param("example") ComponentTypeModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByPrimaryKeySelective(ComponentTypeModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_CPCT
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByPrimaryKey(ComponentTypeModel record);
}
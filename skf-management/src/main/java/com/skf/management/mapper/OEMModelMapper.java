package com.skf.management.mapper;

import com.skf.management.model.OEMModel;
import com.skf.management.model.OEMModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OEMModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	long countByExample(OEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	int deleteByExample(OEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	int insert(OEMModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	int insertSelective(OEMModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	List<OEMModel> selectByExampleWithBLOBs(OEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	List<OEMModel> selectByExample(OEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	OEMModel selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	int updateByExampleSelective(@Param("record") OEMModel record, @Param("example") OEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	int updateByExampleWithBLOBs(@Param("record") OEMModel record, @Param("example") OEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	int updateByExample(@Param("record") OEMModel record, @Param("example") OEMModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	int updateByPrimaryKeySelective(OEMModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	int updateByPrimaryKeyWithBLOBs(OEMModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_OEM
	 * @mbg.generated  Tue Jun 05 16:50:42 CST 2018
	 */
	int updateByPrimaryKey(OEMModel record);
}
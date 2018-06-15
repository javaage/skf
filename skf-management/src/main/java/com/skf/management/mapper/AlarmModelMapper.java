package com.skf.management.mapper;

import com.skf.management.model.AlarmModel;
import com.skf.management.model.AlarmModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.skf.management.model.AlarmModelKey;

public interface AlarmModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	long countByExample(AlarmModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	int deleteByExample(AlarmModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	int deleteByPrimaryKey(AlarmModelKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	int insert(AlarmModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	int insertSelective(AlarmModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	List<AlarmModel> selectByExample(AlarmModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	AlarmModel selectByPrimaryKey(AlarmModelKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	int updateByExampleSelective(@Param("record") AlarmModel record, @Param("example") AlarmModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	int updateByExample(@Param("record") AlarmModel record, @Param("example") AlarmModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	int updateByPrimaryKeySelective(AlarmModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_ALRM
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	int updateByPrimaryKey(AlarmModel record);
}
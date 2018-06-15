package com.skf.management.mapper;

import com.skf.management.model.ScoreModel;
import com.skf.management.model.ScoreModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	long countByExample(ScoreModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	int deleteByExample(ScoreModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	int insert(ScoreModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	int insertSelective(ScoreModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	List<ScoreModel> selectByExample(ScoreModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	ScoreModel selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	int updateByExampleSelective(@Param("record") ScoreModel record, @Param("example") ScoreModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	int updateByExample(@Param("record") ScoreModel record, @Param("example") ScoreModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	int updateByPrimaryKeySelective(ScoreModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table skf_cmpt_score
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	int updateByPrimaryKey(ScoreModel record);
}
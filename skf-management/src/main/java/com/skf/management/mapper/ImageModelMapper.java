package com.skf.management.mapper;

import com.skf.management.model.ImageModel;
import com.skf.management.model.ImageModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageModelMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	long countByExample(ImageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int deleteByExample(ImageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int insert(ImageModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int insertSelective(ImageModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	List<ImageModel> selectByExampleWithBLOBs(ImageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	List<ImageModel> selectByExample(ImageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	ImageModel selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExampleSelective(@Param("record") ImageModel record, @Param("example") ImageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExampleWithBLOBs(@Param("record") ImageModel record, @Param("example") ImageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByExample(@Param("record") ImageModel record, @Param("example") ImageModelExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByPrimaryKeySelective(ImageModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByPrimaryKeyWithBLOBs(ImageModel record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SKF_IMG
	 * @mbg.generated  Thu May 31 18:00:54 CST 2018
	 */
	int updateByPrimaryKey(ImageModel record);
}
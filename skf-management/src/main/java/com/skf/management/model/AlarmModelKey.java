package com.skf.management.model;

public class AlarmModelKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column skf_alrm.CMPT_CODE
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	private String code;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column skf_alrm.ALRM_TYPE
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	private Integer type;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column skf_alrm.CMPT_CODE
	 * @return  the value of skf_alrm.CMPT_CODE
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column skf_alrm.CMPT_CODE
	 * @param code  the value for skf_alrm.CMPT_CODE
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column skf_alrm.ALRM_TYPE
	 * @return  the value of skf_alrm.ALRM_TYPE
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column skf_alrm.ALRM_TYPE
	 * @param type  the value for skf_alrm.ALRM_TYPE
	 * @mbg.generated  Mon Jun 11 18:01:21 CST 2018
	 */
	public void setType(Integer type) {
		this.type = type;
	}
}
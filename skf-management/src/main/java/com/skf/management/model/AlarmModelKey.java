package com.skf.management.model;

public class AlarmModelKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_ALRM.CMPT_CODE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private String code;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_ALRM.ALRM_TYPE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private Integer type;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_ALRM.CMPT_CODE
	 * @return  the value of SKF_ALRM.CMPT_CODE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_ALRM.CMPT_CODE
	 * @param code  the value for SKF_ALRM.CMPT_CODE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_ALRM.ALRM_TYPE
	 * @return  the value of SKF_ALRM.ALRM_TYPE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_ALRM.ALRM_TYPE
	 * @param type  the value for SKF_ALRM.ALRM_TYPE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setType(Integer type) {
		this.type = type;
	}
}
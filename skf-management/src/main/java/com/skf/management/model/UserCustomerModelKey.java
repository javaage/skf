package com.skf.management.model;

public class UserCustomerModelKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR_CSTM.USR_CODE
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	private String userCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR_CSTM.CSTM_CODE
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	private String customerCode;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR_CSTM.USR_CODE
	 * @return  the value of SKF_USR_CSTM.USR_CODE
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR_CSTM.USR_CODE
	 * @param userCode  the value for SKF_USR_CSTM.USR_CODE
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR_CSTM.CSTM_CODE
	 * @return  the value of SKF_USR_CSTM.CSTM_CODE
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR_CSTM.CSTM_CODE
	 * @param customerCode  the value for SKF_USR_CSTM.CSTM_CODE
	 * @mbg.generated  Fri Jun 15 18:04:35 CST 2018
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
}
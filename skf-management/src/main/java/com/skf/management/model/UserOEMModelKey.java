package com.skf.management.model;

public class UserOEMModelKey {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column skf_usr_oem.USR_CODE
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	private String userCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column skf_usr_oem.OEM_CODE
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	private String oemCode;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column skf_usr_oem.USR_CODE
	 * @return  the value of skf_usr_oem.USR_CODE
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column skf_usr_oem.USR_CODE
	 * @param userCode  the value for skf_usr_oem.USR_CODE
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column skf_usr_oem.OEM_CODE
	 * @return  the value of skf_usr_oem.OEM_CODE
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public String getOemCode() {
		return oemCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column skf_usr_oem.OEM_CODE
	 * @param oemCode  the value for skf_usr_oem.OEM_CODE
	 * @mbg.generated  Tue May 22 14:56:15 CST 2018
	 */
	public void setOemCode(String oemCode) {
		this.oemCode = oemCode;
	}
}
package com.skf.management.model;

import java.util.Date;

public class UserModel {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR.USR_CODE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private String code;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR.USR_NAME
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR.USR_COMPANY
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private String company;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR.USR_ADDRESS
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private String address;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR.USR_RL_ID
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private Integer roleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR.USR_PASSWORD
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR.USR_PHONE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private String phone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR.USR_EMAIL
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR.USR_LOGIN_TIME
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private Date loginTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SKF_USR.USR_IMG
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	private String img;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR.USR_CODE
	 * @return  the value of SKF_USR.USR_CODE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR.USR_CODE
	 * @param code  the value for SKF_USR.USR_CODE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR.USR_NAME
	 * @return  the value of SKF_USR.USR_NAME
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR.USR_NAME
	 * @param name  the value for SKF_USR.USR_NAME
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR.USR_COMPANY
	 * @return  the value of SKF_USR.USR_COMPANY
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR.USR_COMPANY
	 * @param company  the value for SKF_USR.USR_COMPANY
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR.USR_ADDRESS
	 * @return  the value of SKF_USR.USR_ADDRESS
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR.USR_ADDRESS
	 * @param address  the value for SKF_USR.USR_ADDRESS
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR.USR_RL_ID
	 * @return  the value of SKF_USR.USR_RL_ID
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR.USR_RL_ID
	 * @param roleId  the value for SKF_USR.USR_RL_ID
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR.USR_PASSWORD
	 * @return  the value of SKF_USR.USR_PASSWORD
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR.USR_PASSWORD
	 * @param password  the value for SKF_USR.USR_PASSWORD
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR.USR_PHONE
	 * @return  the value of SKF_USR.USR_PHONE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR.USR_PHONE
	 * @param phone  the value for SKF_USR.USR_PHONE
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR.USR_EMAIL
	 * @return  the value of SKF_USR.USR_EMAIL
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR.USR_EMAIL
	 * @param email  the value for SKF_USR.USR_EMAIL
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR.USR_LOGIN_TIME
	 * @return  the value of SKF_USR.USR_LOGIN_TIME
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR.USR_LOGIN_TIME
	 * @param loginTime  the value for SKF_USR.USR_LOGIN_TIME
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SKF_USR.USR_IMG
	 * @return  the value of SKF_USR.USR_IMG
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public String getImg() {
		return img;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SKF_USR.USR_IMG
	 * @param img  the value for SKF_USR.USR_IMG
	 * @mbg.generated  Fri Jun 15 17:32:09 CST 2018
	 */
	public void setImg(String img) {
		this.img = img;
	}
}
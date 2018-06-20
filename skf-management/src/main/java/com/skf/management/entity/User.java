package com.skf.management.entity;

import java.util.List;

import com.skf.management.model.UserCustomerModelKey;
import com.skf.management.model.UserModel;
import com.skf.management.model.UserOEMModelKey;
import com.skf.management.util.StringUtil;

public class User extends UserModel {

	private String passwordOne;
	private String passwordTwo;
	
	private String roleName;
	
	private List<UserOEMModelKey> oems;
	private List<UserCustomerModelKey> customers;
	
	private List<UserOEMEntity> userOems;
	private List<UserCustomerEntity> userCustomers;
	
	private List<String> cusGroup;
	private List<String> oemGroup;
	
	
	public List<UserOEMModelKey> getOems() {
		return oems;
	}
	public void setOems(List<UserOEMModelKey> oems) {
		this.oems = oems;
	}
	public List<UserCustomerModelKey> getCustomers() {
		return customers;
	}
	public void setCustomers(List<UserCustomerModelKey> customers) {
		this.customers = customers;
	}
	public List<UserOEMEntity> getUserOems() {
		return userOems;
	}
	public void setUserOems(List<UserOEMEntity> userOems) {
		this.userOems = userOems;
	}
	public List<UserCustomerEntity> getUserCustomers() {
		return userCustomers;
	}
	public void setUserCustomers(List<UserCustomerEntity> userCustomers) {
		this.userCustomers = userCustomers;
	}
	public List<String> getCusGroup() {
		return cusGroup;
	}
	public void setCusGroup(List<String> cusGroup) {
		this.cusGroup = cusGroup;
	}
	public List<String> getOemGroup() {
		return oemGroup;
	}
	public void setOemGroup(List<String> oemGroup) {
		this.oemGroup = oemGroup;
	}
	public String getPasswordOne() {
		return passwordOne;
	}
	public void setPasswordOne(String passwordOne) {
		this.passwordOne = passwordOne;
	}
	public String getPasswordTwo() {
		return passwordTwo;
	}
	public void setPasswordTwo(String passwordTwo) {
		this.passwordTwo = passwordTwo;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public static User newUserFormModel(UserModel model) throws Exception{
		User user = new User();
		
		user.setName(model.getName());
		user.setEmail(model.getEmail());
		user.setAddress(model.getAddress());
		user.setCode(model.getCode());
		user.setCompany(model.getCompany());
		user.setImg(model.getImg());
		user.setLoginTime(model.getLoginTime());
		user.setPassword(StringUtil.decodeBase64(model.getPassword()));
		user.setPhone(model.getPhone());
		user.setRoleId(model.getRoleId());
		
		return user;
	}
	
	public static UserModel newModelFormUser(User user)throws Exception{
		UserModel model = new UserModel();
		
		model.setName(user.getName());
		model.setEmail(user.getEmail());
		model.setAddress(user.getAddress()==null?"":user.getAddress());
		model.setCode(user.getCode());
		model.setCompany(user.getCompany()==null?"":user.getCompany());
		model.setImg(user.getImg());
		model.setLoginTime(user.getLoginTime());
		model.setPassword(StringUtil.encodeBase64(user.getPassword()));
		model.setPhone(user.getPhone());
		model.setRoleId(user.getRoleId());
		
		return model;
	}
}

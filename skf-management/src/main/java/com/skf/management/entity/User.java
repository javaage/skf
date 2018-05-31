package com.skf.management.entity;

import java.util.List;

import com.skf.management.model.UserCustomerModelKey;
import com.skf.management.model.UserModel;
import com.skf.management.model.UserOEMModelKey;

public class User extends UserModel {
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
	private List<UserOEMModelKey> oems;
	private List<UserCustomerModelKey> customers;
}

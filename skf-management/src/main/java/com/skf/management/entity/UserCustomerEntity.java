package com.skf.management.entity;

import com.skf.management.model.UserCustomerModelKey;

public class UserCustomerEntity extends UserCustomerModelKey{
	
	public String ifChecked;
	public String name;
	public String code;

	public String getIfChecked() {
		return ifChecked;
	}

	public void setIfChecked(String ifChecked) {
		this.ifChecked = ifChecked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
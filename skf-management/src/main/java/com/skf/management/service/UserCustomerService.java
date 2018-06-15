package com.skf.management.service;

import java.util.List;

import com.skf.management.entity.UserCustomerEntity;
import com.skf.management.model.UserCustomerModelKey;

public interface UserCustomerService {
	List<UserCustomerModelKey> list();

	void add(UserCustomerModelKey model);

	List<UserCustomerModelKey> getCustomerByCode(String code);
	
	List<UserCustomerEntity> getCustomerListByCode(String code);

	void delete(String code);
}

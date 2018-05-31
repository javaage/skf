package com.skf.management.service;

import java.util.List;

import com.skf.management.join.CustomerJoin;
import com.skf.management.model.CustomerModel;

public interface CustomerService {
	List<CustomerModel> list();
	
	List<CustomerModel> listWithBLOBs();
	
	List<CustomerJoin> listTree(String code);
	
	List<CustomerModel> listByOwner(String code);
	
	void add(CustomerModel model);

	CustomerModel getCustomerByCode(String code);

	void update(CustomerModel model);
	
	void updateWithBLOBs(CustomerModel model);

	void delete(String code);
	
	void deleteByOwner(String code);
}
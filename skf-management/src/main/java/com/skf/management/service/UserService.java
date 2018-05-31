package com.skf.management.service;

import java.util.List;

import com.skf.management.model.UserModel;

public interface UserService {
	List<UserModel> list();
	
	List<UserModel> listWithBLOBs();
	
	void add(UserModel model);

	UserModel getUserByCode(String code);

	void update(UserModel model);
	
	void updateWithBLOBs(UserModel model);

	void delete(String code);
}

package com.skf.management.service;

import java.util.List;
import java.util.Map;

import com.skf.management.entity.Page;
import com.skf.management.entity.User;
import com.skf.management.model.UserModel;

public interface UserService {
	List<UserModel> list();
	
	Map<String, Object>  getCountByUserInfo(User model);
	
	Page listPage(int currentPage);
	
	List<UserModel> listWithBLOBs();
	
	UserModel add(UserModel model);
	
	void add(User user)throws Exception;

	UserModel getUserByCode(String code);
	
	User getUserAllByCode(String code)throws Exception;

	void update(UserModel model)throws Exception;
	
	boolean update(User model)throws Exception;
	
	void updateWithBLOBs(UserModel model) throws Exception;

	void delete(String code);

	void delete(List<String> code);

	List<com.skf.management.model.User> login(String username,String password);
	
	boolean checkToken(String username,String usercode);
	
	List<String> getUsrOemList(String usercode);
	
	List<String> getUsrCstmList(String usercode);
	
	int getUserRoleId(String usercode);

}

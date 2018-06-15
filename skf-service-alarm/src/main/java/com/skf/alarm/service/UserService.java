package com.skf.alarm.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.skf.alarm.model.User;

public interface UserService {

	
	List<User> login(String username,String password);
	
	boolean checkToken(String username,String usercode);
	
	List<String> getUsrOemList(String usercode);
	
	List<String> getUsrCstmList(String usercode);
	
	int getUserRoleId(String usercode);
}

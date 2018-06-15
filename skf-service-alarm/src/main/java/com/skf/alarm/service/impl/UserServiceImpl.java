package com.skf.alarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.alarm.mapper.LoginMapper;
import com.skf.alarm.model.User;
import com.skf.alarm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private LoginMapper mapper;
	
	@Override
	public List<User> login(String username, String password) {
		List<User> users = mapper.getUserCode(username,username,password);
		return users;
	}
	
	@Override
	public boolean checkToken(String username, String usercode) {
		Long count= mapper.checkToken(username,username,usercode);
		if(count==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<String> getUsrOemList(String usercode) {
		return mapper.getUsrOemList(usercode);
	}

	@Override
	public List<String> getUsrCstmList(String usercode) {
		return mapper.getUsrCstmList(usercode);
	}
	
	@Override
	public int getUserRoleId(String usercode) {
		return mapper.getUsrRoleId(usercode);
	}
}

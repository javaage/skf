package com.skf.management.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.skf.management.model.User;

public interface LoginMapper {
	
	List<String> getUsrCstmList(String usercode);
	
	List<String> getUsrOemList(String usercode);
	
	Long checkToken(@Param("username") String username,@Param("useremail") String useremail, @Param("usercode") String usercode);
	
	List<User> getUserCode(@Param("username") String username,@Param("useremail") String useremail, @Param("password") String password);

	int getUsrRoleId(String usercode);
}
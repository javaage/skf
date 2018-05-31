package com.skf.management.service;

import java.util.List;

import com.skf.management.model.UserOEMModelKey;

public interface UserOEMService {
	List<UserOEMModelKey> list();

	void add(UserOEMModelKey model);

	List<UserOEMModelKey> getOEMByCode(String code);

	void delete(String code);
}

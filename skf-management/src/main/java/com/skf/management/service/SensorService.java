package com.skf.management.service;

import java.util.List;

import com.skf.management.model.SensorModel;

public interface SensorService {
	List<SensorModel> list();

	List<SensorModel> listByOwner(String code);	
	
	void add(SensorModel model);

	SensorModel getSensorByCode(String code);

	void update(SensorModel model);

	void delete(String code);
	
	void deleteByOwner(String code);
}

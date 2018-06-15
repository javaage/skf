package com.skf.management.service;

import java.util.List;

import com.skf.management.join.ComponentJoin;
import com.skf.management.model.ComponentModel;

public interface ComponentService {
	List<ComponentModel> list();

	List<ComponentModel> listByOwner(String code);	
	
	void add(ComponentModel model);

	ComponentModel getComponentByCode(String code);

	void update(ComponentModel model);

	void delete(String code);
	
	void deleteByOwner(String code);
	
	List<ComponentJoin> getComponentScoreByOwerID(String sensorCode);
	
	ComponentJoin getComponentScoreByID(String componentCode);
}

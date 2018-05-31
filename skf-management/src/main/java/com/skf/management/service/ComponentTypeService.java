package com.skf.management.service;

import java.util.List;

import com.skf.management.model.ComponentTypeModel;

public interface ComponentTypeService {
	List<ComponentTypeModel> list();

	void add(ComponentTypeModel model);

	ComponentTypeModel getComponentTypeByCode(int id);

	void update(ComponentTypeModel model);

	void delete(int id);
}

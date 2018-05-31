package com.skf.management.service;

import java.util.List;

import com.skf.management.model.EquipmentTypeModel;

public interface EquipmentTypeService {
	List<EquipmentTypeModel> list();
	
	List<EquipmentTypeModel> listWithBLOBs();

	List<EquipmentTypeModel> listByOwner(String code);	
	
	void add(EquipmentTypeModel model);

	EquipmentTypeModel getEquipmentTypeByCode(String code);

	void update(EquipmentTypeModel model);
	
	void updateWithBLOBs(EquipmentTypeModel model);

	void delete(String code);
	
	List<EquipmentTypeModel> listImgs(List<String> listType);
	
	void deleteByOwner(String code);
}
